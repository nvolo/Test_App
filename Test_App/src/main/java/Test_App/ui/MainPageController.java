//package Test_App.ui;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//
//import Test_App.Main;
//import Test_App.Storage;
//import Test_App.Transaction;
//import Test_App.listeners.DataReloadListener;
//import Test_App.listeners.StorageReloader;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//
//import javafx.event.ActionEvent;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.stage.Stage;
//
//
//public class MainPageController implements Initializable, DataReloadListener {
//
//    public static Scene mainScreen;
//
//    @FXML
//    public TableView<Transaction> tableView;
//    @FXML
//    public TableColumn<Transaction, String> categoryColumn;
//    @FXML
//    public TableColumn<Transaction, String> amountColumn;
//
//    @FXML
//    public TableColumn<Transaction, String> dateColumn;
//
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;
//
//    @FXML
//    private Label balanceLabel;
//
//    @FXML
//    private Button addFromMainButton;
//
//    @FXML
//    private Button categoriesButton;
//
//    @FXML
//    private Label activityNameLabel;
//
//    @FXML
//    private Label sumLabel;
//
//    @FXML
//    public void triggerButton(ActionEvent event) throws IOException {
//        Parent add_page = FXMLLoader.load((getClass().getResource("/addPage.fxml")));
//        Scene add_page_scene = new Scene(add_page);
//        Stage app_stage = Main.getPrimaryStage();
//        mainScreen = app_stage.getScene();
//        app_stage.setScene(add_page_scene);
//        app_stage.show();
//    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//        StorageReloader.registerListener(this);
//
//        Storage storage = Storage.getInstance();
//        try {
//            storage.read();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        balanceLabel.setText(String.valueOf(storage.getTotal()));
//
//        ObservableList<Transaction> data = FXCollections.observableArrayList();
//        data.addAll(storage.getLoadedTransactions());
//
//        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
//        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
//        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
//
//        tableView.setItems(data);
//    }
//
//    @Override
//    public void reloadStorage() throws FileNotFoundException {
//        Storage storage = Storage.getInstance();
//        storage.read();
//        ObservableList<Transaction> data = FXCollections.observableArrayList(storage.getLoadedTransactions());
//        tableView.setItems(data);
//
//        balanceLabel.setText(String.valueOf(storage.getTotal()));
//    }
//}
