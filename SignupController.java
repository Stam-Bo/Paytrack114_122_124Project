package com.example.fxnew;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

import java.sql.*;

import java.io.IOException;
import java.sql.Connection;

public class SignupController {

    @FXML
    private TextField AgeBox;

    @FXML
    private TextField CityBox;

    @FXML
    private Label signupmsg;

    @FXML
    private TextField FirstNameBox;

    @FXML
    private TextField iniamount;

    @FXML
    private TextField LastNameBox;

    @FXML
    private TextField PassBox;

    @FXML
    private TextField CustomerIDBox;

    @FXML
    private Button spLoginButton;

    @FXML
    private BorderPane spBorderPane;

    @FXML
    void spSignUpAction(ActionEvent event)throws Exception {

        String  First = FirstNameBox.getText().toString();
        String  Last = LastNameBox.getText().toString();
        String custid = CustomerIDBox.getText().toString();
        String Pass = PassBox.getText().toString();
        String city = CityBox.getText().toString();
        String iniamt = iniamount.getText().toString();
        DatabaseConnection dbc = new DatabaseConnection();
        Connection connection = dbc.getConnection();

        String cnt = "SELECT COUNT(*) FROM customer";
        int count = 0;
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(cnt);
            while(res.next()){
                count = res.getInt(1);
            }
            String create = "INSERT INTO customer(customerId,LastName,FirstName,City,Password,Balance) VALUES ('"+custid+ "','"+Last+ "','"+First+ "','"+city+ "','"+Pass+ "','"+iniamt+ "')";
            int rs = -1;
            rs = st.executeUpdate(create);
            st.close();
            signupmsg.setText("Successful Sign Up,Please Login");
        }catch(Exception e) {
            signupmsg.setText("Sign Up Failed!!");
        }
        connection.close();
    }
    @FXML
    void spLoginUpAction(ActionEvent event)throws Exception {
        new SceneChange(spBorderPane,"Paytrack-view.fxml");
    }
}