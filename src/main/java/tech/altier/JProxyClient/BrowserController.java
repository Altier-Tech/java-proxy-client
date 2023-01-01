package tech.altier.JProxyClient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class BrowserController {
    @FXML
    Button homeButton;

    public void initialize() {
        initializeTopBar();
    }

    private void initializeTopBar() {
        ImageView homeIcon = new ImageView("home.png");
        homeIcon.setFitHeight(25);
        homeIcon.setFitWidth(25);
        homeButton.setGraphic(homeIcon);


    }

    @FXML
    public void handleHomeButtonClick() {
        System.out.println("Home button clicked!");
    }

    public void handleBackButtonClick(ActionEvent actionEvent) {
    }

    public void handleForwardButtonClick(ActionEvent actionEvent) {
    }
}