module jubayer.hossen.jobrecruitingagency {
    requires javafx.controls;
    requires javafx.fxml;


    opens jubayer.hossen.jobrecruitingagency to javafx.fxml;
    opens jubayer.hossen.jobrecruitingagency.AppAdmin to javafx.fxml;
    opens jubayer.hossen.jobrecruitingagency.ApplicationReviewer to javafx.fxml;
    opens jubayer.hossen.jobrecruitingagency.BusinessDevelopmentExecutive to javafx.fxml;
    opens jubayer.hossen.jobrecruitingagency.CompanyRepresentative to javafx.fxml;
    opens jubayer.hossen.jobrecruitingagency.HRManager to javafx.fxml;
    opens jubayer.hossen.jobrecruitingagency.Interviewer to javafx.fxml;
    opens jubayer.hossen.jobrecruitingagency.JobSeeker to javafx.fxml;
    opens jubayer.hossen.jobrecruitingagency.NonUsers to javafx.fxml;
    opens jubayer.hossen.jobrecruitingagency.OfferApprovalOfficer to javafx.fxml;

    exports jubayer.hossen.jobrecruitingagency;
    exports jubayer.hossen.jobrecruitingagency.AppAdmin;
    exports jubayer.hossen.jobrecruitingagency.ApplicationReviewer;
    exports jubayer.hossen.jobrecruitingagency.BusinessDevelopmentExecutive;
    exports jubayer.hossen.jobrecruitingagency.CompanyRepresentative;
    exports jubayer.hossen.jobrecruitingagency.HRManager;
    exports jubayer.hossen.jobrecruitingagency.Interviewer;
    exports jubayer.hossen.jobrecruitingagency.JobSeeker;
    exports jubayer.hossen.jobrecruitingagency.NonUsers;
    exports jubayer.hossen.jobrecruitingagency.OfferApprovalOfficer;
}