package tech.altier.JProxyClient;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BrowserController {
    @FXML
    Button homeButton;

    public void initialize() {
        homeButton.setText("Home");
    }

    @FXML
    public void handleHomeButtonClick() {
        System.out.println("Home button clicked!");
    }
}