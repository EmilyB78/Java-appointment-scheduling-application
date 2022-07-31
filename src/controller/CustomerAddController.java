package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Customers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class CustomerAddController implements Initializable {
    private Customers customerToAdd;

    Stage stage;
    Parent scene;

    @FXML
    private TextField customerIDAdd;
    @FXML
    private TextField customerNameAdd;
    @FXML
    private TextField customerPhoneAdd;
    @FXML
    private TextField customerAddressAdd;
    @FXML
    private ComboBox<String> customerStateAdd;
    @FXML
    private ComboBox<String> customerCountryAdd;
    @FXML
    private TextField customerPostalAdd;
    @FXML
    private Button customerAddBack;
    @FXML
    private Button customerAddSave;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //customerIDAdd.setText(new PropertyValueFactory<>("Customer ID"));
        //customerNameAdd.setText();

    }

    @FXML
    void onActionCustomerAddBack(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This will return you to Main Customer Records without saving, do you want to continue?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            Parent one = FXMLLoader.load(getClass().getResource("/view/CustomersScreen.fxml"));
            Scene scene = new Scene(one);
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

            stage.setScene(scene);

            stage.show();
        }
    }

    /**
     * Method to add customer when button is clicked.
     *
     *
     *
     * @param event
     */
    @FXML
    void onActionCustomerAddSave(ActionEvent event)  {


    }
}

