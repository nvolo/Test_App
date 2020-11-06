package Test_App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage Stage;

    static public Stage getPrimaryStage() {
        return Main.Stage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage = primaryStage;
        Parent root = FXMLLoader.load(Main.class.getResource("/sample.fxml"));
        primaryStage.setTitle("Accounting");
        primaryStage.setScene(new Scene(root, 443, 535));
        primaryStage.show();
    }
}
