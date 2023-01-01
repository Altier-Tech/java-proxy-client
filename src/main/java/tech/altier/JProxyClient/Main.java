package tech.altier.JProxyClient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tech.altier.Logger.LogManager;
import tech.altier.Logger.LoggerType;

import java.io.IOException;

public class Main extends Application {
    public static LogManager logger;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("browser-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 480);
        stage.setTitle("JProxy");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        logger = new LogManager(LoggerType.CONSOLE);
        launch();
    }
}