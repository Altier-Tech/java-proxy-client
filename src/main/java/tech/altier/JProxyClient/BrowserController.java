package tech.altier.JProxyClient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.util.Map;
import java.util.Stack;

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
    @FXML
    TextField addressBar;

    private String HOME_URL;
    private Stack<String> history;
    private Stack<String> forwardHistory;

    public void initialize() {
        initializeTopBar();

        HOME_URL = "https://google.com";    // TODO load from application.properties

        visitURL(HOME_URL);
    }

    private void visitURL(String url) {
        // Adding to stack
        history.push(url);

        Main.logger.log("Visiting URL: " + url);
        // TODO visit url

    }

    @FXML
    public void handleHomeButtonClick() {
        Main.logger.logln("Home button was clicked!");
        visitURL(HOME_URL);
    }

    @FXML
    public void handleBackButtonClick(ActionEvent actionEvent) {
        Main.logger.logln("Back button was clicked!");
        String url = history.pop();
        forwardHistory.push(url);
        visitURL(url);
    }

    @FXML
    public void handleNextButtonClick(ActionEvent actionEvent) {
        Main.logger.logln("Next button was clicked!");
        String url = forwardHistory.pop();
        history.push(url);
        visitURL(url);
    }

    @FXML
    public void handleRefreshButtonClick(ActionEvent actionEvent) {
    }

    @FXML
    public void handleMenuButtonClick(ActionEvent actionEvent) {
    }

    @FXML
    public void handleAddressBarAction(ActionEvent actionEvent) {
        visitURL(addressBar.getText());
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

        ImageView nextIcon = new ImageView("next.png");
        nextIcon.setFitHeight(25);
        nextIcon.setFitWidth(25);
        nextButton.setGraphic(nextIcon);

        ImageView refreshIcon = new ImageView("refresh.png");
        refreshIcon.setFitHeight(25);
        refreshIcon.setFitWidth(25);
        refreshButton.setGraphic(refreshIcon);

        ImageView menuIcon = new ImageView("menu.png");
        menuIcon.setFitHeight(25);
        menuIcon.setFitWidth(25);
        menuButton.setGraphic(menuIcon);
    }
}