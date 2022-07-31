package Access;

import SQLDatabase.SQLDBConn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Contacts;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactsAcc {
    public static ObservableList<Contacts> getAllContacts() {
        ObservableList<Contacts> contactsObservableList = FXCollections.observableArrayList();
        try {
            String sql = "SELECT contacts.contact ID, contact.contact Name";
            PreparedStatement ps = SQLDBConn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int contactId = rs.getInt("Contact ID");
                String contactName = rs.getString("Contact Name");
                Contacts contacts = new Contacts(contactId, contactName);

                contactsObservableList.add(contacts);
            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }
        return contactsObservableList;
    }

}




