package nollid.javafx;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import nollid.Nollid;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {

    private Nollid nollid = new Nollid();

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setNollid(nollid);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
