package Java2Lesson7.server;

import Java2Lesson7.CommonConstants;
import Java2Lesson7.server.authorization.AuthService;
import Java2Lesson7.server.authorization.InMemoryAuthServiceImpl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private AuthService authService;

    private List<ClientHandler> connectedUsers;

    public Server(){
        authService = new InMemoryAuthServiceImpl();
        try(ServerSocket server =  new ServerSocket(CommonConstants.SERVER_PORT)){
            authService.start();
            connectedUsers = new ArrayList<>();
            while (true){
                System.out.println("Сервер ожидает подключения");
                Socket socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this,socket);
            }
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Ошибка в работе сервера");
        }finally {
            if(authService != null){
                authService.end();
            }
        }
    }
    public AuthService getAuthService() {
        return authService;
    }
    public boolean isNickNameBusy(String nickName){
        for (ClientHandler handler: connectedUsers){
            if(handler.getNickName().equals(nickName)){
                return true;
            }
        }
        return false;
    }

    public synchronized void broadcastMessage(String message){
        for (ClientHandler handler: connectedUsers){
            handler.sendMessage(message);
        }
    }

    public synchronized boolean privateMessage(String nickNameBy,String nickNameTo, String message){
        for (ClientHandler handler: connectedUsers){
            if(handler.getNickName().equals(nickNameTo)){
                handler.sendMessage("from" + nickNameBy + "\n " + message);
                return true;
            }
        }
        return false;
    }
    public synchronized void addConnectedUser(ClientHandler handler){
        connectedUsers.add(handler);
    }
    public synchronized void disconnectedUser(ClientHandler handler){
        connectedUsers.remove(handler);
    }
}
