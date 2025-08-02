package jubayer.hossen.jobrecruitingagency.Interviewer;



import java.time.LocalDateTime;

public class Interview {
    private int interviewId;
    private int candidateId;
    private String candidateName;
    private int interviewerId;
    private String interviewerName;
    private int jobId;
    private String jobTitle;
    private LocalDateTime interviewTime;
    private String interviewType;
    private String status; // Scheduled, Completed, Cancelled, Rescheduled
    private String feedback;
    private double technicalScore;
    private double communicationScore;
    private double culturalFitScore;
    private String recommendation; // Shortlisted, Rejected, On Hold

    // Constructors
    public Interview() {}

    public Interview(int interviewId, int candidateId, String candidateName, int interviewerId,
                     String interviewerName, int jobId, String jobTitle, LocalDateTime interviewTime,
                     String interviewType, String status) {
        this.interviewId = interviewId;
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.interviewerId = interviewerId;
        this.interviewerName = interviewerName;
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.interviewTime = interviewTime;
        this.interviewType = interviewType;
        this.status = status;
    }

    // Getters and Setters
    public int getInterviewId() { return interviewId; }
    public void setInterviewId(int interviewId) { this.interviewId = interviewId; }

    public int getCandidateId() { return candidateId; }
    public void setCandidateId(int candidateId) { this.candidateId = candidateId; }

    public String getCandidateName() { return candidateName; }
    public void setCandidateName(String candidateName) { this.candidateName = candidateName; }

    public int getInterviewerId() { return interviewerId; }
    public void setInterviewerId(int interviewerId) { this.interviewerId = interviewerId; }

    public String getInterviewerName() { return interviewerName; }
    public void setInterviewerName(String interviewerName) { this.interviewerName = interviewerName; }

    public int getJobId() { return jobId; }
    public void setJobId(int jobId) { this.jobId = jobId; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public LocalDateTime getInterviewTime() { return interviewTime; }
    public void setInterviewTime(LocalDateTime interviewTime) { this.interviewTime = interviewTime; }

    public String getInterviewType() { return interviewType; }
    public void setInterviewType(String interviewType) { this.interviewType = interviewType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

    public double getTechnicalScore() { return technicalScore; }
    public void setTechnicalScore(double technicalScore) { this.technicalScore = technicalScore; }

    public double getCommunicationScore() { return communicationScore; }
    public void setCommunicationScore(double communicationScore) { this.communicationScore = communicationScore; }

    public double getCulturalFitScore() { return culturalFitScore; }
    public void setCulturalFitScore(double culturalFitScore) { this.culturalFitScore = culturalFitScore; }

    public String getRecommendation() { return recommendation; }
    public void setRecommendation(String recommendation) { this.recommendation = recommendation; }

    @Override
    public String toString() {
        return candidateName + " - " + jobTitle + " (" + interviewTime + ")";
    }
}