package com.example.demo3.database.models;

import java.sql.SQLException;

public class CreateTables extends DBConection{

    private static final String SQL_CREATE_USER = "CREATE TABLE IF NOT EXISTS users"
            + "("
            + " ID serial,"
            + " NAME varchar(50) NOT NULL,"
            + " EMAIL varchar(50) NOT NULL,"
            + " PASSWORD varchar(50) NOT NULL,"
            + "STATUS int,"
            + " PRIMARY KEY (ID)"
            + ")";
    private static final String SQL_CREATE_SCORE = "CREATE TABLE IF NOT EXISTS scores("+
            "player1id int, "+
            "player2id int," +
            "score int default -1," +
            "primary key (player1id,player2id)," +
            "foreign key(player1id) references users(id)," +
            "foreign key(player2id) references users(id)" +
            ")";

    public void createTableUsers() throws SQLException {
        statement = connect().createStatement();
        resultSet = statement.executeQuery(SQL_CREATE_USER);
    }
    public void createTableScore()throws Exception{
        statement = connect().createStatement();
        resultSet = statement.executeQuery(SQL_CREATE_SCORE);
    }
}
