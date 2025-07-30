package jubayer.hossen.jobrecruitingagency.JobSeeker;

import jubayer.hossen.jobrecruitingagency.User.User;

import java.time.LocalDate;

public class JobSeeker extends User {
    private final String jobSeekerID;
    private LocalDate creationDate;
    private String phone;
    private String skills;
    private String summary;
    private Resume resume;

    public JobSeeker(String userID, String password, String name,
                     String email, String jobSeekerID, LocalDate creationDate,
                     String phone, Resume resume, String skills, String summary) {
        super(userID, password, name, email);
        this.jobSeekerID = super.getUserID();
        this.creationDate = creationDate;
        this.phone = phone;
        this.resume = resume;
        this.skills = skills;
        this.summary = summary;
    }
}
