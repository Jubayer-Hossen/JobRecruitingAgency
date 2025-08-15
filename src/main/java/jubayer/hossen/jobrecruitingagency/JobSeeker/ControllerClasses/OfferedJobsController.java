package jubayer.hossen.jobrecruitingagency.JobSeeker.ControllerClasses;


import jubayer.hossen.jobrecruitingagency.JobSeeker.ModelClasses.JobSeeker;

public class OfferedJobsController
{
    private JobSeeker currentJobSeeker;

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