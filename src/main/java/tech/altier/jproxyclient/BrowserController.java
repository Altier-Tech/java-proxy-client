package tech.altier.jproxyclient;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BrowserController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}