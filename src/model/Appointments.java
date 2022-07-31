package model;

import java.time.LocalDateTime;

public class Appointments {
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
    public void setAppointmentTitle(String appointmentTitle){
        this.appointmentTitle = appointmentTitle;
    }
    public String getAppointmentDescription(){
        return appointmentDescription;
    }
    public void setAppointmentDescription(String appointmentDescription){
        this.appointmentDescription = appointmentDescription;
    }
    public String getAppointmentLocation(){
        return appointmentLocation;
    }
    public void setAppointmentLocation(String appointmentLocation){
        this.appointmentLocation = appointmentLocation;
    }
    public String getAppointmentType(){
        return appointmentType;
    }
    public void setAppointmentType(String appointmentType){
        this.appointmentType = appointmentType;
    }
    public LocalDateTime getStart() {
        System.out.println("start" + start);
        return start;
    }
    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public int getContactID() {
        return contactID;
    }
    public void setContactID(int contactID) {
        this.contactID = contactID;
    }
}

