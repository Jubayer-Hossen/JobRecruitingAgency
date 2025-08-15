package jubayer.hossen.jobrecruitingagency.JobSeeker.ModelClasses;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import jubayer.hossen.jobrecruitingagency.User.User;

public class JobSeeker extends User implements Serializable {
    private String jobSeekerID;
    private LocalDate creationDate;
    private String phone;
    private String skills;
    private String summary;

    public JobSeeker(String userID, String password, String name,
                     String email, String jobSeekerID, LocalDate creationDate,
                     String phone, String skills, String summary) {
        super(userID, password, name, email);
        this.jobSeekerID = super.getUserID();
        this.creationDate = creationDate;
        this.phone = phone;
        this.skills = skills;
        this.summary = summary;
    }

    public JobSeeker(String jobSeekerID, String password, String name, String email) {
        super(jobSeekerID, password, name, email);
        this.jobSeekerID = super.getUserID();
    }

    @Override
    public String toString() {
        return "JobSeeker{" +
                "creationDate=" + creationDate +
                ", jobSeekerID='" + jobSeekerID + '\'' +
                ", phone='" + phone + '\'' +
                ", skills='" + skills + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getJobSeekerID() {
        return jobSeekerID;
    }

    public void setJobSeekerID(String jobSeekerID) {
        this.jobSeekerID = jobSeekerID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public ArrayList<Application> viewApplications(){

        return new ArrayList<>();

    }

    public void signOut(){
        super.logout();
    }
}
