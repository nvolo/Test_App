package Test_App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.xml.soap.Text;

import static Test_App.Controller.mainScreen;

public class AddPageController {

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
    private RadioButton incomeRadioButton;

    @FXML
    private ToggleGroup incomeOrExpense;

    @FXML
    private RadioButton expenseRadioButton;

    @FXML
    private RadioButton salaryRadioButton;

    @FXML
    private RadioButton foodRadioButton;

    @FXML
    private RadioButton transportRadioButton;

    @FXML
    private RadioButton personalSpendingRadioButton;

    @FXML
    private RadioButton presentsRadioButton;

    @FXML
    private TextField inputTextfield;

    @FXML
    void initialize() {

    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {

        Stage app_stage = Main.getPrimaryStage();
        app_stage.setScene(mainScreen);
        app_stage.show();
    }

    public void add(ActionEvent event) throws IOException {
        boolean isSelected = expenseRadioButton.isSelected();
        String Category = "";
        if(salaryRadioButton.isSelected()){
            Category = salaryRadioButton.getText();
        }
        if(foodRadioButton.isSelected()){
            Category = foodRadioButton.getText();
        }
        if(transportRadioButton.isSelected()){
            Category = transportRadioButton.getText();
        }
        if(personalSpendingRadioButton.isSelected()){
            Category = personalSpendingRadioButton.getText();
        }
        if(presentsRadioButton.isSelected()){
            Category = presentsRadioButton.getText();
        }

        String amount = isSelected?"-"+inputTextfield.getText():"+"+inputTextfield.getText();

        Transaction transaction = new Transaction(1,Category, amount);
        Storage storage = new Storage();
        storage.addTransaction(transaction);
        storage.saveFile();
    }


}
