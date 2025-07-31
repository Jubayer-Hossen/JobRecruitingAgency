package jubayer.hossen.jobrecruitingagency.Interviewer;

import jubayer.hossen.jobrecruitingagency.User.User;

public class Interviewer extends User {
    private String interviewerID;
    private Schedule availability;

    public Interviewer(String userID, String password,
                       String name, String email,
                       Schedule availability, String interviewerID) {
        super(userID, password, name, email);
        this.availability = availability;
        this.interviewerID = interviewerID;
    }

}
