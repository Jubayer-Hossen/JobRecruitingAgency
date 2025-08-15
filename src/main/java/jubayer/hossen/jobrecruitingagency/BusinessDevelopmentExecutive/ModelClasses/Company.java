package jubayer.hossen.jobrecruitingagency.BusinessDevelopmentExecutive.ModelClasses;

import java.io.Serializable;

public class Company implements Serializable {
    private String companyId;
    private String companyName;
    private String industry;
    private String size;

    public Company(String companyId, String companyName, String industry, String size) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.industry = industry;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId='" + companyId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", industry='" + industry + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
