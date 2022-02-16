package com.example.demo3.database.models;

import com.example.demo3.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserFunctionality extends DBConection{
    public void insertUser(User user) throws SQLException {
        String insertQuery = "INSERT INTO users(NAME, EMAIL, PASSWORD, STATUS) VALUES(?,?,?,?)";
        preparedStatement = connect().prepareStatement(insertQuery);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2,user.getEmail());
        preparedStatement.setString(3,user.getPassword());
        preparedStatement.setInt(4,user.getStatus());
        resultSet = preparedStatement.executeQuery();
    }

    public ResultSet selectAllUsers() throws SQLException{
        String selectAllUsersQuery = "SELECT * FROM users";
        statement = connect().createStatement();
        resultSet = statement.executeQuery(selectAllUsersQuery);
        return resultSet;
    }
    public ResultSet selectUserByEmail(String email) throws SQLException{
        String selectUserByEmailQuery = "SELECT * FROM users WHERE EMAIL = ?";
        preparedStatement = connect().prepareStatement(selectUserByEmailQuery);
        preparedStatement.setString(1, email);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("NAME"));
            System.out.println(resultSet.getString("EMAIL"));
            System.out.println(resultSet.getString("PASSWORD"));
        }
        return resultSet;
    }

    public ResultSet selectUserByStatus(int status) throws SQLException{
        String selectUserByEmailQuery = "SELECT * FROM users WHERE STATUS = ?";
        preparedStatement = connect().prepareStatement(selectUserByEmailQuery);
        preparedStatement.setInt(1, status);
        resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()){
//            System.out.println(resultSet.getString("NAME"));
//            System.out.println(resultSet.getString("EMAIL"));
//            System.out.println(resultSet.getString("PASSWORD"));
//        }
        return resultSet;
    }

    public void updateStatusByEmail(int status, String email) throws SQLException{
        String updateStatusOfUserByEmail = "UPDATE users SET STATUS = ? WHERE EMAIL = ?";
        preparedStatement = connect().prepareStatement(updateStatusOfUserByEmail);
        preparedStatement.setInt(1, status);
        preparedStatement.setString(2, email);
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            System.out.println("done");
        }
    }
}
