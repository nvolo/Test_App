package Test_App;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Utils {

    public static void showAlert(Alert.AlertType alertType, String message){
        Alert errorAlert = new Alert(alertType, message, ButtonType.OK);
        errorAlert.showAndWait();
    }

}
