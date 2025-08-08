package jubayer.hossen.jobrecruitingagency.HRManager;



import java.time.LocalDate;

public class Application {
    private int id;
    private String candidateName;
    private String candidateEmail;
    private String jobTitle;
    private String status; // Submitted, Under Review, Shortlisted, Rejected
    private String resumePath;
    private LocalDate applicationDate;

    // Constructor
    public Application(int id, String candidateName, String candidateEmail,
                       String jobTitle, LocalDate applicationDate) {
        this.id = id;
        this.candidateName = candidateName;
        this.candidateEmail = candidateEmail;
        this.jobTitle = jobTitle;
        this.applicationDate = applicationDate;
        this.status = "Submitted";
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getCandidateName() { return candidateName; }
    public String getCandidateEmail() { return candidateEmail; }
    public String getJobTitle() { return jobTitle; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getResumePath() { return resumePath; }
    public void setResumePath(String resumePath) { this.resumePath = resumePath; }
    public LocalDate getApplicationDate() { return applicationDate; }
}