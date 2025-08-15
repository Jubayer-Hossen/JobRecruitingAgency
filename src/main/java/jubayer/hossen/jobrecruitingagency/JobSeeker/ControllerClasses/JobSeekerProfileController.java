package jubayer.hossen.jobrecruitingagency.JobSeeker.ControllerClasses;

import javafx.scene.control.Label;
import jubayer.hossen.jobrecruitingagency.JobSeeker.ModelClasses.JobSeeker;

public class JobSeekerProfileController
{
    private JobSeeker currentJobSeeker;

    @javafx.fxml.FXML
    private Label fullNameLabel;
    @javafx.fxml.FXML
    private Label userIDLabel;

    @javafx.fxml.FXML
    public void initialize() {

    }


    public void setCurrentJobSeeker(JobSeeker jobSeeker) {
        this.currentJobSeeker = jobSeeker;

        userIDLabel.setText(currentJobSeeker.getJobSeekerID());
        fullNameLabel.setText(currentJobSeeker.getName());
    }


    private JobSeeker getJobSeeker() {
        return this.currentJobSeeker;
    }
}