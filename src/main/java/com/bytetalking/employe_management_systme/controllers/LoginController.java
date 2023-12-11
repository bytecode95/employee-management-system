package com.bytetalking.employe_management_systme.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;


public class LoginController {
    @FXML
    private Button loginBtn;

    @FXML
    private AnchorPane mainForm;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }


    @FXML
    void login(ActionEvent event) {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        //load connector--driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system", "root", "Vira@95714");
            //create sql query
            PreparedStatement stm = connection.prepareStatement("select * from admin where username=? and password=?");
            stm.setObject(1, username);
            stm.setObject(2, password);

            ResultSet resultSet = stm.executeQuery();
            if(txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill both fields");
                alert.show();
            }else{
                if(resultSet.next()){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Logged!");
                    alert.show();

                    loginBtn.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard-view.fxml")));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.show();


                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Username or password incorrect. Please try again!");
                    alert.show();
                }
            }



        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
