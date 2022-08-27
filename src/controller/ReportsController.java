package controller;

import SQLDatabase.SQLDBConn;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Appointments;
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

import static Access.AppointmentsAcc.getAllAppointments;

public class ReportsController {
    public ComboBox monthMonthTypeReports;
    public ComboBox typeMonthTypeReports;
    public TextField totalMonthTypeReports;
    public ComboBox contactContactScheduleReports;
    public ComboBox customerCustomerScheduleReports;
    public Button viewContactsScheduleReports;
    public Button viewCustomerScheduleReports;
    public TableView ReportsAppointments;
    public TableColumn apptIDReports;
    public TableColumn titleReports;
    public TableColumn descriptionReports;
    public TableColumn locationsReports;
    public TableColumn contactReports;
    public TableColumn typeReports;
    public TableColumn startdatetimeReports;
    public TableColumn enddatetimeReports;
    public TableColumn custIDReports;
    public TableColumn userIDReports;


    private void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Appointments> allAppointmentsList = getAllAppointments();

        apptIDReports.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        titleReports.setCellValueFactory(new PropertyValueFactory<>("appointmentTitle"));
        descriptionReports.setCellValueFactory(new PropertyValueFactory<>("appointmentDescription"));
        locationsReports.setCellValueFactory(new PropertyValueFactory<>("appointmentLocation"));
        typeReports.setCellValueFactory(new PropertyValueFactory<>("appointmentType"));
        startdatetimeReports.setCellValueFactory(new PropertyValueFactory<>("start"));
        enddatetimeReports.setCellValueFactory(new PropertyValueFactory<>("end"));
        custIDReports.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        contactReports.setCellValueFactory(new PropertyValueFactory<>("ContactID"));
        userIDReports.setCellValueFactory(new PropertyValueFactory<>("userID"));

        ReportsAppointments.setItems(allAppointmentsList);

    }

    public void onActionDisplayContactsSchedule(ActionEvent event) {

        try {
            String title = apptIDReports.getText();
            String description = descriptionReports.getText();
            String location = locationsReports.getText();

            String type = typeReports.getText();

            LocalTime starttime = startdatetimeReports.getValue();
            LocalTime endtime = enddatetimeReports.getValue();

            Customers customers = custIDReports.getText();
            User users = userIDReports.getId();
            Contacts contacts = contactContactScheduleReports.getValue();



            // 2. Validate the data
            if (contacts == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a contact.");
                Optional<ButtonType> result = alert.showAndWait();
                return;
            }

            LocalDateTime start = LocalDateTime.of(startdatetimeReports);
            LocalDateTime end = LocalDateTime.of(enddatetimeReports);



            //Display schedule filtered by contact

            String sql = "Select * from appointments where contact_ID = ?";

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



        } catch (SQLException | IOException ex) {
            ex.printStackTrace();


        }
        return;


    }

    public void onActionDisplayCustomerSchedule(ActionEvent event) {
    }
}
