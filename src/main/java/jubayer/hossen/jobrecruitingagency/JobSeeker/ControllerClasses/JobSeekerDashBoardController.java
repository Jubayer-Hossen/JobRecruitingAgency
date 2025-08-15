package jubayer.hossen.jobrecruitingagency.JobSeeker.ControllerClasses;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
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
    private ComboBox<String> searchByKeywordsComboBox;
    @javafx.fxml.FXML
    private BorderPane jobSeekerDashBoardBoarderPane;
    @javafx.fxml.FXML
    private AnchorPane applicationStatusTabAnchorPane;
    @javafx.fxml.FXML
    private Tab profileTab1;
    @javafx.fxml.FXML
    private AnchorPane myApplicationsTabAnchorPane;
    @javafx.fxml.FXML
    private AnchorPane profileTabAnchorPane;
    @javafx.fxml.FXML
    private AnchorPane jobOffersTabAnchorPane;
    @javafx.fxml.FXML
    private AnchorPane interviewSlotsTabAnchorPane;

    @javafx.fxml.FXML
    public void initialize() {
        try {
            FXMLLoader profileLoader = new FXMLLoader(MainApplication.class.getResource("JobSeeker/JobSeekerProfileView.fxml"));
            AnchorPane profileContent = profileLoader.load();
            profileTabAnchorPane.getChildren().setAll(profileContent);

            FXMLLoader myApplicationsLoader = new FXMLLoader(MainApplication.class.getResource("JobSeeker/JobSeekerApplicationsView.fxml"));
            AnchorPane myApplicationsContent = myApplicationsLoader.load();
            myApplicationsTabAnchorPane.getChildren().setAll(myApplicationsContent);

            FXMLLoader applicationStatusLoader = new FXMLLoader(MainApplication.class.getResource("JobSeeker/JobApplicationStatusView.fxml"));
            AnchorPane applicationStatusContent = applicationStatusLoader.load();
            applicationStatusTabAnchorPane.getChildren().setAll(applicationStatusContent);

            FXMLLoader jobOffersLoader = new FXMLLoader(MainApplication.class.getResource("JobSeeker/OfferedJobsView.fxml"));
            AnchorPane jobOffersContent = jobOffersLoader.load();
            jobOffersTabAnchorPane.getChildren().setAll(jobOffersContent);

            FXMLLoader interviewSlotsLoader = new FXMLLoader(MainApplication.class.getResource("JobSeeker/InterviewSlotsView.fxml"));
            AnchorPane interviewSlotsContent = interviewSlotsLoader.load();
            interviewSlotsTabAnchorPane.getChildren().setAll(interviewSlotsContent);

        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not open tab views!");
            alert.setContentText("Please try again later!");
            alert.showAndWait();
            return;
        }

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
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("JobSeeker/JobSeekerProfileUpdaterView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Object controller = fxmlLoader.getController();
            if (controller instanceof JobSeekerProfileUpdaterController) {
                ((JobSeekerProfileUpdaterController) controller).setCurrentJobSeeker(this.currentJobSeeker);
            }

            Stage newStage = (Stage) profileSplitMenuButton.getScene().getWindow();
            newStage.setTitle("TalentSphere");
            newStage.setScene(scene);
            newStage.show();
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not open profile view!");
            alert.setContentText("Please try again later!");
            alert.showAndWait();
            return;
        }

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

    @javafx.fxml.FXML
    public void jobOffersTabOnSelectionChanged(Event event) {
    }

    @javafx.fxml.FXML
    public void applicationTabOnSelectionChanged(Event event) {
    }

    @javafx.fxml.FXML
    public void profileTabOnSelectionChanged(Event event) {
    }

    @javafx.fxml.FXML
    public void interviewSlotsTabOnSelectionChanged(Event event) {
    }
}