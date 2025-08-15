package jubayer.hossen.jobrecruitingagency.JobSeeker.ControllerClasses;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import jubayer.hossen.jobrecruitingagency.JobSeeker.ModelClasses.JobSeeker;
import jubayer.hossen.jobrecruitingagency.MainApplication;
import jubayer.hossen.jobrecruitingagency.User.User;

import java.io.*;
import java.util.ArrayList;

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
        oldPasswordPasswordField.setVisible(true);
        newPasswordPasswordField.setVisible(true);
        reEnterNewPasswordPasswordField.setVisible(true);

        oldPasswordTextField.setVisible(false);
        newPasswordTextField.setVisible(false);
        reEnterNewPasswordTextField.setVisible(false);
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
            alert.setHeaderText("Could not return to home page!");
            alert.setContentText("Please try again later!");
            alert.showAndWait();
            return;
        }
    }

    @FXML
    public void changePasswordButtonOnAction(ActionEvent actionEvent) {

        String oldPassword, newPassword, reEnterNewPassword;

        if (oldPasswordPasswordField.isVisible()){
            oldPassword = oldPasswordPasswordField.getText();
            newPassword = newPasswordPasswordField.getText();
            reEnterNewPassword = reEnterNewPasswordPasswordField.getText();
        }
        else {
            oldPassword = oldPasswordTextField.getText();
            newPassword = newPasswordTextField.getText();
            reEnterNewPassword = reEnterNewPasswordTextField.getText();
        }

        if (ChangePasswordController.this.currentJobSeeker.changePassword(oldPassword, newPassword, reEnterNewPassword)) {

            try {
                ObjectInputStream objectInputStream = null;

                File file = new File("src\\main\\Files\\Users.bin");
                ArrayList<User> users = new ArrayList<>();

                if (file.exists()){
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        objectInputStream = new ObjectInputStream(fileInputStream);

                        while (true) {
                            try{
                                User user = (User) objectInputStream.readObject();
                                users.add(user);
                            }
                            catch (EOFException e){
                                break;
                            }
                        }
                    }
                    catch (Exception e){
                        //
                        return;
                    }
                }

                for (int i = 0; i < users.size(); i++) {
                    User user = users.get(i);
                    if (user.getUserID().equals(this.currentJobSeeker.getUserID())) {
                        users.set(i, this.currentJobSeeker);
                        break;
                    }
                }

                try {
                    ObjectOutputStream objectOutputStream = null;
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    objectOutputStream = new ObjectOutputStream(fileOutputStream);

                    for (User user : users) {
                        objectOutputStream.writeObject(user);
                    }
                }
                catch (Exception e){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error while saving user data!");
                    alert.setContentText("Please try again later!");
                    alert.showAndWait();
                    return;
                }
            }
            catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Password Changed But could not save data to file! Please check your input and try again!");
                alert.setContentText("Please try again later!");
                alert.showAndWait();
                return;
            }

            oldPasswordPasswordField.clear();
            newPasswordPasswordField.clear();
            reEnterNewPasswordPasswordField.clear();
            oldPasswordTextField.clear();
            newPasswordTextField.clear();
            reEnterNewPasswordTextField.clear();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Password changed successfully!");
            alert.setContentText("Please sign in with your new password!");
            alert.showAndWait();
            return;
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not change password! Please check your input and try again!");
            alert.setContentText("Please try again later!");
        }
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
        }
        else {
            oldPasswordPasswordField.setText(oldPasswordTextField.getText());
            newPasswordPasswordField.setText(newPasswordTextField.getText());
            reEnterNewPasswordTextField.setText(reEnterNewPasswordTextField.getText());

            oldPasswordPasswordField.setVisible(true);
            newPasswordPasswordField.setVisible(true);
            reEnterNewPasswordPasswordField.setVisible(true);

            oldPasswordTextField.setVisible(false);
            newPasswordTextField.setVisible(false);
            reEnterNewPasswordTextField.setVisible(false);
        }
    }

    public void setCurrentJobSeeker(JobSeeker jobSeeker) {
        this.currentJobSeeker = jobSeeker;
    }

    private JobSeeker getJobSeeker() {
        return this.currentJobSeeker;
    }

}