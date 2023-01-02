package tech.altier.JProxyClient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import tech.altier.Logger.LogManager;
import tech.altier.Logger.LoggerType;

import java.io.IOException;

public class Main extends Application {
    public static LogManager logger;
    public static Stage primaryStage;
    public static Scene mainScene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("browser-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 480);
        stage.getIcons().add(new Image("app-icon.png"));
        stage.setTitle("JProxy");
        stage.setScene(scene);
        stage.show();
        primaryStage = stage;
        mainScene = scene;
    }

    public static void main(String[] args) {
        logger = new LogManager(LoggerType.CONSOLE);
        launch();
    }

    public static void setTitle(String url) { // TODO bug
        Stage mainStage = (Stage) mainScene.getWindow();
        mainStage.setTitle(url.substring(7, url.length() - 1));
    }
}