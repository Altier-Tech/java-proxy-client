package tech.altier.JProxyClient;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class BrowserController {
    @FXML
    Button homeButton;

    public void initialize() {
        homeButton.setGraphic(new ImageView("home.png"));
    }

    @FXML
    public void handleHomeButtonClick() {
        System.out.println("Home button clicked!");
    }
}