package Test_App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Test_App.listeners.StorageReloader;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

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

    // force the field to be numeric only

    @FXML
    void initialize() {
        inputTextfield.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    inputTextfield.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        expenseRadioButton.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                if (isNowSelected) {
                    salaryRadioButton.setDisable(true);
                } else {
                    salaryRadioButton.setDisable(false);
                }
                foodRadioButton.setSelected(false);
                personalSpendingRadioButton.setSelected(false);
                transportRadioButton.setSelected(false);
            }
        });

        incomeRadioButton.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                if (isNowSelected) {
                    foodRadioButton.setDisable(true);
                    personalSpendingRadioButton.setDisable(true);
                    transportRadioButton.setDisable(true);
                } else {
                    foodRadioButton.setDisable(false);
                    personalSpendingRadioButton.setDisable(false);
                    transportRadioButton.setDisable(false);
                }
                salaryRadioButton.setSelected(false);
            }
        });
    }

    @FXML
    public void goBack(ActionEvent event) {
        Stage app_stage = Main.getPrimaryStage();
        app_stage.setScene(mainScreen);
        app_stage.show();
    }

    public void add(ActionEvent event) throws IOException {

        if (!expenseRadioButton.isSelected() && !incomeRadioButton.isSelected()) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR, "Please select transaction type.", ButtonType.OK);
            errorAlert.showAndWait();
            return;
        }

        boolean isExpense = expenseRadioButton.isSelected();
        String category = "";
        if (salaryRadioButton.isSelected()) {
            category = salaryRadioButton.getText();
        }
        if (foodRadioButton.isSelected()) {
            category = foodRadioButton.getText();
        }
        if (transportRadioButton.isSelected()) {
            category = transportRadioButton.getText();
        }
        if (personalSpendingRadioButton.isSelected()) {
            category = personalSpendingRadioButton.getText();
        }
        if (presentsRadioButton.isSelected()) {
            category = presentsRadioButton.getText();
        }

        int value = isExpense ? -Integer.parseInt(inputTextfield.getText()) : Integer.parseInt(inputTextfield.getText());

        Transaction transaction = new Transaction(1, category, value);
        Storage storage = Storage.getInstance();
        storage.read();
        storage.addTransaction(transaction);
        storage.saveFile();
        resetValues();

        StorageReloader.reloadStorage();
    }

    private void resetValues() {
        inputTextfield.clear();
        expenseRadioButton.setSelected(false);
        incomeRadioButton.setSelected(false);
        salaryRadioButton.setSelected(false);
        presentsRadioButton.setSelected(false);
        transportRadioButton.setSelected(false);
        personalSpendingRadioButton.setSelected(false);
        foodRadioButton.setSelected(false);
    }
}
