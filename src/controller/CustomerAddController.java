package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Customers;

import javax.security.auth.callback.Callback;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
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
    private ComboBox<Customers> customerStateAdd;
    @FXML
    private ComboBox<Customers> customerCountryAdd;
    @FXML
    private TextField customerPostalAdd;
    @FXML
    private Button customerAddBack;
    @FXML
    private Button customerAddSave;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Customers> customerslist = FXCollections.observableArrayList();

        customerStateAdd.setItems(customerslist);
        customerStateAdd.setVisibleRowCount(5);
        customerStateAdd.setPromptText("Please Select a State/Province...");


        customerCountryAdd.setItems(customerslist);
        customerCountryAdd.setVisibleRowCount(5);
        customerCountryAdd.setPromptText("Please Select a Country...");



    }
    public void onActionCustomerStateAdd (ActionEvent event) throws IOException {

        StringBuilder cs = new StringBuilder("");

        Customers selcs = customerStateAdd.getSelectionModel().getSelectedItem();

        if (selcs == null) {
            cs.append("Customer State: null:");
        } else {
            cs.append("Customer State: " + selcs.getCustomerState());
        }

        Callback<ListView<Customers>, ListCell<Customers>> factory = lv -> new ListCell<Customers>(){
            @Override
            protected void updateItem(Customers item, boolean empty){
                super.updateItem(item,empty);
                setText(empty ? "Nothing" : ("Use : " + item.getCustomerState()));
            }
        };
    }
    public void onActionCustomerCountryAdd (ActionEvent event) throws IOException {

        StringBuilder cs = new StringBuilder("");

        Customers selcs = customerStateAdd.getSelectionModel().getSelectedItem();

        if (customerCountryAdd.getValue() == null) {
            cs.append("Customer Country: null:");
        }
        else {
            cs.append("Customer Country: " + selcs.getCustomerCountry());
        }

        Callback<ListView<Customers>, ListCell<Customers>> factory = lv -> new ListCell<Customers>(){
            @Override
            protected void updateItem(Customers item, boolean empty){
                super.updateItem(item,empty);
                setText(empty ? "Nothing" : ("Use : " + item.getCustomerCountry()));
            }
        };
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

