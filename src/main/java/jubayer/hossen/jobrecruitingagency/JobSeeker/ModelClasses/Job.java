package jubayer.hossen.jobrecruitingagency.JobSeeker.ModelClasses;

import jubayer.hossen.jobrecruitingagency.BusinessDevelopmentExecutive.ModelClasses.Company;

import java.io.Serializable;
import java.time.LocalDate;

public class Job implements Serializable {
    private String jobID;
    private String jobTitle;
    private Company company;
    private String category;
    private LocalDate createdAt;
    private LocalDate deadline;

    public Job(String category, Company company, LocalDate createdAt, LocalDate deadline, String jobID, String jobTitle) {
        this.category = category;
        this.company = company;
        this.createdAt = createdAt;
        this.deadline = deadline;
        this.jobID = jobID;
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Job{" +
                "category='" + category + '\'' +
                ", jobID='" + jobID + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", company=" + company +
                ", createdAt=" + createdAt +
                ", deadline=" + deadline +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getJobID() {
        return jobID;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

}
