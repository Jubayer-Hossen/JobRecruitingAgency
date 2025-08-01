package jubayer.hossen.jobrecruitingagency.AppAdmin;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SecurityLogsController
{
    @javafx.fxml.FXML
    private TableColumn userTC;
    @javafx.fxml.FXML
    private TableView loginHistoryTableView;
    @javafx.fxml.FXML
    private TableColumn timestampTC;
    @javafx.fxml.FXML
    private TableColumn ipTC;
    @javafx.fxml.FXML
    private TableColumn statusTC;
    @javafx.fxml.FXML
    private Label twoFAStatusLabel;
    @javafx.fxml.FXML
    private ListView flaggedAccountsList;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void enable2FAOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void monitorAccountsOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewLoginHistoryOA(ActionEvent actionEvent) {
    }
}