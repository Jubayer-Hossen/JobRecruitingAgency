package jubayer.hossen.jobrecruitingagency.HRManager;

import jubayer.hossen.jobrecruitingagency.JobSeeker.ModelClasses.Job;
import jubayer.hossen.jobrecruitingagency.JobSeeker.ModelClasses.JobSeeker;

import java.io.Serializable;
import java.time.LocalDate;

public class Offer implements Serializable {
    private String offerId;
    private JobSeeker candidate;
    private Job job;
    private double salary;
    private LocalDate startDate;
    private String status;

    public Offer(JobSeeker candidate, Job job, String offerId, double salary, LocalDate startDate, String status) {
        this.candidate = candidate;
        this.job = job;
        this.offerId = offerId;
        this.salary = salary;
        this.startDate = startDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "candidate=" + candidate +
                ", offerId='" + offerId + '\'' +
                ", job=" + job +
                ", salary=" + salary +
                ", startDate=" + startDate +
                ", status='" + status + '\'' +
                '}';
    }

    public JobSeeker getCandidate() {
        return candidate;
    }

    public void setCandidate(JobSeeker candidate) {
        this.candidate = candidate;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
