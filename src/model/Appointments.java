package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

import java.time.LocalDateTime;

public class Appointments {

    public static ObservableList<String> monthlist = FXCollections.observableArrayList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    private int appointmentID;
    private String appointmentTitle;
    private String appointmentDescription;
    private String appointmentLocation;
    private String appointmentType;
    private LocalDateTime start;
    private LocalDateTime end;
    public int customerID;
    public int userID;
    public int contactID;

    public Appointments (int appointmentID, String appointmentTitle, String appointmentDescription, String appointmentLocation, String appointmentType, LocalDateTime start, LocalDateTime end, int customerID, int userID, int contactID){
        this.appointmentID = appointmentID;
        this.appointmentTitle = appointmentTitle;
        this.appointmentDescription = appointmentDescription;
        this.appointmentLocation = appointmentLocation;
        this.appointmentType = appointmentType;
        this.start = start;
        this.end = end;
        this.customerID = customerID;
        this.userID = userID;
        this.contactID = contactID;
    }

    public int getAppointmentID() {
        return appointmentID;

    }
    public void setAppointmentID(int appointmentID){
        this.appointmentID = appointmentID;
    }

    public String getAppointmentTitle(){
        return appointmentTitle;
    }
    public String getAppointmentDescription(){
        return appointmentDescription;
    }

    public String getAppointmentLocation(){
        return appointmentLocation;
    }

    public String getAppointmentType(){
        return appointmentType;
    }

    public LocalDateTime getStart() {
        System.out.println("start" + start);
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getUserID() {
        return userID;
    }

    public int getContactID() {
        return contactID;
    }

}

