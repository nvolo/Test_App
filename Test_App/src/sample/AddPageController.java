package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

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
    void initialize() {

    }
}
