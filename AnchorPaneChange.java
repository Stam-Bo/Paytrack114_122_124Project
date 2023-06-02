package com.example.fxnew;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import com.example.fxnew.PaytrackApplication;
import java.io.IOException;
import java.util.Objects;

public class AnchorPaneChange {
    public AnchorPaneChange(AnchorPane currentAnchorPane, String fxml)throws IOException {
        BorderPane nextAnchorPane = FXMLLoader.load(Objects.requireNonNull(PaytrackApplication.class.getResource(fxml)));
        currentAnchorPane.getChildren().removeAll();
        currentAnchorPane.getChildren().setAll(nextAnchorPane);

    }
}
