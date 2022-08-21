package controller;

import Access.ContactsAcc;
import Access.CustomersAcc;
import Access.UserAcc;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Contacts;
import model.Customers;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ResourceBundle;

public class AppointmentsAddController implements Initializable {

    public ComboBox<Contacts> addAppointmentContact;
    public DatePicker addAppointmentStartDate;
    public ComboBox addAppointmentStartTime;
    public ComboBox addAppointmentEndTime;
    public ComboBox<Customers> customerIDCB;
    public ComboBox<User> userIDCB;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addAppointmentContact.setItems(ContactsAcc.getAllContacts());
        customerIDCB.setItems((CustomersAcc.getAllCustomers()));
        userIDCB.setItems(UserAcc.getAllUsers());

        LocalTime start = LocalTime.of(8,0);
        LocalTime end = LocalTime.of(22,0);

        while(start.isBefore(end.plusSeconds(1))){
            addAppointmentStartTime.getItems().add(start);
            addAppointmentEndTime.getItems().add(start);
            start = start.plusMinutes(15);
        }
        addAppointmentStartTime.getSelectionModel().select(LocalTime.of(8,0));
        addAppointmentEndTime.getSelectionModel().select(LocalTime.of(22,0));
        
    }

    public void onActionSaveAppointment(ActionEvent event) {
    }


    public void onActionAppointmentsAddBack(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This will return you to Main Appointments Records without saving, do you want to continue?");

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
