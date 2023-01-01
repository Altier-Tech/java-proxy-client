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
    private String currentURL;
    private String tempLastURL;

    public void initialize() {
        initializeTopBar();

        history = new Stack<>();
        forwardHistory = new Stack<>();

        tempLastURL = "";
        HOME_URL = "https://google.com";    // TODO load from application.properties
        currentURL = HOME_URL;

        visitURL(currentURL);
    }

    private void visitURL(String url) {
        currentURL = url;

        // Adding to stack
//        if (!tempLastURL.equals(currentURL)) history.push(url);

        // Set button states
        backButton.setDisable(history.size() <= 1);
        nextButton.setDisable(forwardHistory.isEmpty());
        backButton.setDisable(history.size() == 1 && history.peek().equalsIgnoreCase(HOME_URL));

        Main.logger.logln("Visiting URL: " + url);
        // TODO visit url

    }

    @FXML
    public void handleAddressBarAction(ActionEvent actionEvent) {
        if (! currentURL.isBlank()) history.push(currentURL);
        visitURL(addressBar.getText());
    }

    @FXML
    public void handleBackButtonClick(ActionEvent actionEvent) {
        Main.logger.logln("Back button was clicked!");
        forwardHistory.push(currentURL);
        currentURL = history.pop();
        visitURL(currentURL);
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
        Main.logger.logln("Refresh button was clicked!");
        // TODO refresh page

    }

    @FXML
    public void handleMenuButtonClick(ActionEvent actionEvent) {
        Main.logger.logln("Menu button was clicked!");
        // TODO show menu
    }

    @FXML
    public void handleHomeButtonClick() {
        Main.logger.logln("Home button was clicked!");
        visitURL(HOME_URL);
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