package jubayer.hossen.jobrecruitingagency.NonUsers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jubayer.hossen.jobrecruitingagency.MainApplication;

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
    }
}