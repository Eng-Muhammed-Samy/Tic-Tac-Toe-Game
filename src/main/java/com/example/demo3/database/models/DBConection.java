package com.example.demo3.database.models;

import java.sql.*;

public class DBConection {

    protected Statement statement;
    protected ResultSet resultSet;
    protected PreparedStatement preparedStatement;

    protected Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:postgresql://localhost/tictactoe";
            String user = "postgres";
            String password = "medo";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


}
