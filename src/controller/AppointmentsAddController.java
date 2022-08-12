package controller;

import Access.ContactsAcc;
import Access.CustomersAcc;
import Access.UserAcc;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import model.Contacts;
import model.Customers;
import model.User;

import java.net.URL;
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
        
    }

    public void onActionSaveAppointment(ActionEvent event) {
    }

    public void onActionEditAppointmentStartTime(ActionEvent event) {
    }
}
