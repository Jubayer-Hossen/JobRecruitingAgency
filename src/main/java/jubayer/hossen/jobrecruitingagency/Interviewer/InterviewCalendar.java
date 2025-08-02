package jubayer.hossen.jobrecruitingagency.Interviewer;




import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javafx.scene.chart.PieChart;

public class InterviewCalendar {
    @FXML private ComboBox<String> filterComboBox;
    @FXML private DatePicker dateRangePicker;
    @FXML private TableView<Interview> interviewTableView;
    @FXML private Button cancelInterviewButton;
    @FXML private Button rescheduleInterviewButton;
    @FXML private PieChart interviewStatsChart;

    private ObservableList<Interview> interviewList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        setupFilterOptions();
        loadSampleData();
        setupTableSelection();
        updateStatsChart();
    }

    private void setupFilterOptions() {
        ObservableList<String> filterOptions = FXCollections.observableArrayList(
                "All Interviews", "Today", "This Week", "This Month", "Upcoming", "Completed"
        );
        filterComboBox.setItems(filterOptions);
        filterComboBox.setValue("Upcoming");
    }

    private void loadSampleData() {
        LocalDateTime now = LocalDateTime.now();
        interviewList.addAll(
                new Interview(1, 1001, "John Doe", 2001, "Sarah Johnson",
                        3001, "Software Engineer", now.plusDays(1), "Technical", "Scheduled"),
                new Interview(2, 1002, "Jane Smith", 2002, "Michael Brown",
                        3002, "UX Designer", now.plusDays(2), "Behavioral", "Scheduled"),
                new Interview(3, 1003, "Robert Johnson", 2001, "Sarah Johnson",
                        3001, "Software Engineer", now.minusDays(1), "Technical", "Completed")
        );
        interviewTableView.setItems(interviewList);
    }

    private void setupTableSelection() {
        interviewTableView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    boolean disableButtons = newSelection == null;
                    cancelInterviewButton.setDisable(disableButtons);
                    rescheduleInterviewButton.setDisable(disableButtons);
                }
        );
    }

    private void updateStatsChart() {
        long scheduled = interviewList.stream()
                .filter(i -> "Scheduled".equals(i.getStatus()))
                .count();
        long completed = interviewList.stream()
                .filter(i -> "Completed".equals(i.getStatus()))
                .count();

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Scheduled", scheduled),
                new PieChart.Data("Completed", completed)
        );
        interviewStatsChart.setData(pieChartData);
    }

    @FXML
    private void handleApplyFilter() {
        String filter = filterComboBox.getValue();
        if ("Completed".equals(filter)) {
            interviewTableView.setItems(interviewList.filtered(i -> "Completed".equals(i.getStatus())));
        } else if ("Upcoming".equals(filter)) {
            interviewTableView.setItems(interviewList.filtered(i -> "Scheduled".equals(i.getStatus())));
        } else {
            interviewTableView.setItems(interviewList);
        }
        updateStatsChart();
    }

    @FXML
    private void handleCancelInterview() {
        Interview selected = interviewTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Cancelled");
            interviewTableView.refresh();
            updateStatsChart();
            showAlert("Interview Cancelled",
                    "Interview with " + selected.getCandidateName() + " has been cancelled");
        }
    }

    @FXML
    private void handleRescheduleInterview() {
        showAlert("Reschedule", "Reschedule functionality would be implemented here");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}