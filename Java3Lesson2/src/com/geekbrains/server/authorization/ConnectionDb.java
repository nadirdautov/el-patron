package com.geekbrains.server.authorization;

import java.sql.*;
import java.util.HashMap;

public class ConnectionDb {
    private static Connection connection;
    private static Statement statement;
    private static ConnectionDb connectionDb;
    private static String URL = "jdbc:postgresql://localhost:5432/connection_db";
    private static String USER = "postgres";
    private static String PASSWORD = "hyperxxx";

    public static ConnectionDb getConnectionDb() throws SQLException {
        connectionDb = new ConnectionDb();
        return connectionDb;
    }

    private ConnectionDb() throws SQLException {
        connect();
    }

    private static void connect() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        statement = connection.createStatement();
    }

    public void insert(String nickname, String login, String password) throws SQLException {
        statement.executeUpdate(String.format("INSERT INTO users(nickname, login, password) values ('%s','%s','%s');", nickname, login, password));
    }

    public String select(String login, String password) throws UserNotFoundException {
        try (ResultSet resultSet = statement.executeQuery(String.format("SELECT nickname from users where login = '%s' AND password = '%s';", login, password));) {
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new UserNotFoundException("User is not found");
    }

    public HashMap<String, UserData> selectAll() throws SQLException {
        HashMap<String, UserData> hashMap = new HashMap<>();
        try (ResultSet resultSet = statement.executeQuery("SELECT * FROM users;")) {
            while (resultSet.next()) {
                UserData user = new UserData(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
                hashMap.put(user.getLogin(), user);
            }
        }
        return hashMap;
    }

    public boolean findLogin(String login) throws SQLException {
        try (ResultSet rs = statement.executeQuery(String.format("SELECT login FROM users WHERE login = '%s';", login))) {
            while (rs.next()) {
                String loginColumn = rs.getString("login");
                if (loginColumn.equals(login)) ;
                return true;
            }
            return false;
        }
    }


    public void disconnect() throws SQLException{
        if (connection != null){
            connection.close();
        }
    }
}
