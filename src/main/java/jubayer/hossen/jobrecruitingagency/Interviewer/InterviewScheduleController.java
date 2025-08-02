package jubayer.hossen.jobrecruitingagency.Interviewer;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InterviewScheduleController {
    @FXML private ComboBox<String> candidateComboBox;
    @FXML private DatePicker interviewDatePicker;
    @FXML private ComboBox<String> timeSlotComboBox;
    @FXML private ComboBox<String> interviewTypeComboBox;
    @FXML private Label statusLabel;

    private ObservableList<String> candidateList = FXCollections.observableArrayList(
            "John Doe (ID: 1001)", "Jane Smith (ID: 1002)", "Robert Johnson (ID: 1003)"
    );

    private ObservableList<String> timeSlots = FXCollections.observableArrayList(
            "09:00 AM", "10:00 AM", "11:00 AM", "01:00 PM", "02:00 PM", "03:00 PM"
    );

    private ObservableList<String> interviewTypes = FXCollections.observableArrayList(
            "Technical", "Behavioral", "HR", "Panel", "Phone Screen"
    );

    @FXML
    public void initialize() {
        candidateComboBox.setItems(candidateList);
        timeSlotComboBox.setItems(timeSlots);
        interviewTypeComboBox.setItems(interviewTypes);

        // Set default date to today
        interviewDatePicker.setValue(LocalDate.now());
    }

    @FXML
    private void handleScheduleInterview() {
        if (validateInput()) {
            String candidate = candidateComboBox.getValue();
            LocalDate date = interviewDatePicker.getValue();
            String time = timeSlotComboBox.getValue();
            String type = interviewTypeComboBox.getValue();

            try {
                // Parse time
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
                LocalTime parsedTime = LocalTime.parse(time, formatter);
                LocalDateTime interviewDateTime = LocalDateTime.of(date, parsedTime);

                // In a real application, you would save this to a database
                Interview newInterview = new Interview();
                newInterview.setCandidateName(candidate.split("\\(")[0].trim());
                newInterview.setInterviewTime(interviewDateTime);
                newInterview.setInterviewType(type);
                newInterview.setStatus("Scheduled");

                statusLabel.setText("Interview scheduled successfully for " + candidate + " on " +
                        date + " at " + time);
                clearForm();
            } catch (Exception e) {
                statusLabel.setText("Error scheduling interview: " + e.getMessage());
            }
        }
    }

    private boolean validateInput() {
        if (candidateComboBox.getValue() == null) {
            statusLabel.setText("Please select a candidate");
            return false;
        }
        if (interviewDatePicker.getValue() == null) {
            statusLabel.setText("Please select a date");
            return false;
        }
        if (timeSlotComboBox.getValue() == null) {
            statusLabel.setText("Please select a time slot");
            return false;
        }
        if (interviewTypeComboBox.getValue() == null) {
            statusLabel.setText("Please select an interview type");
            return false;
        }
        return true;
    }

    private void clearForm() {
        candidateComboBox.setValue(null);
        interviewDatePicker.setValue(LocalDate.now());
        timeSlotComboBox.setValue(null);
        interviewTypeComboBox.setValue(null);
    }
}