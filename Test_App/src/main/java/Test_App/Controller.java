package Test_App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;


public class Controller {

    public static Scene mainScreen;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label balanceLabel;

    @FXML
    private Button addFromMainButton;

    @FXML
    private Button categoriesButton;

    @FXML
    private Label activityNameLabel;

    @FXML
    private Label sumLabel;

    @FXML
    void initialize(ActionEvent event) throws IOException {
    }

    @FXML
    public void triggerButton(ActionEvent event) throws IOException {
        Parent add_page = FXMLLoader.load((getClass().getResource("addPage.fxml")));
        Scene add_page_scene = new Scene(add_page);
        Stage app_stage = Main.getPrimaryStage();
        mainScreen = app_stage.getScene();
        app_stage.setScene(add_page_scene);
        app_stage.show();
    }

}
