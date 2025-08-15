package jubayer.hossen.jobrecruitingagency.NonUsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jubayer.hossen.jobrecruitingagency.AppAdmin.AppAdmin;
import jubayer.hossen.jobrecruitingagency.AppAdmin.AppAdminDashBoardController;
import jubayer.hossen.jobrecruitingagency.BusinessDevelopmentExecutive.ControllerClasses.BusinessDevelopmentExecutiveDashBoardController;
import jubayer.hossen.jobrecruitingagency.BusinessDevelopmentExecutive.ModelClasses.BusinessDevelopmentExecutive;
import jubayer.hossen.jobrecruitingagency.JobSeeker.ControllerClasses.JobSeekerDashBoardController;
import jubayer.hossen.jobrecruitingagency.JobSeeker.ModelClasses.JobSeeker;
import jubayer.hossen.jobrecruitingagency.MainApplication;
import jubayer.hossen.jobrecruitingagency.User.User;

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
    private Button loginButton;
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
        String emailAddressOrUsername = emailAddressOrUsernameTextField.getText();
        String password = passwordPasswordField.getText();

        if (emailAddressOrUsername.isEmpty() || password.isEmpty()) {
            messageLabel.setText("Please fill in all fields!");
            messageLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        try {
            File file = new File("src\\main\\Files\\Users.bin");

            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            User authenticatedUser = null;
            
            while (true) {
                try {
                    Object object = objectInputStream.readObject();
                    if (object instanceof User user) {
                        User login = user.login(emailAddressOrUsername, password);
                        if (login != null) {
                            authenticatedUser = login;

                            break;
                        }
                    }
                }
                catch (java.io.EOFException e) {
                    break;
                }
                catch (ClassNotFoundException e){
                    messageLabel.setText("Class not found!");
                    messageLabel.setStyle("-fx-text-fill: red;");
                }
            }

            objectInputStream.close();

            if (authenticatedUser != null) {
                openUserDashboard(authenticatedUser);
            }
            else {
                messageLabel.setText("Invalid email/username or password!");
                messageLabel.setStyle("-fx-text-fill: red;");
            }

        }
        catch (java.io.FileNotFoundException e) {
            messageLabel.setText("No user data found! Please create an account first.");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
        catch (java.io.IOException e) {
            messageLabel.setText("Error occurred during login. Please try again!");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
    }

    private void openUserDashboard(User user) {
        try {
            String fxmlPath;
            String title;

            switch (user) {
                case JobSeeker jobSeeker -> {
                    fxmlPath = "JobSeeker/JobSeekerDashBoardView.fxml";
                    title = jobSeeker.getName() + "'s Dashboard";
                }
                case BusinessDevelopmentExecutive businessDevelopmentExecutive -> {
                    fxmlPath = "BusinessDevelopmentExecutive/BusinessDevelopmentExecutiveDashBoardView.fxml";
                    title = businessDevelopmentExecutive.getName() + "'s Dashboard";
                }
                case AppAdmin appAdmin -> {
                    fxmlPath = "AppAdmin/AppAdminDashBoardViews.fxml";
                    title = appAdmin.getName() + "'s Dashboard";
                }
                case null, default -> {
                    return;
                }
            }

            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fxmlPath));
            Scene scene = new Scene(fxmlLoader.load());

            Object controller = fxmlLoader.getController();

            switch (user){
                case JobSeeker jobSeeker -> {
                    if (controller instanceof JobSeekerDashBoardController dashboardController) {
                        dashboardController.setCurrentJobSeeker(jobSeeker);
                    }
                }
                case BusinessDevelopmentExecutive businessDevelopmentExecutive -> {
                    if (controller instanceof BusinessDevelopmentExecutiveDashBoardController dashboardController) {
                        dashboardController.setCurrentBusinessDevelopmentExecutive(businessDevelopmentExecutive);
                    }
                }
                case AppAdmin appAdmin -> {
                    if (controller instanceof AppAdminDashBoardController dashboardController) {
                        dashboardController.setCurrentAppAdmin(appAdmin);
                    }
                }
                case null, default -> {
                    return;
                }
            }

            Stage newStage = (Stage) loginButton.getScene().getWindow();
            newStage.setTitle(title);
            newStage.setScene(scene);
            newStage.show();

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error while loading dashboard!");
            alert.setContentText("Please try again later!");
            alert.showAndWait();
        }
    }
}