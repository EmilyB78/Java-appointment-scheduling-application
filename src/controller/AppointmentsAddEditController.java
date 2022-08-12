package controller;

import Access.UserAcc;
import Access.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import SQLDatabase.SQLDBConn;
import model.Appointments;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

import static Access.AppointmentsAcc.getAllAppointments;



/**public class AppointmentsAddEditController implements Initializable {

    @FXML
    private GridPane addAppointmentTable;
    @FXML
    private TextField addAppointmentID;
    @FXML
    private TextField addAppointmentTitle;
    @FXML
    private TextField addAppointmentDescription;
    @FXML
    private TextField addAppointmentLocation;
    @FXML
    private ComboBox<Contacts> addAppointmentContact;
    @FXML
    private TextField addAppointmentType;
    @FXML
    private DatePicker addAppointmentStartDate;
    @FXML
    private DatePicker addAppointmentEndDate;
    @FXML
    private TextField addAppointmentCustomerID;
    @FXML
    private TextField addAppointmentUserID;
    @FXML
    private ComboBox<String> addAppointmentStartTime;
    @FXML
    private ComboBox<String> addAppointmentEndTime;
    @FXML
    private GridPane editAppointmentTable;
    @FXML
    private TextField editAppointmentID;
    @FXML
    private TextField editAppointmentTitle;
    @FXML
    private TextField editAppointmentDescription;
    @FXML
    private TextField editAppointmentLocation;
    @FXML
    private ComboBox editAppointmentContact;
    @FXML
    private TextField editAppointmentType;
    @FXML
    private DatePicker editAppointmentStartDate;
    @FXML
    private DatePicker editAppointmentEndDate;
    @FXML
    private TextField editAppointmentCustomerID;
    @FXML
    private TextField editAppointmentUserID;
    @FXML
    private ComboBox<LocalTime> editAppointmentStartTime;
    @FXML
    private ComboBox<LocalTime> editAppointmentEndTime;

    @FXML
    private Button saveAppointment;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        LocalTime start = LocalTime.of (6,0);
        LocalTime end = LocalTime.NOON;

        while (start.isBefore(end.plusSeconds(1))){
            editAppointmentStartTime.getItems().add(start);
            start = start.plusMinutes(10);
        }

        editAppointmentStartTime.getSelectionModel().select(LocalTime.of(8,0));


    }



}
 **/




















