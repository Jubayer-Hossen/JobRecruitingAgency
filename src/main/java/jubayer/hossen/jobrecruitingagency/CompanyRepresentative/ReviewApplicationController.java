package jubayer.hossen.jobrecruitingagency.CompanyRepresentative;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ReviewApplicationController
{
    @javafx.fxml.FXML
    private TableColumn skillsTC;
    @javafx.fxml.FXML
    private ComboBox<String> statusFilterComboBOX;
    @javafx.fxml.FXML
    private TableView applicantTableView;
    @javafx.fxml.FXML
    private TableColumn nameTC;
    @javafx.fxml.FXML
    private TableColumn statusTC;
    @javafx.fxml.FXML
    private TableColumn experienceTC;

    @javafx.fxml.FXML
    public void initialize() {

        statusFilterComboBOX.getItems().addAll("All", "Shortlisted", "Rejected", "Pending");


    }

    @javafx.fxml.FXML
    public void shortlistCandidateOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void rejectCandidateOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void markPendingOA(ActionEvent actionEvent) {
    }
}