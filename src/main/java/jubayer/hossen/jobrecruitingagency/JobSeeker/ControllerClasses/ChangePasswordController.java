package jubayer.hossen.jobrecruitingagency.JobSeeker.ControllerClasses;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import jubayer.hossen.jobrecruitingagency.JobSeeker.ModelClasses.JobSeeker;
import jubayer.hossen.jobrecruitingagency.MainApplication;

public class ChangePasswordController {
    private JobSeeker currentJobSeeker;
    @javafx.fxml.FXML
    private PasswordField oldPasswordPasswordField;
    @javafx.fxml.FXML
    private PasswordField newPasswordPasswordField;
    @javafx.fxml.FXML
    private PasswordField reEnterNewPasswordPasswordField;
    @javafx.fxml.FXML
    private Button changePasswordButton;
    @javafx.fxml.FXML
    private Button backHomeButton;
    @javafx.fxml.FXML
    private TextField reEnterNewPasswordTextField;
    @javafx.fxml.FXML
    private TextField newPasswordTextField;
    @javafx.fxml.FXML
    private TextField oldPasswordTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backHomeButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("JobSeeker/JobSeekerDashBoardView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            JobSeekerDashBoardController dashBoardController = fxmlLoader.getController();
            dashBoardController.setCurrentJobSeeker(currentJobSeeker);

            Stage newStage = (Stage) backHomeButton.getScene().getWindow();
            newStage.setTitle("TalentSphere");
            newStage.setScene(scene);
            newStage.show();
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not open change password view!");
            alert.setContentText("Please try again later!");
            alert.showAndWait();
            return;
        }
    }

    @javafx.fxml.FXML
    public void changePasswordButtonOnAction(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void showPasswordCheckBoxOnAction(ActionEvent actionEvent) {
        CheckBox checkBox = (CheckBox) actionEvent.getSource();
        boolean checked = checkBox.isSelected();

        if (checked){
            oldPasswordTextField.setText(oldPasswordPasswordField.getText());
            newPasswordTextField.setText(newPasswordPasswordField.getText());
            reEnterNewPasswordTextField.setText(reEnterNewPasswordPasswordField.getText());

            oldPasswordTextField.setVisible(true);
            newPasswordTextField.setVisible(true);
            reEnterNewPasswordTextField.setVisible(true);
            oldPasswordPasswordField.setVisible(false);
            newPasswordPasswordField.setVisible(false);
            reEnterNewPasswordPasswordField.setVisible(false);
        } else {
            oldPasswordPasswordField.setText(oldPasswordTextField.getText());
            newPasswordPasswordField.setText(newPasswordTextField.getText());
            reEnterNewPasswordTextField.setText(reEnterNewPasswordTextField.getText());

            oldPasswordPasswordField.setVisible(true);
            newPasswordPasswordField.setVisible(true);
            reEnterNewPasswordTextField.setVisible(true);
            oldPasswordTextField.setVisible(false);
            newPasswordTextField.setVisible(false);
            reEnterNewPasswordTextField.setVisible(false);
        }

    }

    public void setCurrentJobSeeker(JobSeeker jobSeeker) {
        this.currentJobSeeker = jobSeeker;
    }

}