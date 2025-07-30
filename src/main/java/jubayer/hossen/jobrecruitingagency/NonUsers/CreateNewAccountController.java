package jubayer.hossen.jobrecruitingagency.NonUsers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import jubayer.hossen.jobrecruitingagency.MainApplication;

public class CreateNewAccountController
{
    @javafx.fxml.FXML
    private Button registerButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void registerButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("NonUsers/LoginPageView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage = (Stage) registerButton.getScene().getWindow();
            newStage.setTitle("TalentSphere");
            newStage.setScene(scene);
            newStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}