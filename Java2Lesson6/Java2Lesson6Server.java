package Java2Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Java2Lesson6Server {

    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private Scanner scanner;

    public Java2Lesson6Server() {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Сервер запущен");
            scanner = new Scanner(System.in);
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            System.out.println("Пару слов клиенту: ");
                            String text = scanner.nextLine();
                            if(text.equals("/end")) {
                                sendMessage(text);
                                try {
                                    outputStream.close();
                                    inputStream.close();
                                    socket.close();
                                } catch (IOException exception) {
                                    exception.printStackTrace();
                                }

                                System.exit(1);
                            } else {
                                sendMessage(text);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String message = inputStream.readUTF();
                            System.out.println(message);
                        }
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        try {
            outputStream.writeUTF(message);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Java2Lesson6Server();
    }
}