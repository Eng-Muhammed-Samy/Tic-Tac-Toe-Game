package com.example.demo3.database.models;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardFunctionality extends DBConection{
    String board[] = {"","","","","","","","",""};
    String strDate;
    UserFunctionality uf = new UserFunctionality();
    public void insertIntoBoard(String []board, String name) throws SQLException {
        String query = "INSERT INTO board values(?,?,?,?,?,?,?,?,?,?,?)";
        preparedStatement = connect().prepareStatement(query);
        for(int i = 0; i < board.length; i++){
            preparedStatement.setString(i+1, board[i]);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        strDate = formatter.format(date);
        int userid = uf.getIdByUsername(name);
        preparedStatement.setInt(10, userid);
        preparedStatement.setString(11, strDate);
        preparedStatement.executeUpdate();
    }

    public String[] retrieveBoard(String username, String myDate)throws SQLException{
        String query = "Select cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9 format board where id = ? and dateTime = ?";
        preparedStatement = connect().prepareStatement(query);
        int id = uf.getIdByUsername(username);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2,myDate);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            board[0] = resultSet.getString("cell1");
            board[1] = resultSet.getString("cell2");
            board[2] = resultSet.getString("cell3");
            board[3] = resultSet.getString("cell4");
            board[4] = resultSet.getString("cell5");
            board[5] = resultSet.getString("cell6");
            board[6] = resultSet.getString("cell7");
            board[7] = resultSet.getString("cell8");
            board[8] = resultSet.getString("cell9");
        }
        return board;
    }
}
