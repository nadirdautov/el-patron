package com.geekbrains.server.authorization;

import java.sql.SQLException;

public interface AuthService {
    void start();
    String getNickNameByLoginAndPassword( String login, String password) throws UserNotFoundException;

    void end();
    boolean loginIsBusy(String login) throws SQLException;
    void addClient(String id, String login, String password);
}
