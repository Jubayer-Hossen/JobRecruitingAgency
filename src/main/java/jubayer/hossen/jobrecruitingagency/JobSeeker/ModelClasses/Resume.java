package jubayer.hossen.jobrecruitingagency.JobSeeker.ModelClasses;

import java.time.LocalDate;

public class Resume {
    private String resumeID;
    private String filePath;
    private LocalDate uploadedAt;

    public Resume(String resumeID, String filePath, LocalDate uploadedAt) {
        this.resumeID = resumeID;
        this.filePath = filePath;
        this.uploadedAt = uploadedAt;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getResumeID() {
        return resumeID;
    }

    public void setResumeID(String resumeID) {
        this.resumeID = resumeID;
    }

    public LocalDate getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDate uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}
