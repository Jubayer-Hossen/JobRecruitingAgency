package jubayer.hossen.jobrecruitingagency.CompanyRepresentative;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class JobPostingCreationController
{
    @javafx.fxml.FXML
    private ComboBox<String> employmentTypeCB;
    @javafx.fxml.FXML
    private TextField jobDescriptionTF;
    @javafx.fxml.FXML
    private DatePicker deadlineDatePicker;
    @javafx.fxml.FXML
    private TextField salaryTF;
    @javafx.fxml.FXML
    private TextField jobTitleTF;
    @javafx.fxml.FXML
    private TextArea locationTextArea;

    @javafx.fxml.FXML
    public void initialize() {

        employmentTypeCB.getItems().addAll("Full-time", "Part-time" ,"Contract");


    }

    @javafx.fxml.FXML
    public void submitJobOA(ActionEvent actionEvent) {
    }
}