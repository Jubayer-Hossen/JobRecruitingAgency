package jubayer.hossen.jobrecruitingagency.JobSeeker.ControllerClasses;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import jubayer.hossen.jobrecruitingagency.JobSeeker.ModelClasses.JobSeeker;
import jubayer.hossen.jobrecruitingagency.MainApplication;

public class JobSeekerDashBoardController
{
    private JobSeeker currentJobSeeker;
    @javafx.fxml.FXML
    private TextField searchTextField;
    @javafx.fxml.FXML
    private SplitMenuButton profileSplitMenuButton;
    @javafx.fxml.FXML
    private Tab applicationTab;
    @javafx.fxml.FXML
    private Tab profileTab;
    @javafx.fxml.FXML
    private Tab interviewSlotsTab;
    @javafx.fxml.FXML
    private Tab jobOffersTab;
    @javafx.fxml.FXML
    private MenuItem changePasswordMenuButton;
    @javafx.fxml.FXML
    private Button searchButton;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void changePasswordMenuButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("JobSeeker/ChangePasswordView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Object controller = fxmlLoader.getController();
            if (controller instanceof ChangePasswordController) {
                ((ChangePasswordController) controller).setCurrentJobSeeker(this.currentJobSeeker);
            }

            Stage newStage = (Stage) searchButton.getScene().getWindow();
            newStage.setTitle("TalentSphere");
            newStage.setScene(scene);
            newStage.show();
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not open change password view!");
            alert.setContentText("Please try again later!");
            alert.showAndWait();
            return;
        }

    }

    @javafx.fxml.FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void profileMenuButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void signOutMenuButtonOnAction(ActionEvent actionEvent) {
        if (getJobSeeker() != null) {
            Stage stage = (Stage) profileSplitMenuButton.getScene().getWindow();
            stage.close();

            JobSeekerDashBoardController.this.currentJobSeeker.signOut();
        }

    }

    public void setCurrentJobSeeker(JobSeeker jobSeeker) {
        this.currentJobSeeker = jobSeeker;

        profileSplitMenuButton.setText(currentJobSeeker.getName());
    }

    private JobSeeker getJobSeeker() {
        return this.currentJobSeeker;
    }
}