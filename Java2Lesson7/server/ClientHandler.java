package Java2Lesson7.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private final Socket socket;
    private final Server server;
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public ClientHandler(Server server, Socket socket){
        try {
            this.server = server;
            this.socket = socket;
            this.inputStream = new DataInputStream(socket.getInputStream());
            this.outputStream = new DataOutputStream(socket.getOutputStream());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        authentication();
                        readMessages();
                    }catch (IOException exception){
                        exception.printStackTrace();
                    }finally {
                        closeConnection();
                    }
                }
            }).start();
        }catch (IOException e){
            throw new RuntimeException("Проблема при создании обработчика");
        }
    }

    private void authentication() throws IOException {
        while (true) {
            String message = inputStream.readUTF();
            if (message.startsWith(ServerCommandConstants.AUTHORIZATION)) {
                String[] authInfo = message.split("\\s");
                String nickName = server.getAuthService().getNickNameByLoginAndPassword(authInfo[1], authInfo[2]);
                if (nickName != null) {
                    if(!server.isNickNameBusy(nickName)){
                        sendMessage("/authok " + nickName);
                        this.nickName = nickName;
                        server.broadcastMessage(nickName + " зашёл в чат");
                        server.addConnectedUser(this);
                        return;
                    } else {
                        sendMessage("Учетная запись уже используется");
                    }
                }else {
                    sendMessage("Неверный логин или пароль");
                }
            }
        }
    }
    public void readMessages() throws IOException {
        while (true) {
            String messageInChat = inputStream.readUTF();
            System.out.println("от " + nickName + ": " + messageInChat);
            if (messageInChat.startsWith(ServerCommandConstants.SHUTDOWN)) {
                return;
            }
            if (messageInChat.startsWith(ServerCommandConstants.PRIVATE_MESSAGE)) {
                String[] prvMessage = messageInChat.split("\\s", 3);
                if (server.privateMessage(nickName, prvMessage[1], prvMessage[2])) {
                    sendMessage("from " + nickName + "\n " + prvMessage[2]);
                } else {
                    sendMessage("Invalid private message format" + prvMessage[1]);
                }

            } else {
                server.broadcastMessage(nickName + ": " + messageInChat);
            }
        }
    }

    private void closeConnection(){
        server.disconnectedUser(this);
        server.broadcastMessage(nickName + " вышел из чата");
        try {
            outputStream.close();
            inputStream.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    public void sendMessage(String message){
        try {
            outputStream.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
