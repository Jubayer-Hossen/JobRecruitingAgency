package jubayer.hossen.jobrecruitingagency.AppAdmin;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import jubayer.hossen.jobrecruitingagency.AppAdmin.AppAdmin;

public class AppAdminDashBoardController
{
    private AppAdmin currentAppAdmin;
    @javafx.fxml.FXML
    private Label pendingVerificationsLabel;
    @javafx.fxml.FXML
    private TableView employerSnapshotTableView;
    @javafx.fxml.FXML
    private Label activeEmployersLabel;
    @javafx.fxml.FXML
    private Label activeJobsLabel;
    @javafx.fxml.FXML
    private ListView alertListView;
    @javafx.fxml.FXML
    private Label newCandidatesLabel;
    @javafx.fxml.FXML
    private TableView activityTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void exportReportOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void adjustLimitOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshActivityOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void investigateAlertOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void suspendEmployerOA(ActionEvent actionEvent) {
    }

    public void setCurrentAppAdmin(AppAdmin appAdmin) {
        this.currentAppAdmin = appAdmin;
    }

    public AppAdmin getCurrentAppAdmin() {
        return this.currentAppAdmin;
    }

    @javafx.fxml.FXML
    public void CreateNewUserOA(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void signOutMenuButtonOnAction(ActionEvent actionEvent) {
        if (currentAppAdmin != null) {
            Stage stage = (Stage) alertListView.getScene().getWindow();
            stage.close();

            AppAdminDashBoardController.this.currentAppAdmin.logout();
        }

    }
}