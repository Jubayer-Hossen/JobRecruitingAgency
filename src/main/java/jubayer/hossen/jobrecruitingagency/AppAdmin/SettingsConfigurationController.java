package jubayer.hossen.jobrecruitingagency.AppAdmin;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SettingsConfigurationController
{
    @javafx.fxml.FXML
    private CheckBox smsNotificationsCheckbox;
    @javafx.fxml.FXML
    private ComboBox<String> visibilityComboBox;
    @javafx.fxml.FXML
    private CheckBox emailNotificationsCheckbox;
    @javafx.fxml.FXML
    private Label paymentStatusLabel;
    @javafx.fxml.FXML
    private TextField defaultDurationTF;

    @javafx.fxml.FXML
    public void initialize() {

        visibilityComboBox.getItems().addAll("Public", "Private", "Invite Only");
    }

    @javafx.fxml.FXML
    public void configureEmailTemplatesOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void managePaymentPlansOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveSettings(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void previewtemplatesOA(ActionEvent actionEvent) {
    }
}