package controller;


import Access.AppointmentsAcc;
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

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;
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

    /**
     * *  Login button for main screen.
     * * @param event
     * * @throws SQLException
     * * @throws IOException
     * * @throws Exception
     **/
    @FXML
    private void loginButton(ActionEvent event) throws SQLException, IOException, Exception {


                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/view/MainMenuScreen.fxml"));
                Parent root = loader.load();
                stage = (Stage) loginButton.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

    }

    /**
     * Exits the application.
     * * @param event
     */
    public void cancelButton(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Initilize upon screen start. Get locale info and set text on fields.
     * * @param url, rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Locale locale = Locale.getDefault();
            ZoneId zone = ZoneId.systemDefault();


            // loginScreenLocationField.setText(Locale.getDefault().getDisplayCountry());
            loginScreenLocationField.setText(String.valueOf(zone));
            rb = ResourceBundle.getBundle("language", Locale.getDefault());
            if (locale != Locale.ENGLISH) {
                loginField.setText(rb.getString("Connexion"));
                usernameField.setText(rb.getString("nom d'utilisatuer"));
                passwordField.setText(rb.getString("le mot de passe"));
                loginButton.setText(rb.getString("Connexion"));
                cancelButtonField.setText(rb.getString("Sortir"));
                locationText.setText(rb.getString("Emplacement"));
            } else {
                loginField.setText(rb.getString("Login"));
                usernameField.setText(rb.getString("username"));
                passwordField.setText(rb.getString("password"));
                loginButton.setText(rb.getString("Login"));
                cancelButtonField.setText(rb.getString("Exit"));
                locationText.setText(rb.getString("Location"));
            }


        } catch (MissingResourceException e) {
            System.out.println("Resource file missing: " + e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


