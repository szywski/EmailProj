package org.openjfx;

import java.io.IOException;
import java.util.*;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PrimaryController extends Stage {

    StringBuilder address;
    ArrayList<User> userList;


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
    ArrayList<User>arrObjList = new ArrayList<>();


    public PrimaryController(){
        address = new StringBuilder();
        userList = new ArrayList<>();
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

            address.append(name + ".");
            address.append(lastName + "@");
            address.append(department);
            address.append("company.com");

            var email = address.toString();
            LBLStatus.setText(email);
            user.eMail = email;
            arrObjList.add(user);
            listViewList.add(user.toString());
            LVMail.refresh();
            LVMail.setItems(listViewList);


        }

    }

    @FXML
    public void changePassword(){}




}
