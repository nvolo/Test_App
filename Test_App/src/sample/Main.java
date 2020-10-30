package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Accounting");
        primaryStage.setScene(new Scene(root, 443, 535));
        primaryStage.show();
    }
}

//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        primaryStage.setTitle("Hello World");
//        button = new Button();
//        button.setText("Click");
//
//        button.setOnAction(e -> {
//            System.out.println("Hi!");
//            System.out.println("Bye!");
//        });
//
//        StackPane layout = new StackPane();
//        layout.getChildren().add(button);
//
//        primaryStage.setScene(new Scene(layout, 300, 250));
//        primaryStage.show();
//    }
//}
