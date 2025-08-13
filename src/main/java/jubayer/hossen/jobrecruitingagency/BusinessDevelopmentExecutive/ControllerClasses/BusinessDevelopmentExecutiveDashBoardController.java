package jubayer.hossen.jobrecruitingagency.BusinessDevelopmentExecutive.ControllerClasses;

import jubayer.hossen.jobrecruitingagency.BusinessDevelopmentExecutive.ModelClasses.BusinessDevelopmentExecutive;

public class BusinessDevelopmentExecutiveDashBoardController {
    private BusinessDevelopmentExecutive currentBusinessDevelopmentExecutive;
    @javafx.fxml.FXML
    public void initialize() {
    }

    public void setCurrentBusinessDevelopmentExecutive(BusinessDevelopmentExecutive businessDevelopmentExecutive) {
        this.currentBusinessDevelopmentExecutive = businessDevelopmentExecutive;
    }

    public BusinessDevelopmentExecutive getCurrentBusinessDevelopmentExecutive() {
        return this.currentBusinessDevelopmentExecutive;
    }

}