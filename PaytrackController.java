package com.example.fxnew;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.PasswordField;
        import javafx.scene.control.TextField;
        import javafx.scene.layout.AnchorPane;
        import javafx.scene.layout.BorderPane;

        import java.io.IOException;
        import java.sql.Connection;
        import java.sql.ResultSet;
        import java.sql.Statement;

public class PaytrackController {
String abc;
    @FXML
    private Button LoginButton;

    @FXML
    private AnchorPane LoginAnchorPane;
    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button SignupButton;

    @FXML
    private TextField UsernameField;

    @FXML
    private Label loginmessage;

    @FXML
    private BorderPane PaytrackBorderPane;


    @FXML
    void LoginButtonOnAction(ActionEvent event)throws IOException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM customer WHERE customerID = '" +
                UsernameField.getText()+"'AND Password ='" +PasswordField.getText() +"'";

    try{
        Statement statement = connectDB.createStatement();
        ResultSet queryResult = statement.executeQuery(verifyLogin);
        while(queryResult.next()){
            if(queryResult.getInt(1)==1){

                loginmessage.setText("Welcome");
                new SceneChange(PaytrackBorderPane,"SecondScene.fxml");
            }
            else{
                loginmessage.setText("Login Failed");
            }
        }
    }catch (Exception e){
     e.printStackTrace();
    }
    }
@FXML
void SigUPButtonOnAction()throws IOException{
    new SceneChange(PaytrackBorderPane,"SignUp-View.fxml");
}
    public String storeId() {
        return abc;
    }
}
