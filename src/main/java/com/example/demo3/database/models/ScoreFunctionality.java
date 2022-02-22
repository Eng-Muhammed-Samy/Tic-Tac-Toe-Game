package com.example.demo3.database.models;

import java.sql.SQLException;

public class ScoreFunctionality extends DBConection{

    public int selectScoreWithSpecificUser(String player1Name,String player2Name) throws SQLException {
        int player1Id =0, player2Id =0;
        String id1 = "SELECT id FROM users where name = ?";
        preparedStatement = connect().prepareStatement(id1);
        preparedStatement.setString(1, player1Name);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            player1Id = resultSet.getInt("id");
        }
        String id2 = "SELECT id FROM users where name = ?";
        preparedStatement = connect().prepareStatement(id2);
        preparedStatement.setString(1, player2Name);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            player2Id = resultSet.getInt("id");
        }
        String Query = "SELECT score from scores where player1id = ? and player2id = ?";
        preparedStatement = connect().prepareStatement(Query);
        preparedStatement.setInt(1, player1Id);
        preparedStatement.setInt(2,player2Id);
        resultSet = preparedStatement.executeQuery();
        int score = -1;
         while (resultSet.next()){
            score = resultSet.getInt("score");
        }
        return score;
    }

    public int sumOfScoresForLoginUser(String name) throws SQLException {
        String id = "SELECT id FROM users WHERE name = ?";
        String query = "SELECT sum(score) as score FROM scores where player1id = ?";
        preparedStatement = connect().prepareStatement(id);
        preparedStatement.setString(1,name);
        resultSet = preparedStatement.executeQuery();
        int playerId =0;
        while(resultSet.next()){
            playerId = resultSet.getInt("ID");
        }
        preparedStatement = connect().prepareStatement(query);
        preparedStatement.setInt(1, playerId);
        resultSet = preparedStatement.executeQuery();
        int sumScore =0;
        while(resultSet.next()){
            sumScore = resultSet.getInt("score");
        }
    return sumScore;
    }

    public void insertUserScore(String player1Name, String player2Name, int score)throws SQLException{
        int p1Id =0, p2Id =0;
        String id1 = "SELECT id FROM users where name = ?";
        preparedStatement = connect().prepareStatement(id1);
        preparedStatement.setString(1, player1Name);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            p1Id = resultSet.getInt("id");
        }
        String id2 = "SELECT id FROM users where name = ?";
        preparedStatement = connect().prepareStatement(id2);
        preparedStatement.setString(1, player2Name);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            p2Id = resultSet.getInt("id");
        }
        int score1 = this.selectScoreWithSpecificUser(player1Name, player2Name);
        String query;
        if(score1 == -1) {
            query = "INSERT INTO scores (player1Id, player2Id, score) values(?,?,?)";
            preparedStatement = connect().prepareStatement(query);
            preparedStatement.setInt(1, p1Id);
            preparedStatement.setInt(2, p2Id);
            preparedStatement.setInt(3, score);
        }else{
            query = "UPDATE  scores SET score = ? where player1id =? and player2id = ?";
            preparedStatement = connect().prepareStatement(query);
            preparedStatement.setInt(1, score);
            preparedStatement.setInt(2, p1Id);
            preparedStatement.setInt(3, p2Id);
        }
        preparedStatement.executeUpdate();
    }

}
