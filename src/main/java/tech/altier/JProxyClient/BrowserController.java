package tech.altier.JProxyClient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class BrowserController {
    @FXML
    Button homeButton;
    @FXML
    Button backButton;
    @FXML
    Button nextButton;
    @FXML
    Button refreshButton;
    @FXML
    Button menuButton;

    public void initialize() {
        initializeTopBar();
    }

    private void initializeTopBar() {
        ImageView homeIcon = new ImageView("home.png");
        homeIcon.setFitHeight(25);
        homeIcon.setFitWidth(25);
        homeButton.setGraphic(homeIcon);

        ImageView backIcon = new ImageView("back.png");
        backIcon.setFitHeight(25);
        backIcon.setFitWidth(25);
        backButton.setGraphic(backIcon);

        
    }

    @FXML
    public void handleHomeButtonClick() {
        System.out.println("Home button clicked!");
    }

    @FXML
    public void handleBackButtonClick(ActionEvent actionEvent) {
    }

    @FXML
    public void handleNextButtonClick(ActionEvent actionEvent) {
    }

    @FXML
    public void handleRefreshButtonClick(ActionEvent actionEvent) {
    }

    @FXML
    public void handleMenuButtonClick(ActionEvent actionEvent) {
    }
}