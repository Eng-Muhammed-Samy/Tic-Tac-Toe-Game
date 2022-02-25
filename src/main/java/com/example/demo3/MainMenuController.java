package com.example.demo3;


import com.example.demo3.database.models.ScoreFunctionality;
import com.example.demo3.database.models.UserFunctionality;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @FXML
    private TableColumn<UserModel, String> name;

    @FXML
    private TableColumn<UserModel, Integer> score;

    @FXML
    private TableColumn<UserModel,Integer> status;

    @FXML
    private TableView<UserModel> table;
    @FXML
    private Button newGame;

    ObservableList<UserModel> users = FXCollections.observableArrayList(
            new UserModel("rehab",1,30),
            new UserModel("sondos",1,40)
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<UserModel,String>("name"));
        score.setCellValueFactory(new PropertyValueFactory<UserModel,Integer>("score"));
        status.setCellValueFactory(new PropertyValueFactory<UserModel,Integer>("status"));
//        try {
//            ResultSet res=  new UserFunctionality().selectAllUsers();
//            ScoreFunctionality scoreFunctionality = new ScoreFunctionality();
//            while(res.next())
//            {
//                users.add(new UserModel(res.getString("name"),scoreFunctionality.sumOfScoresForLoginUser(res.getString("name")),res.getInt("status")));
//            }
//            table.setItems(users);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

newGame.setOnAction((e)->{
    GlobalOperation.changeScene(e,"modes");
});
    }
}
