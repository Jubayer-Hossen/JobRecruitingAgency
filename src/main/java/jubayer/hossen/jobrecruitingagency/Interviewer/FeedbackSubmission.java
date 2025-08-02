package jubayer.hossen.jobrecruitingagency.Interviewer;



import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDateTime;

public class FeedbackSubmission {
    @FXML private Label candidateNameLabel;
    @FXML private Label interviewDateLabel;
    @FXML private Slider technicalSkillsSlider;
    @FXML private Slider communicationSlider;
    @FXML private Slider culturalFitSlider;
    @FXML private ComboBox<String> recommendationComboBox;
    @FXML private TextArea commentsTextArea;
    @FXML private Label statusLabel;

    private Interview currentInterview;

    private ObservableList<String> recommendations = FXCollections.observableArrayList(
            "Strongly Recommend", "Recommend", "Recommend with Reservations",
            "Not Recommended", "On Hold"
    );

    @FXML
    public void initialize() {
        recommendationComboBox.setItems(recommendations);

        // Initialize with sample data
        currentInterview = new Interview();
        currentInterview.setCandidateName("John Doe");
        currentInterview.setInterviewTime(LocalDateTime.now());
        currentInterview.setJobTitle("Software Engineer");

        updateUI();
    }

    private void updateUI() {
        candidateNameLabel.setText(currentInterview.getCandidateName());
        interviewDateLabel.setText(currentInterview.getInterviewTime().toString());
    }

    @FXML
    private void handleSubmitFeedback() {
        if (validateInput()) {
            currentInterview.setTechnicalScore(technicalSkillsSlider.getValue());
            currentInterview.setCommunicationScore(communicationSlider.getValue());
            currentInterview.setCulturalFitScore(culturalFitSlider.getValue());
            currentInterview.setRecommendation(recommendationComboBox.getValue());
            currentInterview.setFeedback(commentsTextArea.getText());
            currentInterview.setStatus("Completed");

            statusLabel.setText("Feedback submitted for " + currentInterview.getCandidateName());
            disableForm();
        }
    }

    private boolean validateInput() {
        if (recommendationComboBox.getValue() == null) {
            statusLabel.setText("Please select a recommendation");
            return false;
        }
        if (commentsTextArea.getText().isEmpty()) {
            statusLabel.setText("Please provide comments");
            return false;
        }
        return true;
    }

    private void disableForm() {
        technicalSkillsSlider.setDisable(true);
        communicationSlider.setDisable(true);
        culturalFitSlider.setDisable(true);
        recommendationComboBox.setDisable(true);
        commentsTextArea.setDisable(true);
    }
}