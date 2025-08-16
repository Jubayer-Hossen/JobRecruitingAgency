package jubayer.hossen.jobrecruitingagency.JobSeeker.ControllerClasses;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jubayer.hossen.jobrecruitingagency.HelperClasses.AppendableObjectOutputStream;
import jubayer.hossen.jobrecruitingagency.JobSeeker.ModelClasses.Application;
import jubayer.hossen.jobrecruitingagency.JobSeeker.ModelClasses.Job;
import jubayer.hossen.jobrecruitingagency.JobSeeker.ModelClasses.JobSeeker;
import jubayer.hossen.jobrecruitingagency.MainApplication;

public class SearchedJobsController{

    private JobSeeker currentJobSeeker;
    @javafx.fxml.FXML
    private Label jobsFoundLabel;
    @javafx.fxml.FXML
    private ListView<VBox> jobsListView;
    @javafx.fxml.FXML
    private Label searchQueryLabel;
    
    private ArrayList<Job> searchResults;

    @javafx.fxml.FXML
    public void initialize() {
        searchResults = new ArrayList<>();
    }

    public void searchJobs(String searchQuery, String searchCategory) {
        searchQueryLabel.setText("Search Query: \"" + searchQuery + "\"" + 
                                (searchCategory != null ? " in " + searchCategory : ""));
        
        List<Job> allJobs = loadJobsFromFile();
        searchResults.clear();

        for (Job job : allJobs) {
            if (searchCategory == null && job.getJobTitle().toLowerCase().contains(searchQuery.toLowerCase())) {
                searchResults.add(job);
            }
            else if (searchCategory != null &&
                    (searchCategory.equalsIgnoreCase(job.getCategory()) || job.getJobTitle().toLowerCase().contains(searchCategory.toLowerCase()))) {
                searchResults.add(job);
            }
        }

        updateJobsList();
    }

    private void updateJobsList() {
        jobsListView.getItems().clear();
        jobsFoundLabel.setText(searchResults.size() + " Jobs Found");
        
        for (Job job : searchResults) {
            VBox jobCard = createJobCard(job);
            jobsListView.getItems().add(jobCard);
        }
    }

    private VBox createJobCard(Job job) {
        VBox jobCard = new VBox();

        Label titleLabel = new Label(job.getJobTitle());

        Label companyLabel = new Label("Company: " + job.getCompany().getCompanyName());

        Label categoryLabel = new Label("Category: " + job.getCategory());

        Label deadlineLabel = new Label("Deadline: " + job.getDeadline());

        Button applyButton = new Button("Apply");

        applyButton.setOnAction(_ -> applyToJob(job));
        
        HBox buttonBox = new HBox();
        buttonBox.getChildren().add(applyButton);
        HBox.setHgrow(applyButton, Priority.NEVER);
        
        jobCard.getChildren().addAll(titleLabel, companyLabel, categoryLabel, deadlineLabel, buttonBox);
        
        return jobCard;
    }

    private void applyToJob(Job job) {
        try {
            if (hasAlreadyApplied(job)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Already Applied");
                alert.setContentText("You have already applied to this job.");
                alert.showAndWait();
                return;
            }
            
            String applicationID = UUID.randomUUID().toString();
            String applicationDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            
            Application application = new Application(
                applicationDate,
                applicationID,
                job.getCompany(),
                job,
                currentJobSeeker,
                "Pending"
            );
            
            saveApplicationToFile(application);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Application Submitted");
            alert.setContentText("Your application has been submitted successfully!");
            alert.showAndWait();
            
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Application Failed");
            alert.setContentText("Could not submit your application. Please try again.");
            alert.showAndWait();
        }
    }

    private boolean hasAlreadyApplied(Job job) {
        try {
            File file = new File("src\\main\\Files\\Applications.bin");
            if (!file.exists()) {
                return false;
            }
            
            List<Application> applications = loadApplicationsFromFile();
            for (Application app : applications) {
                if (app.getJobSeeker().getJobSeekerID().equals(currentJobSeeker.getJobSeekerID()) &&
                    app.getJob().getJobID().equals(job.getJobID())) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void saveApplicationToFile(Application application) throws IOException {
        File file = new File("src\\main\\Files\\Applications.bin");

        if (file.exists()) {
            try (FileOutputStream fos = new FileOutputStream(file, true);
                 AppendableObjectOutputStream oos = new AppendableObjectOutputStream(fos)) {
                oos.writeObject(application);
            }
        } else {
            try (FileOutputStream fos = new FileOutputStream(file);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(application);
            }
        }
    }

    private List<Application> loadApplicationsFromFile() {
        List<Application> applications = new ArrayList<>();
        File file = new File("src\\main\\Files\\Applications.bin");

        if (!file.exists()) {
            return applications;
        }
        
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            
            while (true) {
                try {
                    Application application = (Application) ois.readObject();
                    applications.add(application);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return applications;
    }

    private List<Job> loadJobsFromFile() {
        List<Job> jobs = new ArrayList<>();
        File file = new File("src\\main\\Files\\Jobs.bin");
        
        if (!file.exists()) {
            return jobs;
        }
        
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            
            while (true) {
                try {
                    Job job = (Job) ois.readObject();
                    jobs.add(job);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return jobs;
    }

    @javafx.fxml.FXML
    public void backHomeButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("JobSeeker/JobSeekerDashBoardView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Object controller = fxmlLoader.getController();
            if (controller instanceof JobSeekerDashBoardController) {
                ((JobSeekerDashBoardController) controller).setCurrentJobSeeker(this.currentJobSeeker);
            }

            Stage stage = (Stage) jobsFoundLabel.getScene().getWindow();
            stage.setTitle("TalentSphere - Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not return to dashboard!");
            alert.setContentText("Please try again later!");
            alert.showAndWait();
        }
    }

    public void setCurrentJobSeeker(JobSeeker jobSeeker) {
        this.currentJobSeeker = jobSeeker;
    }
}