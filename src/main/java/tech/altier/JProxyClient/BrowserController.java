package tech.altier.JProxyClient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

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
    @FXML
    Button exitButton;
    @FXML
    Button settingsButton;
    @FXML
    private WebView webView;
    @FXML
    private VBox menuBox;
    @FXML
    private VBox rightParent;

    private String HOME_URL;
    private String ABOUT_URL;
    private Stack<String> history;
    private Stack<String> forwardHistory;
    private String currentURL;
    private WebEngine engine;
    private boolean menuOpen;

    public void initialize() {
        initializeTopBar();

        engine = webView.getEngine();
        engine.setJavaScriptEnabled(true);

        // Hiding the menu
        rightParent.getChildren().remove(menuBox);
        menuOpen = false;

        history = new Stack<>();
        forwardHistory = new Stack<>();

        // TODO load from application.properties
        HOME_URL = "https://www.google.lk/";
        ABOUT_URL = "http://about.altier.tech/";
        currentURL = HOME_URL;

        history.push(currentURL);
        visitURL(currentURL);
    }

    @FXML
    public void handleMenuButtonClick() {
        Main.logger.logln("Menu button was clicked!");
        try {
            if (menuOpen) {
                rightParent.getChildren().remove(menuBox);
                menuOpen = false;
            } else {
                rightParent.getChildren().add(menuBox);
                menuOpen = true;
            }
        } catch (Exception e) {
            Main.logger.logln("Error while opening menu: " + e.getMessage());
        }
    }

    @FXML
    public void handleSettingsButtonClick() {
        Main.logger.logln("Settings button was clicked!");
        menuBox.setVisible(true);
    }

    private void visitURL(String url) {
        currentURL = url;

        // Set button states
        backButton.setDisable(history.size() <= 1);
        nextButton.setDisable(forwardHistory.isEmpty());
        backButton.setDisable(history.size() == 1 && history.peek().equalsIgnoreCase(HOME_URL));

        Main.logger.logln("Visiting URL: " + url);

        engine.load(url);
    }

    @FXML
    public void handleAddressBarAction() {
        if (!history.isEmpty()) if (history.peek().equals(addressBar.getText())) engine.reload();
        if (!currentURL.isEmpty()) history.push(currentURL);
        visitURL(addressBar.getText());
    }

    @FXML
    public void handleBackButtonClick() {
        Main.logger.logln("Back button was clicked!");
        forwardHistory.push(currentURL);
        visitURL(history.pop());
    }

    @FXML
    public void handleNextButtonClick() {
        Main.logger.logln("Next button was clicked!");
        if (!history.peek().equals(currentURL)) history.push(currentURL);
        visitURL(forwardHistory.pop());
    }

    @FXML
    public void handleRefreshButtonClick() {
        Main.logger.logln("Refresh button was clicked!");
        webView.getEngine().reload();
    }

    @FXML
    public void handleHomeButtonClick() {
        Main.logger.logln("Home button was clicked!");
        if (!history.peek().equals(currentURL)) history.push(currentURL);
        visitURL(HOME_URL);
    }

    @FXML
    public void handleExitButtonClick() {
        Main.logger.logln("Exit button was clicked!");
        Main.primaryStage.close();
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

        ImageView exitIcon = new ImageView("exit.png");
        exitIcon.setFitHeight(25);
        exitIcon.setFitWidth(25);
        exitButton.setGraphic(exitIcon);

        ImageView settingsIcon = new ImageView("settings.png");
        settingsIcon.setFitHeight(25);
        settingsIcon.setFitWidth(25);
        settingsButton.setGraphic(settingsIcon);
    }

    @FXML
    public void handleAboutButtonClick(ActionEvent actionEvent) {
        Main.logger.logln("About button was clicked!");
        engine.load(ABOUT_URL);
    }
}