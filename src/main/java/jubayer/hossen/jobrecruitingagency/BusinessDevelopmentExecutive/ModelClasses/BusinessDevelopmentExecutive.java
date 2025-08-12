package jubayer.hossen.jobrecruitingagency.BusinessDevelopmentExecutive.ModelClasses;

import jubayer.hossen.jobrecruitingagency.User.User;

public class BusinessDevelopmentExecutive extends User {
    private String bdeId;

    public BusinessDevelopmentExecutive(String name, String email, String password, String bdeId) {
        super(name, email, password, bdeId);
    
    }

}
