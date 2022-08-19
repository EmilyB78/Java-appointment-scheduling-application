package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;

import java.net.URL;
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
    private ComboBox<Countries> customerCountryEdit;
    @FXML
    private TextField customerPostalEdit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void sendAppointments(Appointments appointmentsToModify) {

        editAppointmentID.setText(String.valueOf(appointmentsToModify.getAppointmentID()));
        editAppointmentTitle.setText(appointmentsToModify.getAppointmentTitle());
        editAppointmentDescription.setText(appointmentsToModify.getAppointmentDescription());
        editAppointmentDescription.setText(appointmentsToModify.getAppointmentDescription());
        editAppointmentType.setText(appointmentsToModify.getAppointmentType());

        for(Contacts co : editAppointmentContact.getItems()){

            if(co.getContactsID() == appointmentsToModify.getContactID()){
                editAppointmentContact.setValue(co);
                break;
            }
        }
    }


}
