package controller;

import Access.ContactsAcc;
import Access.CustomersAcc;
import Access.UserAcc;
import SQLDatabase.SQLDBConn;
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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ResourceBundle;

public class AppointmentsAddController implements Initializable {

    public ComboBox<Contacts> addAppointmentContact;
    public DatePicker addAppointmentStartDate;
    public ComboBox<LocalTime> addAppointmentStartTime;
    public ComboBox<LocalTime> addAppointmentEndTime;
    public ComboBox<Customers> customerIDCB;
    public ComboBox<User> userIDCB;
    public TextField addAppointmentType;
    public TextField addAppointmentLocation;
    public TextField addAppointmentDescription;
    public TextField addAppointmentTitle;

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
        // 1. Get the data from the GUI
        try {
            String title = addAppointmentTitle.getText();
            String description = addAppointmentDescription.getText();
            String location = addAppointmentLocation.getText();

            String type = addAppointmentType.getText();
            LocalDate startdate = addAppointmentStartDate.getValue();
            // enter start date
            LocalTime starttime = addAppointmentStartTime.getValue();
            LocalTime endtime = addAppointmentEndTime.getValue();

            Customers customers = customerIDCB.getValue();
            User users = userIDCB.getValue();
            Contacts contacts = addAppointmentContact.getValue();



            // 2. Validate the data
            if (customers == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a customer.");
                Optional<ButtonType> result = alert.showAndWait();
                return;
            }
            if (users == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a user.");
                Optional<ButtonType> result = alert.showAndWait();
                return;
            }
            if (contacts == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a contact.");
                Optional<ButtonType> result = alert.showAndWait();
                return;
            }

            if (title.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter an appointment title.");
                Optional<ButtonType> result = alert.showAndWait();
                return;
            }
            if (description.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter an appointment description.");
                Optional<ButtonType> result = alert.showAndWait();
                return;
            }
            if (location.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter an appointment location.");
                Optional<ButtonType> result = alert.showAndWait();
                return;
            }

            if (type.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter an appointment type.");
                Optional<ButtonType> result = alert.showAndWait();
                return;
            }
            if (startdate == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a start date.");
                Optional<ButtonType> result = alert.showAndWait();
                return;
            }

            if (starttime == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a start time.");
                Optional<ButtonType> result = alert.showAndWait();
                return;
            }
            if (endtime == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please select an end time.");
                Optional<ButtonType> result = alert.showAndWait();
                return;
            }

            LocalDateTime start = LocalDateTime.of(startdate,starttime);
            LocalDateTime end = LocalDateTime.of(startdate, endtime);
            //need to validate for business hours
            //need to validate for start before end
            //validate for overlap based on cust Id


            // 3. Insert data into data base


            String sql = "insert into appointments (Appointment_ID, Title, Description, Location, Contact_ID, Type, Start, End, Customer_ID, User_ID ) values(null, ?, ?, ?, ?, ?,?,?,?,?)";

            PreparedStatement ps = SQLDBConn.getConnection().prepareStatement(sql);

            ps.setString(1, title);
            ps.setString(2, description);
            ps.setString(3,location);
            ps.setInt(4,contacts.getContactsID());
            ps.setString(5, type);
            ps.setTimestamp(6, Timestamp.valueOf(start));
            ps.setTimestamp(7, Timestamp.valueOf(end));
            ps.setInt(8,customers.getCustomerID() );
            ps.setInt(9,users.getUserID());

            ps.execute();


            // 4. Switch to main screen

            Parent root = FXMLLoader.load(getClass().getResource("/view/AppointmentsScreen.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

            stage.setScene(scene);

            stage.show();

        } catch (SQLException | IOException ex) {
            ex.printStackTrace();


        }
        return;
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


    /// Reports: 1 count on appointments for month/type combo
    // combo box for month names and combo box for types
    // select a month, selct a type, put count in a label

    // Report 2: schedule based on contact. need a combo box to choose contact
    //need a table (like appointment table) to display the appointments

    // Report 3: report of your choice. schedule based on customer
    //need a combo box for customers, can use the same table to display appointments

    // address time validation alerts/business hours

    // week and month view on appointment screen, add all radio button


}
