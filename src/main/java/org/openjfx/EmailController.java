package org.openjfx;

import java.io.IOException;
import java.util.*;
import java.lang.Object;
import java.lang.String;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;
import javafx.scene.control.*;
import org.apache.commons.lang3.RandomStringUtils;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class EmailController extends Stage {


    ArrayList<User> userList;
    Logger logger = LoggerFactory.getLogger(EmailController.class);


    @FXML
    Button BExit;
    @FXML
    Button BGenerate;
    @FXML
    TextField TFName;
    @FXML
    TextField TFLastName;
    @FXML
    TextField TFDepartment;
    @FXML
    Label LBLStatus;
    @FXML
    ListView LVMail;
    ObservableList<String> listViewList = FXCollections.observableArrayList();
    ArrayList<User>arrObjList = new ArrayList<User>();


    public EmailController(){

        userList = new ArrayList<>();
        setTitle("Email generator");
    }


    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    public void generateMail(ActionEvent e){

        if(TFLastName.getText().isBlank() || TFName.getText().isBlank()){
            LBLStatus.setText("Name or Last Name is empty");
        }else {
            User user = new User();
            var name = TFName.getText();
            var lastName = TFLastName.getText();
            var department = Optional.ofNullable(TFDepartment.getText()+".").orElse("");

            user.name = name;
            user.lastName = lastName;
            user.department = department;
            user.generateEmailAddress();
            user.generateRandomPassword();

            LBLStatus.setText(user.eMail);
            arrObjList.add(user);
            listViewList.add(user.toString());
            LVMail.refresh();
            LVMail.setItems(listViewList);
            logger.info("Added user {}",user.eMail);


        }

    }

    @FXML
    public void changePassword(){
        int indx = LVMail.getSelectionModel().getSelectedIndex();
        User tmp_user = arrObjList.get(indx);
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Change Password");
        dialog.setContentText("New Password: ");



        Optional<String> result = dialog.showAndWait();
        if (!result.isEmpty()){
            tmp_user.changeUserPassword(result.get());
            logger.info("password of {} changed",tmp_user.eMail);
            listViewList.remove(indx);
            listViewList.add(indx,tmp_user.toString());
            LVMail.setItems(listViewList);
            LVMail.refresh();

        }else logger.info("password of {} hasnt been changed",tmp_user.eMail);


    }
    @FXML
    public void exit(ActionEvent e){
        System.exit(0);
        logger.info("Exit program");
}



}
