package jubayer.hossen.jobrecruitingagency.JobSeeker.ModelClasses;

import jubayer.hossen.jobrecruitingagency.BusinessDevelopmentExecutive.ModelClasses.Company;

import java.io.Serializable;

public class Application implements Serializable {
    private String applicationID;
    private JobSeeker jobSeeker;
    private Company company;
    private Job job;
    private String status;
    private String applicationDate;

    public Application(String applicationDate, String applicationID, Company company,
                       Job job, JobSeeker jobSeeker, String status) {
        this.applicationDate = applicationDate;
        this.applicationID = applicationID;
        this.company = company;
        this.job = job;
        this.jobSeeker = jobSeeker;
        this.status = status;
    }

    public boolean submit(){
        //
        return true;
    }

    public String viewStatus(){
        return status;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
