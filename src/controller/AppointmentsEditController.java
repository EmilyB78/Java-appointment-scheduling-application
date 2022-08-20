package controller;

import Access.ContactsAcc;
import Access.CustomersAcc;
import Access.UserAcc;
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
import java.time.LocalTime;
import java.util.Optional;
import java.util.ResourceBundle;

public class AppointmentsEditController implements Initializable {

    private Appointments appointmentsToModify;

    Stage stage;
    Parent scene;
    @FXML
    private TextField editAppointmentID;
    @FXML
    private TextField editAppointmentTitle;
    @FXML
    private TextField editAppointmentDescription;
    @FXML
    private TextField editAppointmentType;
    @FXML
    private ComboBox<Contacts> editAppointmentContact;
    @FXML
    private ComboBox<Customers> editAppointmentCustID ;
    @FXML
    private ComboBox<User>editAppointmentUserID;
    @FXML
    private DatePicker editAppointmentStartTime;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void sendAppointments(Appointments appointmentsToModify) {

        editAppointmentID.setText(String.valueOf(appointmentsToModify.getAppointmentID()));
        editAppointmentTitle.setText(appointmentsToModify.getAppointmentTitle());
        editAppointmentDescription.setText(appointmentsToModify.getAppointmentDescription());
        editAppointmentDescription.setText(appointmentsToModify.getAppointmentDescription());
        editAppointmentType.setText(appointmentsToModify.getAppointmentType());
        editAppointmentContact.setItems(ContactsAcc.getAllContacts());
        editAppointmentCustID.setItems((CustomersAcc.getAllCustomers()));
        editAppointmentUserID.setItems(UserAcc.getAllUsers());

    }


    public void onActionAppointmentsEditBack(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This will return you to Main Appointment Records without saving, do you want to continue?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            Parent one = FXMLLoader.load(getClass().getResource("/view/AppointmentsScreen.fxml"));
            Scene scene = new Scene(one);
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

            stage.setScene(scene);

            stage.show();
        }
    }
}




