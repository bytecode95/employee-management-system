package com.bytetalking.employe_management_systme;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.sql.*;


public class MainController {
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


        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
