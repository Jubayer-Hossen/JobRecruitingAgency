package jubayer.hossen.jobrecruitingagency.JobSeeker.ControllerClasses;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import jubayer.hossen.jobrecruitingagency.HelperClasses.AppendableObjectOutputStream;
import jubayer.hossen.jobrecruitingagency.JobSeeker.ModelClasses.JobSeeker;
import jubayer.hossen.jobrecruitingagency.MainApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class JobSeekerProfileUpdaterController {
    private JobSeeker currentJobSeeker;
    @javafx.fxml.FXML
    private TextField phoneNumberTextField;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private TextField NameTextField;
    @javafx.fxml.FXML
    private TextArea skillsTextArea;
    @javafx.fxml.FXML
    private TextArea summaryTextArea;
    @javafx.fxml.FXML
    private Button backHomeButton;
    @javafx.fxml.FXML
    private Label updateProfileMessageLabel;

    @javafx.fxml.FXML
    public void initialize() {
        emailTextField.editableProperty().setValue(false);
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
            alert.setHeaderText("Could not get back to home!");
            alert.setContentText("Please try again!!");
            alert.showAndWait();
            return;
        }
    }

    @javafx.fxml.FXML
    public void updateProfileButtonOnAction(ActionEvent actionEvent) {
        File jobSeekersFile = new File("src\\main\\Files\\JobSeekers.bin");
        ObjectOutputStream objectOutputStream = null;

        String phoneNumber = phoneNumberTextField.getText();
        String email = emailTextField.getText();
        String name = NameTextField.getText();
        String skills = skillsTextArea.getText();
        String summary = summaryTextArea.getText();

        if (name.isEmpty() || skills.isEmpty() || summary.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Fill all the fields!");
            alert.setContentText("Please try again!!");
            alert.showAndWait();
            return;
        }

        JobSeeker jobSeeker = new JobSeeker(currentJobSeeker.getUserID(), currentJobSeeker.getPassword(), name, email,
                currentJobSeeker.getJobSeekerID(),LocalDate.now(), phoneNumber, skills, summary);


        try {
            if (jobSeekersFile.exists()){
                FileOutputStream fileOutputStream = new FileOutputStream(jobSeekersFile, true);
                objectOutputStream = new AppendableObjectOutputStream(fileOutputStream);
            }
            else {
                FileOutputStream fileOutputStream = new FileOutputStream(jobSeekersFile);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            }

            objectOutputStream.writeObject(jobSeeker);
            objectOutputStream.close();

            updateProfileMessageLabel.setText("Profile updated successfully!");
            updateProfileMessageLabel.setStyle("-fx-text-fill: green;");
        }
        catch (Exception e){
            updateProfileMessageLabel.setText("Error while updating profile!");
            updateProfileMessageLabel.setStyle("-fx-text-fill: red;");
            return;
        }
    }

    public void setCurrentJobSeeker(JobSeeker jobSeeker) {
        this.currentJobSeeker = jobSeeker;

        NameTextField.setText(currentJobSeeker.getName());
        emailTextField.setText(currentJobSeeker.getEmail());
    }

    private JobSeeker getJobSeeker() {
        return this.currentJobSeeker;
    }
}