package jubayer.hossen.jobrecruitingagency.NonUsers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import jubayer.hossen.jobrecruitingagency.JobSeeker.ModelClasses.JobSeeker;
import jubayer.hossen.jobrecruitingagency.MainApplication;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LoginController
{
    @javafx.fxml.FXML
    private CheckBox rememberMECheckBox;
    @javafx.fxml.FXML
    private PasswordField passwordPasswordField;
    @javafx.fxml.FXML
    private TextField emailAddressOrUsernameTextField;
    @javafx.fxml.FXML
    private Button createAccountButton;
    @javafx.fxml.FXML
    private Label messageLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void createAccountButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("NonUsers/CreateNewAccountView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage = (Stage) createAccountButton.getScene().getWindow();
            newStage.setTitle("New Account Registration");
            newStage.setScene(scene);
            newStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void logInButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        String emailAddressOrUsername = emailAddressOrUsernameTextField.getText();
        String password = passwordPasswordField.getText();

        if (emailAddressOrUsername.isEmpty() || password.isEmpty()) {
            messageLabel.setText("Please fill in all fields!");
            messageLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        try {
            fileInputStream = new FileInputStream("src\\main\\Files\\Users.bin");
            objectInputStream = new ObjectInputStream(fileInputStream);

            Object object = objectInputStream.readObject();

            if (object instanceof jubayer.hossen.jobrecruitingagency.JobSeeker.ModelClasses.JobSeeker) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("JobSeeker/JobSeekerDashBoardView.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage newStage = (Stage) createAccountButton.getScene().getWindow();
                    newStage.setTitle(((JobSeeker) object).getName());
                    newStage.setScene(scene);
                    newStage.show();
                }
                catch (Exception e){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error while loading user data!");
                    alert.setContentText("Please try again later!");
                    alert.showAndWait();
                    return;
                }
            }

        }
        catch (Exception e){
        }




    }
}