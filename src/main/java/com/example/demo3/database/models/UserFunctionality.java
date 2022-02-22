package com.example.demo3.database.models;

import com.example.demo3.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserFunctionality extends DBConection{
    public void insertUser(User user) throws SQLException {
        String insertQuery = "INSERT INTO users(NAME, PASSWORD, STATUS) VALUES(?,?,?)";
        preparedStatement = connect().prepareStatement(insertQuery);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setInt(3,user.getStatus());
        preparedStatement.executeUpdate();
    }

    public ResultSet selectAllUsers() throws SQLException{
        String selectAllUsersQuery = "SELECT * FROM users";
        statement = connect().createStatement();
        resultSet = statement.executeQuery(selectAllUsersQuery);
        return resultSet;
    }

    public String selectUserByUserName(String userName) throws SQLException{
        String selectUserByEmailQuery = "SELECT * FROM users WHERE NAME = ?";
        preparedStatement = connect().prepareStatement(selectUserByEmailQuery);
        preparedStatement.setString(1, userName);
        resultSet = preparedStatement.executeQuery();
        String user = "";
        while (resultSet.next()){
            user = resultSet.getString("name");
        }
       return user;
    }

    public boolean ifUserFound(String userName)throws SQLException{
        String selectUserByEmailQuery = "SELECT * FROM users WHERE NAME = ?";
        preparedStatement = connect().prepareStatement(selectUserByEmailQuery);
        preparedStatement.setString(1, userName);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            return true;
        }
        return false;
    }

    public  String SelectPasswordForUser(String userName)throws Exception{
        String selectUserByEmailQuery = "SELECT password FROM users WHERE NAME = ?";
        preparedStatement = connect().prepareStatement(selectUserByEmailQuery);
        preparedStatement.setString(1, userName);
        resultSet = preparedStatement.executeQuery();
        String pass = "";
        while (resultSet.next()){
            pass = resultSet.getString("password");
        }
        return pass;
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

    public void updateStatusByUsername(int status, String username) throws SQLException{
        String updateStatusOfUserByEmail = "UPDATE users SET STATUS = ? WHERE NAME = ?";
        preparedStatement = connect().prepareStatement(updateStatusOfUserByEmail);
        preparedStatement.setInt(1, status);
        preparedStatement.setString(2, username);
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            System.out.println("done");
        }
    }
}
