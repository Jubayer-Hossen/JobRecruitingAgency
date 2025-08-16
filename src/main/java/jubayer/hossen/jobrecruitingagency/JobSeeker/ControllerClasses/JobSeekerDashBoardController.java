package jubayer.hossen.jobrecruitingagency.JobSeeker.ControllerClasses;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
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
        searchByKeywordsComboBox.getItems().addAll("Information Technology", "Healthcare", "Finance", "Marketing", "Engineering");

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
        try {
            String searchQuery = searchTextField.getText().trim();
            String searchCategory = searchByKeywordsComboBox.getValue();

            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("JobSeeker/SearchedJobsView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Object controller = fxmlLoader.getController();
            if (controller instanceof SearchedJobsController searchedJobsController) {
                searchedJobsController.setCurrentJobSeeker(this.currentJobSeeker);
                searchedJobsController.searchJobs(searchQuery, searchCategory);
            }

            Stage newStage = (Stage) searchButton.getScene().getWindow();
            newStage.setTitle("TalentSphere - Search Results");
            newStage.setScene(scene);
            newStage.show();
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not open search results!");
            alert.setContentText("Please try again later!");
            alert.showAndWait();
        }
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

        try {
            FXMLLoader profileLoader = new FXMLLoader(MainApplication.class.getResource("JobSeeker/JobSeekerProfileView.fxml"));
            AnchorPane profileContent = profileLoader.load();

            Object controller = profileLoader.getController();
            if (controller instanceof JobSeekerProfileController jobSeekerProfileController) {
                jobSeekerProfileController.setCurrentJobSeeker(this.currentJobSeeker);
            }
            profileTabAnchorPane.getChildren().setAll(profileContent);

            FXMLLoader myApplicationsLoader = new FXMLLoader(MainApplication.class.getResource("JobSeeker/JobSeekerApplicationsView.fxml"));
            AnchorPane myApplicationsContent = myApplicationsLoader.load();

            Object controller1 = myApplicationsLoader.getController();
            if (controller1 instanceof JobSeekerApplicationsController jobSeekerApplicationsController) {
                jobSeekerApplicationsController.setCurrentJobSeeker(this.currentJobSeeker);
            }
            myApplicationsTabAnchorPane.getChildren().setAll(myApplicationsContent);

            FXMLLoader applicationStatusLoader = new FXMLLoader(MainApplication.class.getResource("JobSeeker/JobApplicationStatusView.fxml"));
            AnchorPane applicationStatusContent = applicationStatusLoader.load();

            Object controller2 = applicationStatusLoader.getController();
            if (controller2 instanceof JobApplicationStatusController  jobApplicationStatusController) {
                jobApplicationStatusController.setCurrentJobSeeker(this.currentJobSeeker);
            }
            applicationStatusTabAnchorPane.getChildren().setAll(applicationStatusContent);

            FXMLLoader jobOffersLoader = new FXMLLoader(MainApplication.class.getResource("JobSeeker/OfferedJobsView.fxml"));
            AnchorPane jobOffersContent = jobOffersLoader.load();

            Object controller3 = jobOffersLoader.getController();
            if (controller3 instanceof OfferedJobsController offeredJobsController) {
                offeredJobsController.setCurrentJobSeeker(this.currentJobSeeker);
            }
            jobOffersTabAnchorPane.getChildren().setAll(jobOffersContent);

            FXMLLoader interviewSlotsLoader = new FXMLLoader(MainApplication.class.getResource("JobSeeker/InterviewSlotsView.fxml"));
            AnchorPane interviewSlotsContent = interviewSlotsLoader.load();

            Object controller4 = interviewSlotsLoader.getController();
            if (controller4 instanceof InterviewSlotsController interviewSlotsController) {
                interviewSlotsController.setCurrentJobSeeker(this.currentJobSeeker);
            }
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

    private JobSeeker getJobSeeker() {
        return this.currentJobSeeker;
    }

}