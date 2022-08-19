package controller;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Appointments;
//import model.Contacts;
//import model.Countries;
//import model.Customers;
//import model.FirstLevelDiv;
//import model.Reports;
import model.User;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

       Stage stage;
       Parent scene;
       /**     * Loads the Appointments controller.
        *  *
        *  * @param event Add button action.
        *  * @throws IOException From FXMLLoader.
        *  */
       @FXML
       void onActionDisplayAppointments(ActionEvent event) throws IOException {
           Parent one = FXMLLoader.load(getClass().getResource("/view/AppointmentsScreen.fxml"));
           Scene scene = new Scene(one);
           Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           stage.setScene(scene);
           stage.show();
       }
    /**     * Loads the Customers controller.
     *  *     * @param event Add button action.
     *  * @throws IOException From FXMLLoader.
     *  */
    @FXML
    void onActionDisplayCustomers(ActionEvent event) throws IOException {
        Parent one = FXMLLoader.load(getClass().getResource("/view/CustomersScreen.fxml"));
        Scene scene = new Scene(one);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();    }
    /**     * Loads the Customers controller.
     *  *     * @param event Add button action.
     *  * @throws IOException From FXMLLoader.
     *  */

    @FXML
    void onActionDisplayReports(ActionEvent event) throws IOException {
        Parent one = FXMLLoader.load(getClass().getResource("/view/AppointmentsScreen.fxml"));
        Scene scene = new Scene(one);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();


         }


/**     * Exits the program.
 *  *     * @param event Exit button action.
 *  */
    /**
     *
     * @param event
     */
    @FXML
    void onActionExit(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}



