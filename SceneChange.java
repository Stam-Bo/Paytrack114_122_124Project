package com.example.fxnew;
import com.example.fxnew.PaytrackApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.util.Objects;

public class SceneChange {
    public SceneChange(BorderPane currentBorderPane,String fxml)throws IOException{
        BorderPane nextBorderPane = FXMLLoader.load(Objects.requireNonNull(PaytrackApplication.class.getResource(fxml)));
        currentBorderPane.getChildren().removeAll();
        currentBorderPane.getChildren().setAll(nextBorderPane);
    }
}
