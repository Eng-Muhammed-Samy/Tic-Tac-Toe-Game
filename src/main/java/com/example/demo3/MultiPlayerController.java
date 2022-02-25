package com.example.demo3;

import com.example.demo3.database.models.ScoreFunctionality;
import com.example.demo3.database.models.UserFunctionality;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MultiPlayerController implements Initializable {

        @FXML
        private TableColumn<UserModel, Integer> invitation;

        @FXML
        private TableColumn<UserModel, String> name;

        @FXML
        private TableColumn<UserModel, Integer> score;

        @FXML
        private TableColumn<UserModel, Integer> status;

        @FXML
        private TableView<UserModel> table;

ObservableList<UserModel> users = FXCollections.observableArrayList(
            new UserModel("rehab",1,30,new Button("invite")),
            new UserModel("sondos",1,40,new Button("invite"))
    );

    ResultSet res;
    Button invitationButton = new Button("invite");

//    ScoreFunctionality scoreFunctionality = new ScoreFunctionality();

////    {
////
////        try {
////            res = new UserFunctionality().selectAllUsers();
////            while(res.next()) {
////                Button invitationButton = new Button("invite");
////                //if 0 so it is available
////                if (res.getInt("status") == 0) {
////                    invitationButton.setDisable(false);
////                } else {
////                    invitationButton.setDisable(true);
////                }
////                users.add(new UserModel(res.getString("name"), scoreFunctionality.sumOfScoresForLoginUser(res.getString("name")), res.getInt("status"), invitationButton));
////            }
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////
////
////
//
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<UserModel,String>("name"));
        score.setCellValueFactory(new PropertyValueFactory<UserModel,Integer>("score"));
        status.setCellValueFactory(new PropertyValueFactory<UserModel,Integer>("status"));
        invitation.setCellValueFactory(new PropertyValueFactory<UserModel,Integer>("invitation"));
        table.setItems(users);
    }
}
