package controller;

import Access.CountryAcc;
import Access.CustomersAcc;
import Access.StateProvinceAcc;
import SQLDatabase.SQLDBConn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Countries;
import model.Customers;
import model.StateProvince;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
    private ComboBox<StateProvince> customerStateAdd;
    @FXML
    private ComboBox<Countries> customerCountryAdd;
    @FXML
    private TextField customerPostalAdd;
    @FXML
    private Button customerAddBack;
    @FXML
    private Button customerAddSave;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {




        customerStateAdd.setVisibleRowCount(5);
        customerStateAdd.setPromptText("Please Select a State/Province...");


        customerCountryAdd.setItems(CountryAcc.getCountries());
        customerCountryAdd.setVisibleRowCount(5);
        customerCountryAdd.setPromptText("Please Select a Country...");



    }

    public void onActionCustomerStateAdd (ActionEvent event) throws IOException {

        StringBuilder cs = new StringBuilder("");



        /**Callback<ListView<Customers>, ListCell<Customers>> factory = lv -> new ListCell<Customers>(){
            @Override
            protected void updateItem(Customers item, boolean empty){
                super.updateItem(item,empty);
                setText(empty ? "Nothing" : ("Use : " + item.getCustomerState()));
            }
        };
         **/
    }
    public void onActionCustomerCountryAdd (ActionEvent event) throws IOException {

        Countries c = customerCountryAdd.getValue();
        System.out.println("Selected Country is.." + c.getCountryName());

       customerStateAdd.setItems(StateProvinceAcc.getAllFirstLevelDiv(c.getCountryID()));
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
     * @return
     */
    @FXML
    Customers onActionCustomerAddSave(ActionEvent event) throws IOException {


        try {

            String sql = "INSERT into customers SET (Customer_ID, Customer_Name, Address, Postal_Code, Phone, Division_ID)" + "VALUES (NULL, ?,?,?,?,?";

            PreparedStatement ps = SQLDBConn.getConnection().prepareStatement(sql);
            ps.setInt(1, Integer.parseInt("Customer_ID"));
            ps.setString(2, "Customer_Name");
            ps.setString(3, "Address");
            ps.setString(4, "Postal_code");
            ps.setString(5, "Phone");
            ps.setInt(6, Integer.parseInt("Division_ID"));
            ResultSet rs = ps.executeQuery();

            String name = customerNameAdd.getText();
            String phone = customerPhoneAdd.getText();
            String address = customerAddressAdd.getText();
            String state = String.valueOf(customerStateAdd.getItems());
            String code = String.valueOf(customerPostalAdd.getText());


        } catch (SQLException ex) {
            ex.printStackTrace();

            Parent one = FXMLLoader.load(getClass().getResource("/view/CustomersController.fxml"));
            Scene scene = new Scene(one);
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

            stage.setScene(scene);

            stage.show();

        }
        return null;
    }

    public void onActionCustomerBackAdd(ActionEvent event) {
    }
}

