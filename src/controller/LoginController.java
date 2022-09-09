package controller;


import Access.AppointmentsAcc;
import SQLDatabase.SQLDBConn;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Appointments;
import model.StateProvince;

import java.io.*;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/** * Class and methods to verify login, update login log,
 * and set locale/language based on operating system settings.
 */
public class LoginController implements Initializable {
    @FXML
    private Button cancelButton;
    @FXML
    private Button loginButton;
    @FXML
    private TextField loginScreenLocationField;
    @FXML
    private TextField loginScreenPassword;
    @FXML
    private TextField loginScreenUsername;
    @FXML
    private Label passwordField;
    @FXML
    private Label usernameField;
    @FXML
    private Label loginField;
    @FXML
    private Button cancelButtonField;
    @FXML
    private Label locationText;
    Stage stage;

    private ResourceBundle dictionary = ResourceBundle.getBundle("language");

    /**
     * *  Login button for main screen.
     * * @param event
     * * @throws SQLException
     * * @throws IOException
     * * @throws Exception
     **/
    @FXML
    private void loginButton(ActionEvent event) throws SQLException, IOException, Exception {

        // 1. Get the data from the GUI
        try {

            String name = loginScreenUsername.getText();
            String pass = loginScreenPassword.getText();


            // 2. Validate the data
            //Create a if else for language
            //if language = en
            if (name.isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, dictionary.getString("blankuser"));
                Optional<ButtonType> result = alert.showAndWait();
                return;
            }
            if (pass.isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, dictionary.getString("blankpass"));
                Optional<ButtonType> result = alert.showAndWait();
                return;
            }


            // 3. Compare with data in data base

            String sql = "Select * from users where user_name = ? and password = ?";


            PreparedStatement ps = SQLDBConn.getConnection().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pass);


            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //the good case: successful login
                //write valid login to file
                try {
                    PrintWriter pw = new PrintWriter(new FileOutputStream(
                            new File("login_activity.txt"),
                            true /* append = true */));

                    pw.append("Successful Login by: " + name + " at time: " + LocalDateTime.now() +"\n");
                    pw.flush();
                    pw.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }


                //need 15 minute alert based on user ID
                int userID = rs.getInt("user_ID");
                ObservableList<Appointments> alllist = AppointmentsAcc.getAllAppointments();
                boolean appointfound = false;

                for(Appointments appointments:alllist){
                    if(appointments.getUserID() != userID) {
                        continue;
                    }

                    LocalDateTime today = LocalDateTime.now();
                    // if appointment start is > today, and appointment start is < today + 15 minutes
                    if(appointments.getStart().isAfter(today) && appointments.getStart().isBefore(today.plusMinutes(15))) {
                        appointfound = true;
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "You have an appointment coming up: " + appointments.getAppointmentID() + " at time " + appointments.getStart());
                        Optional<ButtonType> result = alert.showAndWait();
                    }
                }
                if(!appointfound){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "You do not have an appointment coming up.");
                    Optional<ButtonType> result = alert.showAndWait();
                }

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/view/MainMenuScreen.fxml"));
                Parent root = loader.load();
                stage = (Stage) loginButton.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else {
                //the bad case: no match
                //write to a file
                try {
                    PrintWriter pw = new PrintWriter(new FileOutputStream(
                            new File("login_activity.txt"),
                            true /* append = true */));

                    pw.append("Unsuccessful Login by: " + name + " at time: " + LocalDateTime.now() +"\n");
                    pw.flush();
                    pw.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }

                Alert alert = new Alert(Alert.AlertType.ERROR, dictionary.getString("badlogin"));
                Optional<ButtonType> result = alert.showAndWait();
            }



        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }



        /**
         * Initilize upon screen start. Get locale info and set text on fields.
         * * @param url, rb
         */
        @Override
        public void initialize (URL url, ResourceBundle rb){
            try {
                Locale locale = Locale.getDefault();
                ZoneId zone = ZoneId.systemDefault();


                // loginScreenLocationField.setText(Locale.getDefault().getDisplayCountry());
                loginScreenLocationField.setText(String.valueOf(zone));
                /**
                 if (locale != Locale.ENGLISH) {
                 loginField.setText(dictionary.getString("Connexion"));
                 usernameField.setText(dictionary.getString("nom d'utilisatuer"));
                 passwordField.setText(dictionary.getString("le mot de passe"));
                 loginButton.setText(dictionary.getString("Connexion"));
                 cancelButtonField.setText(dictionary.getString("Sortir"));
                 locationText.setText(dictionary.getString("Emplacement"));
                 } else {
                 loginField.setText(dictionary.getString("Login"));
                 usernameField.setText(dictionary.getString("username"));
                 passwordField.setText(dictionary.getString("password"));
                 loginButton.setText(dictionary.getString("Login"));
                 cancelButtonField.setText(dictionary.getString("Exit"));
                 locationText.setText(dictionary.getString("Location"));
                 }
                 **/
                loginField.setText(dictionary.getString("Login"));
                usernameField.setText(dictionary.getString("username"));
                passwordField.setText(dictionary.getString("password"));
                loginButton.setText(dictionary.getString("Login"));
                cancelButtonField.setText(dictionary.getString("Exit"));
                locationText.setText(dictionary.getString("Location"));


            } catch (MissingResourceException e) {
                System.out.println("Resource file missing: " + e);
            } catch (Exception e) {
                System.out.println(e);
            }
        }


    public void cancelButton(ActionEvent event) {
    }
}





