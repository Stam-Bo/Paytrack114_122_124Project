package com.example.fxnew;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TransactionController {

    @FXML
    private AnchorPane TransactionAnchorPane;

    @FXML
    private TextField amount_id;

    @FXML
    private TextField cust_id;

    @FXML
    private Button transaction_process;

    @FXML
    private MenuButton type_id;

    @FXML
    private TextField YouCustID;

    @FXML
    void transaction_process(ActionEvent event)throws Exception {

        String amount = amount_id.getText().toString();
        String custid = cust_id.getText().toString();
        String ycustid = YouCustID.getText().toString();
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
            String q1 = "INSERT INTO transaction(amount,receiverID,senderID) VALUES ('"+ amount+ "','"+custid+ "','"+ycustid+ "')";
            String q2 = "UPDATE customer SET Balance = '"+ amount+ "' + Balance Where customerID = '"+custid+ "';";
            String q3 = "UPDATE customer SET Balance = Balance - '"+ amount+ "'Where customerID = '"+ycustid + "'";
            int rs = -1;
            int sr = -1;
            int a3 = -1;
                rs = st.executeUpdate(q1);
                sr = st.executeUpdate(q2);
                a3 = st.executeUpdate(q3);
            st.close();

        }catch(Exception e) {
            System.out.println("Error");
        }
        connection.close();
    }
    }
