package controller;

import SQLDatabase.SQLDBConn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Appointments;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.*;
import java.util.Optional;

import static Access.AppointmentsAcc.getAllAppointments;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.util.ResourceBundle;


public class AppointmentsController implements Initializable {



    @FXML private RadioButton allAppointmentRadio;
    @FXML private RadioButton appointmentWeekRadio;
    @FXML private RadioButton appointmentMonthRadio;
    @FXML private TableView<Appointments> allAppointmentsTable;
    @FXML private TableColumn<?, ?> appointmentContact;
    @FXML private TableColumn<?, ?> appointmentCustomerID;
    @FXML private TableColumn<?, ?> appointmentDescription;
    @FXML private TableColumn<?, ?> appointmentEnd;
    @FXML private TableColumn<?, ?> appointmentID;
    @FXML private TableColumn<?, ?> appointmentLocation;
    @FXML private TableColumn<?, ?> appointmentStart;
    @FXML private TableColumn<?, ?> appointmentTitle;
    @FXML private TableColumn<?, ?> appointmentType;
    @FXML private TableColumn<?, ?> tableUserID;
    @FXML private Button backToMainMenu;
    @FXML private Button deleteAppointment;
    @FXML private Button editAppointment;
    @FXML private Button addAppointment;


    /**
     *
     * Initialize controls and setup variables/observable lists.
     * @throws SQLException
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Appointments> allAppointmentsList = getAllAppointments();

        appointmentID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        appointmentTitle.setCellValueFactory(new PropertyValueFactory<>("appointmentTitle"));
        appointmentDescription.setCellValueFactory(new PropertyValueFactory<>("appointmentDescription"));
        appointmentLocation.setCellValueFactory(new PropertyValueFactory<>("appointmentLocation"));
        appointmentType.setCellValueFactory(new PropertyValueFactory<>("appointmentType"));
        appointmentStart.setCellValueFactory(new PropertyValueFactory<>("start"));
        appointmentEnd.setCellValueFactory(new PropertyValueFactory<>("end"));
        appointmentCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        appointmentContact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        tableUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));

        allAppointmentsTable.setItems(allAppointmentsList);
    }

     /**
      * method to return to main menu by button push
      * @param event
      * @throws IOException
      */
    @FXML
    void onActionDisplayMainMenu(ActionEvent event) throws IOException {
        Parent one = FXMLLoader.load(getClass().getResource("/view/MainMenuScreen.fxml"));
        Scene scene = new Scene(one);        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();    }

     /**
      * method to select appointment to edit and move to edit screen by button push
      * @param event
      * @throws IOException
      */

    @FXML
    void onActionDisplayAppointmentsEditScreen(ActionEvent event) throws IOException {

        Appointments appointmentsToModify = allAppointmentsTable.getSelectionModel().getSelectedItem();


        if (appointmentsToModify == null) {
            displayAlert(1);
        } else {
            Parent one = FXMLLoader.load(getClass().getResource("/view/AppointmentsAddEditScreen.fxml"));
            Scene scene = new Scene(one);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
/*
            AppointmentsAddEditController MPMController = loader.getController();
            MPMController.sendSelectedItem(appointmentsToModify);

            Parent one = loader.getRoot();
            Scene scene = new Scene(one);
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

 */

        }

    }

     /**
      * method to go to screen to add a new appointment by button push
      * @param event
      * @throws IOException
      */

    @FXML
    void onActionDisplayAppointmentsAddScreen(ActionEvent event) throws IOException { Parent addParts = FXMLLoader.load(getClass().getResource("../views/AppointmentsAddEditScreen.fxml"));
        Scene scene = new Scene(addParts);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }



    /**
     * Delete appointment on button press.
     * @throws Exception
     * @param event
     */

     /**
      * method to display custom message for errors and validation input
      * @param alertType
      */
    private void displayAlert(int alertType) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Alert alertError = new Alert(Alert.AlertType.ERROR);

        switch (alertType) {
            case 1:
                alert.setTitle("Information");
                alert.setHeaderText("Please Select an Appointment to Edit");
                alert.showAndWait();
                break;
            case 2:
                alert.setTitle("Information");
                alert.setHeaderText("Please Select an Appointment to Delete");
                alert.showAndWait();
                break;

        }
    }



    /**
     * Load appointment data on click.
     * Lambda #3 to fill the allContactNames observable list with contact information.
     */




    /**
     * When radio button for "Month" is selected.
     * @throws SQLException
     */
    @FXML
    void appointmentMonthSelected(ActionEvent event) throws SQLException {
        try {
            ObservableList<Appointments> allAppointmentsList = getAllAppointments();
            ObservableList<Appointments> appointmentsMonth = FXCollections.observableArrayList();

            LocalDateTime currentMonthStart = LocalDateTime.now().minusMonths(1);
            LocalDateTime currentMonthEnd = LocalDateTime.now().plusMonths(1);


            if (allAppointmentsList != null)
                //IDE converted to forEach
                allAppointmentsList.forEach(appointment -> {
                    if (appointment.getEnd().isAfter(currentMonthStart) && appointment.getEnd().isBefore(currentMonthEnd)) {
                        appointmentsMonth.add(appointment);
                    }
                    allAppointmentsTable.setItems(appointmentsMonth);
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * When radio button for week is selected.
     * @throws SQLException
     */
    @FXML
    void appointmentWeekSelected(ActionEvent event) throws SQLException {
        try {

            ObservableList<Appointments> allAppointmentsList = getAllAppointments();
            ObservableList<Appointments> appointmentsWeek = FXCollections.observableArrayList();

            LocalDateTime weekStart = LocalDateTime.now().minusWeeks(1);
            LocalDateTime weekEnd = LocalDateTime.now().plusWeeks(1);

            if (allAppointmentsList != null)
                //IDE converted forEach
                allAppointmentsList.forEach(appointment -> {
                    if (appointment.getEnd().isAfter(weekStart) && appointment.getEnd().isBefore(weekEnd)) {
                        appointmentsWeek.add(appointment);
                    }
                    allAppointmentsTable.setItems(appointmentsWeek);
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



 }

