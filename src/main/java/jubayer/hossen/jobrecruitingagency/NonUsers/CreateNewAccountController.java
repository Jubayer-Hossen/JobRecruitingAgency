package jubayer.hossen.jobrecruitingagency.NonUsers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import jubayer.hossen.jobrecruitingagency.AppAdmin.AppAdmin;
import jubayer.hossen.jobrecruitingagency.HelperClasses.AppendableObjectOutputStream;
import jubayer.hossen.jobrecruitingagency.JobSeeker.ModelClasses.JobSeeker;
import jubayer.hossen.jobrecruitingagency.MainApplication;
import jubayer.hossen.jobrecruitingagency.User.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

public class CreateNewAccountController
{
    @javafx.fxml.FXML
    private Button registerButton;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private PasswordField createPasswordPasswordField;
    @javafx.fxml.FXML
    private PasswordField confirmPasswordPasswordField;
    @javafx.fxml.FXML
    private Label createPasswordLabel;
    @javafx.fxml.FXML
    private TextField createPasswordTextField;
    @javafx.fxml.FXML
    private TextField confirmPasswordTextField;
    @javafx.fxml.FXML
    private Button backToLoginPageButton;

    @javafx.fxml.FXML
    public void initialize() {


    }

    @javafx.fxml.FXML
    public void registerButtonOnAction(ActionEvent actionEvent) {

        ObjectOutputStream objectOutputStream = null;

        String password;
        String confirmPassword;

        if (createPasswordPasswordField.isVisible()) {
            password = createPasswordPasswordField.getText();
        } else {
            password = createPasswordTextField.getText();
        }

        if (confirmPasswordPasswordField.isVisible()) {
            confirmPassword = confirmPasswordPasswordField.getText();
        } else {
            confirmPassword = confirmPasswordTextField.getText();
        }

        if (!password.equals(confirmPassword) ) {
            createPasswordLabel.setText("Passwords do not match!");
            createPasswordLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        User user = new JobSeeker(generateRandomUserId(), password, nameTextField.getText(), emailTextField.getText());

        try {
            File file = new File("src\\main\\Files\\Users.bin");

            if (file.exists()){
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                objectOutputStream = new AppendableObjectOutputStream(fileOutputStream);

                objectOutputStream.writeObject(user);
                objectOutputStream.close();
            }
            else {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                User defaultAdmin = new AppAdmin("admin", "admin", "admin", "admin@ts.com");

                objectOutputStream.writeObject(defaultAdmin);
                objectOutputStream.close();

                objectOutputStream = new AppendableObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(user);
                objectOutputStream.close();

            }


            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("NonUsers/LoginPageView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage = (Stage) registerButton.getScene().getWindow();
            newStage.setTitle("TalentSphere");
            newStage.setScene(scene);
            newStage.show();
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

    @javafx.fxml.FXML
    public void showPasswordsCheckBoxOnAction(ActionEvent actionEvent) {
        CheckBox checkBox = (CheckBox) actionEvent.getSource();
        boolean checked = checkBox.isSelected();

        if (checked){
            createPasswordTextField.setText(createPasswordPasswordField.getText());
            confirmPasswordTextField.setText(confirmPasswordPasswordField.getText());

            createPasswordTextField.setVisible(true);
            confirmPasswordTextField.setVisible(true);
            createPasswordPasswordField.setVisible(false);
            confirmPasswordPasswordField.setVisible(false);
        } else {
            createPasswordPasswordField.setText(createPasswordTextField.getText());
            confirmPasswordPasswordField.setText(confirmPasswordTextField.getText());

            createPasswordPasswordField.setVisible(true);
            confirmPasswordPasswordField.setVisible(true);
            createPasswordTextField.setVisible(false);
            confirmPasswordTextField.setVisible(false);
        }

    }

    private String generateRandomUserId() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder userId = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            userId.append(characters.charAt(random.nextInt(characters.length())));
        }

        return userId.toString();
    }

    @javafx.fxml.FXML
    public void backToLoginPageButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("NonUsers/LoginPageView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage = (Stage) backToLoginPageButton.getScene().getWindow();
            newStage.setTitle("TalentSphere");
            newStage.setScene(scene);
            newStage.show();
        } catch (Exception e) {
            //
        }
    }
}