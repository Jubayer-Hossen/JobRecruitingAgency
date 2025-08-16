package jubayer.hossen.jobrecruitingagency.JobSeeker.ControllerClasses;

import javafx.scene.control.ListView;
import jubayer.hossen.jobrecruitingagency.JobSeeker.ModelClasses.JobSeeker;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class JobSeekerApplicationsController
{
    private JobSeeker currentJobSeeker;
    @javafx.fxml.FXML
    private ListView<String> jobApplictionsListView;

    @javafx.fxml.FXML
    public void initialize() {

    }

    public void setCurrentJobSeeker(JobSeeker jobSeeker) {
        this.currentJobSeeker = jobSeeker;
    }

    private JobSeeker getJobSeeker() {
        return this.currentJobSeeker;
    }

}