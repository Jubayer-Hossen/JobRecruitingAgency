package jubayer.hossen.jobrecruitingagency.Interviewer;



import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class Reports {
    @FXML private ComboBox<String> reportTypeComboBox;
    @FXML private DatePicker startDatePicker;
    @FXML private DatePicker endDatePicker;
    @FXML private BarChart<String, Number> interviewStatsChart;
    @FXML private TableView<ReportData> detailedReportTable;
    @FXML
    private TableColumn metricColumn;
    @FXML
    private TableColumn valueColumn;

    @FXML
    public void initialize() {
        setupReportTypes();
        setDefaultDateRange();
        initializeChart();
    }

    private void setupReportTypes() {
        ObservableList<String> reportTypes = FXCollections.observableArrayList(
                "Weekly Summary", "Monthly Summary", "Interviewer Performance", "Candidate Pipeline"
        );
        reportTypeComboBox.setItems(reportTypes);
        reportTypeComboBox.setValue("Weekly Summary");
    }

    private void setDefaultDateRange() {
        endDatePicker.setValue(LocalDate.now());
        startDatePicker.setValue(LocalDate.now().minusDays(7));
    }

    private void initializeChart() {
        interviewStatsChart.getData().clear();

        XYChart.Series<String, Number> technicalSeries = new XYChart.Series<>();
        technicalSeries.setName("Technical Interviews");
        technicalSeries.getData().addAll(
                new XYChart.Data<>("Mon", 5),
                new XYChart.Data<>("Tue", 7),
                new XYChart.Data<>("Wed", 3),
                new XYChart.Data<>("Thu", 8),
                new XYChart.Data<>("Fri", 4)
        );

        XYChart.Series<String, Number> behavioralSeries = new XYChart.Series<>();
        behavioralSeries.setName("Behavioral Interviews");
        behavioralSeries.getData().addAll(
                new XYChart.Data<>("Mon", 3),
                new XYChart.Data<>("Tue", 4),
                new XYChart.Data<>("Wed", 2),
                new XYChart.Data<>("Thu", 5),
                new XYChart.Data<>("Fri", 3)
        );

        interviewStatsChart.getData().addAll(technicalSeries, behavioralSeries);
    }

    @FXML
    private void handleGenerateReport() {
        if (validateDateRange()) {
            updateDetailedReport();
            showAlert("Report Generated",
                    reportTypeComboBox.getValue() + " report generated from " +
                            startDatePicker.getValue() + " to " + endDatePicker.getValue());
        }
    }

    private boolean validateDateRange() {
        if (startDatePicker.getValue() == null || endDatePicker.getValue() == null) {
            showAlert("Error", "Please select both start and end dates");
            return false;
        }
        if (startDatePicker.getValue().isAfter(endDatePicker.getValue())) {
            showAlert("Error", "Start date must be before end date");
            return false;
        }
        return true;
    }

    private void updateDetailedReport() {
        ObservableList<ReportData> reportData = FXCollections.observableArrayList(
                new ReportData("Total Interviews", "15"),
                new ReportData("Average Duration", "45 mins"),
                new ReportData("Average Rating", "4.2/5"),
                new ReportData("Shortlist Rate", "60%"),
                new ReportData("Most Common Type", "Technical")
        );
        detailedReportTable.setItems(reportData);
    }

    @FXML
    private void handleExportToPDF() {
        showAlert("Export", "PDF export functionality would be implemented here");
    }

    @FXML
    private void handleExportToCSV() {
        showAlert("Export", "CSV export functionality would be implemented here");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static class ReportData {
        private final String metric;
        private final String value;

        public ReportData(String metric, String value) {
            this.metric = metric;
            this.value = value;
        }

        public String getMetric() { return metric; }
        public String getValue() { return value; }
    }
}