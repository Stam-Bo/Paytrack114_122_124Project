package com.example.fxnew;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SecondController {

    @FXML
    private AnchorPane BalanceOption;

    @FXML
    private AnchorPane ExpenseOption;

    @FXML
    private AnchorPane ProfileOption;

    @FXML
    private AnchorPane TranscationOption;

    @FXML
    private AnchorPane newAnchorPane;

    @FXML
    void BalanceOnAction()throws IOException {
        new AnchorPaneChange(newAnchorPane,"Balance-View.fxml");
    }
    @FXML
    void ProfileOnAction()throws IOException {
        new AnchorPaneChange(newAnchorPane,"Profile-View.fxml");
    }
    @FXML
    void TransactionOnAction()throws IOException {
        new AnchorPaneChange(newAnchorPane,"Transaction-View.fxml");
    }
    @FXML
    void ExpenseOnAction()throws IOException {
        new AnchorPaneChange(newAnchorPane,"Expense-View.fxml");
    }

    @FXML
    private Label tryyy;



   /* @FXML
    void okkk(ActionEvent event) {
        PaytrackController paytrackController = new PaytrackController();
        String s1 = paytrackController.storeId();
        tryyy.setText(s1);
    }*/
}

