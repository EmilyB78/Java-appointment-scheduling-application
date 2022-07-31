package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;


public class CustomerEditController implements Initializable {

    private Customers customerToEdit;

    Stage stage;
    Parent scene;
    @FXML
    private TextField customerIDEdit;
    @FXML
    private TextField customerNameEdit;
    @FXML
    private TextField customerPhoneEdit;
    @FXML
    private TextField customerAddressEdit;
    @FXML
    private ComboBox<StateProvince> customerStateEdit;
    @FXML
    private ComboBox<Countries> customerCountryEdit;
    @FXML
    private TextField customerPostalEdit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Button to navigate from edit menu back to Main Customer Screen
     * @param event
     * @throws IOException
     */

    @FXML
    void onActionCustomerEditBack(ActionEvent event) throws IOException {

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
     * method to save customer data after it has been edited.
     * @param event
     */


   @FXML
    void onActionCustomerEditSave(ActionEvent event) {

   }

    /**
     * Fill Combo Box with State/Province information
     * @param event
     * @throws SQLException
     */

    @FXML
    void onActionCustomerStateEdit(ActionEvent event) throws SQLException {

    }


    /**
     *
     * Fill Combo Box menu with firstlevel division information.
     * @param event
     * @throws SQLException
     */
     public void onActionCustomerCountryEdit(ActionEvent event) throws SQLException {

    }

}



