package com.geekbrains.server.authorization;

import java.sql.SQLException;
import java.util.Map;

public class AuthServiceDbConnection implements AuthService {
    private static ConnectionDb connectionDb;

    public static Map<String,UserData> getUsers() throws SQLException {
        return connectionDb.selectAll();
    }
    @Override
    public void start() {
        try {
            connectionDb = ConnectionDb.getConnectionDb();
            System.out.println("Authentication service initialized");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public String getNickNameByLoginAndPassword(String login, String password) throws UserNotFoundException {
            return connectionDb.select(login,password);

    }

    @Override
    public void end() {
        try {
            connectionDb.disconnect();
            System.out.println("Authentication broken");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean loginIsBusy(String login) throws SQLException {
        return connectionDb.findLogin(login);
    }

    @Override
    public void addClient(String nickname, String login, String password) {
        try {
            connectionDb.insert(nickname,login,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
