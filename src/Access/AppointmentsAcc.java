package Access;
import SQLDatabase.SQLDBConn;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.time.LocalDateTime;

import javafx.collections.FXCollections;
import model.Appointments;

import java.sql.*;

public class AppointmentsAcc {
    public static ObservableList<Appointments> getAllAppointments() {
        ObservableList<Appointments> appointmentslist = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * from appointments";
            PreparedStatement ps = SQLDBConn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int appointmentID = rs.getInt("Appointment_ID");
                String appointmentTitle = rs.getString("Title");
                String appointmentDescription = rs.getString("Description");
                String appointmentLocation = rs.getString("Location");
                String appointmentType = rs.getString("Type");
                LocalDateTime start = rs.getTimestamp("Start").toLocalDateTime();
                LocalDateTime end = rs.getTimestamp("End").toLocalDateTime();
                int customerID = rs.getInt("Customer_ID");
                int userID = rs.getInt("User_ID");
                int contactID = rs.getInt("Contact_ID");
                Appointments A = new Appointments(appointmentID, appointmentTitle, appointmentDescription, appointmentLocation, appointmentType, start, end, customerID, userID, contactID);
                appointmentslist.add(A);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return appointmentslist;
    }

    public static ObservableList<Appointments> getAllAppointmentsbyContact(int contactID) {
        ObservableList<Appointments> appointmentslist = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * from appointments where contact_ID = ?";
            PreparedStatement ps = SQLDBConn.getConnection().prepareStatement(sql);
            ps.setInt(1,contactID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int appointmentID = rs.getInt("Appointment_ID");
                String appointmentTitle = rs.getString("Title");
                String appointmentDescription = rs.getString("Description");
                String appointmentLocation = rs.getString("Location");
                String appointmentType = rs.getString("Type");
                LocalDateTime start = rs.getTimestamp("Start").toLocalDateTime();
                LocalDateTime end = rs.getTimestamp("End").toLocalDateTime();
                int customerID = rs.getInt("Customer_ID");
                int userID = rs.getInt("User_ID");
                int contact_id = rs.getInt("Contact_ID");
                Appointments A = new Appointments(appointmentID, appointmentTitle, appointmentDescription, appointmentLocation, appointmentType, start, end, customerID, userID, contact_id);
                appointmentslist.add(A);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return appointmentslist;
    }

    public static ObservableList<Appointments> getAllAppointmentsbyCustomers(int customerid) {
        ObservableList<Appointments> appointmentslist = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * from appointments where customer_ID = ?";
            PreparedStatement ps = SQLDBConn.getConnection().prepareStatement(sql);
            ps.setInt(1,customerid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int appointmentID = rs.getInt("Appointment_ID");
                String appointmentTitle = rs.getString("Title");
                String appointmentDescription = rs.getString("Description");
                String appointmentLocation = rs.getString("Location");
                String appointmentType = rs.getString("Type");
                LocalDateTime start = rs.getTimestamp("Start").toLocalDateTime();
                LocalDateTime end = rs.getTimestamp("End").toLocalDateTime();
                int customerID = rs.getInt("Customer_ID");
                int userID = rs.getInt("User_ID");
                int contact_id = rs.getInt("Contact_ID");
                Appointments A = new Appointments(appointmentID, appointmentTitle, appointmentDescription, appointmentLocation, appointmentType, start, end, customerID, userID, contact_id);
                appointmentslist.add(A);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return appointmentslist;
    }

    public static ObservableList<String> getAllAppointmentsbyType() {
        ObservableList<String> appointmentslist = FXCollections.observableArrayList();
        try {
            String sql = "Select distinct type from appointments";
            PreparedStatement ps = SQLDBConn.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String appointmentType = rs.getString("Type");
                appointmentslist.add(appointmentType);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return appointmentslist;
    }

    public static int deleteAppointment(int appointmentID, Connection connection) {
        int result = 0;
        try {
            String sql = "DELETE FROM appointments where Appointment_ID =? ";
            PreparedStatement ps = SQLDBConn.getConnection().prepareStatement(sql);
            ps.setInt(1, appointmentID);
            result = ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public static String getmonthtypecount(String month, String type) {

        try {
            String sql = "Select count(*) from appointments where type = ? and monthname(start) = ?";
            PreparedStatement ps = SQLDBConn.getConnection().prepareStatement(sql);
            ps.setString(1, type);
            ps.setString(2, month);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString(1);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "0";
    }
}

