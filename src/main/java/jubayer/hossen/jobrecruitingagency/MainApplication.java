package jubayer.hossen.jobrecruitingagency;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jubayer.hossen.jobrecruitingagency.BusinessDevelopmentExecutive.ModelClasses.Company;
import jubayer.hossen.jobrecruitingagency.JobSeeker.ModelClasses.Job;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("NonUsers/LoginPageView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("TalentSphere");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // initializeJobsData();
        launch();
    }

    private static void initializeJobsData() {
        System.out.println("Initializing Jobs data...");

        List<Job> jobs = createJobsList();
        saveJobsToFile(jobs);

        System.out.println("Jobs data initialization completed!");
    }

    private static List<Job> createJobsList() {
        List<Job> jobs = new ArrayList<>();

        Company techCorp = new Company("COMP001", "TechCorp Solutions", "Technology", "Large");
        Company innovateSoft = new Company("COMP002", "InnovateSoft", "Technology", "Medium");
        Company dataDyne = new Company("COMP003", "DataDyne Systems", "Technology", "Medium");
        Company codeCraft = new Company("COMP004", "CodeCraft Ltd", "Technology", "Small");
        Company nextGen = new Company("COMP005", "NextGen Technologies", "Technology", "Medium");

        Company centralMedical = new Company("COMP006", "Central Medical Center", "Healthcare", "Large");
        Company healthFirst = new Company("COMP007", "HealthFirst Clinic", "Healthcare", "Medium");
        Company regionalHospital = new Company("COMP008", "Regional Hospital Network", "Healthcare", "Large");
        Company familyCare = new Company("COMP009", "Family Care Associates", "Healthcare", "Medium");
        Company medLife = new Company("COMP010", "MedLife Healthcare", "Healthcare", "Medium");

        Company globalFinance = new Company("COMP011", "Global Finance Corp", "Finance", "Large");
        Company premierBank = new Company("COMP012", "Premier Bank", "Banking", "Large");
        Company investmentPartners = new Company("COMP013", "Investment Partners LLC", "Investment", "Medium");
        Company secureInsurance = new Company("COMP014", "Secure Insurance Group", "Insurance", "Medium");
        Company capitalAdvisors = new Company("COMP015", "Capital Advisors", "Investment", "Large");

        Company creativeMarketing = new Company("COMP016", "Creative Marketing Agency", "Marketing", "Medium");
        Company brandBoost = new Company("COMP017", "BrandBoost Solutions", "Advertising", "Large");
        Company digitalDynamics = new Company("COMP018", "Digital Dynamics", "Digital Marketing", "Medium");
        Company mediaMax = new Company("COMP019", "MediaMax Corporation", "Media", "Large");
        Company strategicComm = new Company("COMP020", "Strategic Communications", "Marketing", "Large");

        Company engineeringSolutions = new Company("COMP021", "Engineering Solutions Inc", "Engineering", "Large");
        Company buildTech = new Company("COMP022", "BuildTech Corporation", "Construction", "Medium");
        Company advancedManufacturing = new Company("COMP023", "Advanced Manufacturing", "Manufacturing", "Large");
        Company greenEnergy = new Company("COMP024", "Green Energy Systems", "Energy", "Medium");
        Company precisionEngineering = new Company("COMP025", "Precision Engineering", "Engineering", "Large");

        jobs.add(new Job("Information Technology", techCorp, LocalDate.of(2025, 8, 20), LocalDate.of(2025, 9, 10), "IT001", "Software Engineer"));
        jobs.add(new Job("Information Technology", codeCraft, LocalDate.of(2025, 8, 18), LocalDate.of(2025, 9, 5), "IT002", "Senior Java Developer"));
        jobs.add(new Job("Information Technology", techCorp, LocalDate.of(2025, 8, 19), LocalDate.of(2025, 9, 12), "IT003", "Frontend Developer"));
        jobs.add(new Job("Information Technology", nextGen, LocalDate.of(2025, 8, 17), LocalDate.of(2025, 9, 8), "IT004", "Backend Developer"));
        jobs.add(new Job("Information Technology", techCorp, LocalDate.of(2025, 8, 21), LocalDate.of(2025, 9, 15), "IT005", "Full Stack Developer"));
        jobs.add(new Job("Information Technology", techCorp, LocalDate.of(2025, 8, 22), LocalDate.of(2025, 9, 20), "IT006", "DevOps Engineer"));
        jobs.add(new Job("Information Technology", innovateSoft, LocalDate.of(2025, 8, 16), LocalDate.of(2025, 9, 7), "IT007", "Data Scientist"));
        jobs.add(new Job("Information Technology", techCorp, LocalDate.of(2025, 8, 23), LocalDate.of(2025, 9, 18), "IT008", "System Administrator"));
        jobs.add(new Job("Information Technology", techCorp, LocalDate.of(2025, 8, 24), LocalDate.of(2025, 9, 25), "IT009", "Cybersecurity Analyst"));
        jobs.add(new Job("Information Technology", techCorp, LocalDate.of(2025, 8, 25), LocalDate.of(2025, 9, 30), "IT010", "Mobile App Developer"));
        jobs.add(new Job("Information Technology", techCorp, LocalDate.of(2025, 8, 26), LocalDate.of(2025, 9, 22), "IT011", "UI/UX Designer"));
        jobs.add(new Job("Information Technology", techCorp, LocalDate.of(2025, 8, 27), LocalDate.of(2025, 9, 28), "IT012", "Database Administrator"));
        jobs.add(new Job("Information Technology", nextGen, LocalDate.of(2025, 8, 28), LocalDate.of(2025, 10, 1), "IT013", "Cloud Architect"));
        jobs.add(new Job("Information Technology", techCorp, LocalDate.of(2025, 8, 29), LocalDate.of(2025, 9, 26), "IT014", "Software Tester"));
        jobs.add(new Job("Information Technology", dataDyne, LocalDate.of(2025, 8, 30), LocalDate.of(2025, 9, 24), "IT015", "Technical Lead"));
        jobs.add(new Job("Information Technology", techCorp, LocalDate.of(2025, 8, 31), LocalDate.of(2025, 10, 2), "IT016", "Python Developer"));
        jobs.add(new Job("Information Technology", dataDyne, LocalDate.of(2025, 9, 1), LocalDate.of(2025, 9, 29), "IT017", "React Developer"));
        jobs.add(new Job("Information Technology", techCorp, LocalDate.of(2025, 9, 2), LocalDate.of(2025, 10, 5), "IT018", "Machine Learning Engineer"));
        jobs.add(new Job("Information Technology", nextGen, LocalDate.of(2025, 9, 3), LocalDate.of(2025, 10, 8), "IT019", "IT Support Specialist"));
        jobs.add(new Job("Information Technology", techCorp, LocalDate.of(2025, 9, 4), LocalDate.of(2025, 10, 10), "IT020", "Network Administrator"));

        jobs.add(new Job("Healthcare", familyCare, LocalDate.of(2025, 8, 20), LocalDate.of(2025, 9, 15), "HC001", "Registered Nurse"));
        jobs.add(new Job("Healthcare", centralMedical, LocalDate.of(2025, 8, 18), LocalDate.of(2025, 9, 12), "HC002", "Medical Doctor"));
        jobs.add(new Job("Healthcare", centralMedical, LocalDate.of(2025, 8, 22), LocalDate.of(2025, 9, 18), "HC003", "Pharmacist"));
        jobs.add(new Job("Healthcare", centralMedical, LocalDate.of(2025, 8, 24), LocalDate.of(2025, 9, 20), "HC004", "Physical Therapist"));
        jobs.add(new Job("Healthcare", medLife, LocalDate.of(2025, 8, 16), LocalDate.of(2025, 9, 8), "HC005", "Medical Assistant"));
        jobs.add(new Job("Healthcare", centralMedical, LocalDate.of(2025, 8, 26), LocalDate.of(2025, 9, 25), "HC006", "Laboratory Technician"));
        jobs.add(new Job("Healthcare", centralMedical, LocalDate.of(2025, 8, 28), LocalDate.of(2025, 9, 28), "HC007", "Radiologic Technologist"));
        jobs.add(new Job("Healthcare", regionalHospital, LocalDate.of(2025, 8, 30), LocalDate.of(2025, 10, 1), "HC008", "Nurse Practitioner"));
        jobs.add(new Job("Healthcare", centralMedical, LocalDate.of(2025, 9, 1), LocalDate.of(2025, 9, 22), "HC009", "Physician Assistant"));
        jobs.add(new Job("Healthcare", centralMedical, LocalDate.of(2025, 9, 2), LocalDate.of(2025, 10, 5), "HC010", "Medical Receptionist"));
        jobs.add(new Job("Healthcare", centralMedical, LocalDate.of(2025, 9, 3), LocalDate.of(2025, 10, 8), "HC011", "Healthcare Administrator"));
        jobs.add(new Job("Healthcare", centralMedical, LocalDate.of(2025, 9, 4), LocalDate.of(2025, 10, 10), "HC012", "Dental Hygienist"));
        jobs.add(new Job("Healthcare", healthFirst, LocalDate.of(2025, 8, 19), LocalDate.of(2025, 9, 14), "HC013", "Medical Coder"));
        jobs.add(new Job("Healthcare", healthFirst, LocalDate.of(2025, 8, 21), LocalDate.of(2025, 9, 16), "HC014", "Clinical Research Coordinator"));
        jobs.add(new Job("Healthcare", centralMedical, LocalDate.of(2025, 8, 23), LocalDate.of(2025, 9, 19), "HC015", "Respiratory Therapist"));
        jobs.add(new Job("Healthcare", centralMedical, LocalDate.of(2025, 8, 25), LocalDate.of(2025, 9, 24), "HC016", "Surgeon"));
        jobs.add(new Job("Healthcare", centralMedical, LocalDate.of(2025, 8, 27), LocalDate.of(2025, 9, 26), "HC017", "Pediatrician"));
        jobs.add(new Job("Healthcare", centralMedical, LocalDate.of(2025, 8, 29), LocalDate.of(2025, 9, 30), "HC018", "Cardiologist"));
        jobs.add(new Job("Healthcare", centralMedical, LocalDate.of(2025, 8, 31), LocalDate.of(2025, 10, 2), "HC019", "Emergency Medicine Physician"));
        jobs.add(new Job("Healthcare", centralMedical, LocalDate.of(2025, 9, 5), LocalDate.of(2025, 10, 12), "HC020", "Psychiatrist"));

        jobs.add(new Job("Finance", premierBank, LocalDate.of(2025, 8, 20), LocalDate.of(2025, 9, 18), "FN001", "Financial Analyst"));
        jobs.add(new Job("Finance", investmentPartners, LocalDate.of(2025, 8, 18), LocalDate.of(2025, 9, 15), "FN002", "Investment Banker"));
        jobs.add(new Job("Finance", capitalAdvisors, LocalDate.of(2025, 8, 22), LocalDate.of(2025, 9, 20), "FN003", "Accountant"));
        jobs.add(new Job("Finance", secureInsurance, LocalDate.of(2025, 8, 16), LocalDate.of(2025, 9, 12), "FN004", "Financial Advisor"));
        jobs.add(new Job("Finance", premierBank, LocalDate.of(2025, 8, 24), LocalDate.of(2025, 9, 22), "FN005", "Credit Analyst"));
        jobs.add(new Job("Finance", premierBank, LocalDate.of(2025, 8, 26), LocalDate.of(2025, 9, 25), "FN006", "Risk Manager"));
        jobs.add(new Job("Finance", investmentPartners, LocalDate.of(2025, 8, 28), LocalDate.of(2025, 9, 28), "FN007", "Portfolio Manager"));
        jobs.add(new Job("Finance", premierBank, LocalDate.of(2025, 8, 30), LocalDate.of(2025, 10, 1), "FN008", "Tax Specialist"));
        jobs.add(new Job("Finance", secureInsurance, LocalDate.of(2025, 9, 1), LocalDate.of(2025, 9, 30), "FN009", "Auditor"));
        jobs.add(new Job("Finance", premierBank, LocalDate.of(2025, 9, 2), LocalDate.of(2025, 10, 5), "FN010", "Budget Analyst"));
        jobs.add(new Job("Finance", secureInsurance, LocalDate.of(2025, 9, 3), LocalDate.of(2025, 10, 8), "FN011", "Insurance Agent"));
        jobs.add(new Job("Finance", premierBank, LocalDate.of(2025, 9, 4), LocalDate.of(2025, 10, 10), "FN012", "Loan Officer"));
        jobs.add(new Job("Finance", premierBank, LocalDate.of(2025, 8, 19), LocalDate.of(2025, 9, 14), "FN013", "Treasury Analyst"));
        jobs.add(new Job("Finance", globalFinance, LocalDate.of(2025, 8, 21), LocalDate.of(2025, 9, 16), "FN014", "Compliance Officer"));
        jobs.add(new Job("Finance", premierBank, LocalDate.of(2025, 8, 23), LocalDate.of(2025, 9, 19), "FN015", "Financial Planner"));
        jobs.add(new Job("Finance", premierBank, LocalDate.of(2025, 8, 25), LocalDate.of(2025, 9, 24), "FN016", "Banking Associate"));
        jobs.add(new Job("Finance", investmentPartners, LocalDate.of(2025, 8, 27), LocalDate.of(2025, 9, 26), "FN017", "Wealth Manager"));
        jobs.add(new Job("Finance", globalFinance, LocalDate.of(2025, 8, 29), LocalDate.of(2025, 9, 29), "FN018", "Corporate Finance Manager"));
        jobs.add(new Job("Finance", investmentPartners, LocalDate.of(2025, 8, 31), LocalDate.of(2025, 10, 2), "FN019", "Quantitative Analyst"));
        jobs.add(new Job("Finance", premierBank, LocalDate.of(2025, 9, 5), LocalDate.of(2025, 10, 12), "FN020", "Financial Controller"));

        jobs.add(new Job("Marketing", digitalDynamics, LocalDate.of(2025, 8, 20), LocalDate.of(2025, 9, 18), "MK001", "Digital Marketing Manager"));
        jobs.add(new Job("Marketing", brandBoost, LocalDate.of(2025, 8, 18), LocalDate.of(2025, 9, 15), "MK002", "Social Media Specialist"));
        jobs.add(new Job("Marketing", digitalDynamics, LocalDate.of(2025, 8, 22), LocalDate.of(2025, 9, 20), "MK003", "Content Creator"));
        jobs.add(new Job("Marketing", mediaMax, LocalDate.of(2025, 8, 16), LocalDate.of(2025, 9, 12), "MK004", "SEO Specialist"));
        jobs.add(new Job("Marketing", strategicComm, LocalDate.of(2025, 8, 24), LocalDate.of(2025, 9, 22), "MK005", "Brand Manager"));
        jobs.add(new Job("Marketing", brandBoost, LocalDate.of(2025, 8, 26), LocalDate.of(2025, 9, 25), "MK006", "Marketing Coordinator"));
        jobs.add(new Job("Marketing", strategicComm, LocalDate.of(2025, 8, 28), LocalDate.of(2025, 9, 28), "MK007", "Copywriter"));
        jobs.add(new Job("Marketing", creativeMarketing, LocalDate.of(2025, 8, 30), LocalDate.of(2025, 10, 1), "MK008", "Graphic Designer"));
        jobs.add(new Job("Marketing", digitalDynamics, LocalDate.of(2025, 9, 1), LocalDate.of(2025, 9, 30), "MK009", "Marketing Analyst"));
        jobs.add(new Job("Marketing", digitalDynamics, LocalDate.of(2025, 9, 2), LocalDate.of(2025, 10, 5), "MK010", "Event Coordinator"));
        jobs.add(new Job("Marketing", strategicComm, LocalDate.of(2025, 9, 3), LocalDate.of(2025, 10, 8), "MK011", "Public Relations Specialist"));
        jobs.add(new Job("Marketing", digitalDynamics, LocalDate.of(2025, 9, 4), LocalDate.of(2025, 10, 10), "MK012", "Email Marketing Specialist"));
        jobs.add(new Job("Marketing", strategicComm, LocalDate.of(2025, 8, 19), LocalDate.of(2025, 9, 14), "MK013", "Video Editor"));
        jobs.add(new Job("Marketing", brandBoost, LocalDate.of(2025, 8, 21), LocalDate.of(2025, 9, 16), "MK014", "Product Marketing Manager"));
        jobs.add(new Job("Marketing", digitalDynamics, LocalDate.of(2025, 8, 23), LocalDate.of(2025, 9, 19), "MK015", "Sales Representative"));
        jobs.add(new Job("Marketing", strategicComm, LocalDate.of(2025, 8, 25), LocalDate.of(2025, 9, 24), "MK016", "Marketing Director"));
        jobs.add(new Job("Marketing", brandBoost, LocalDate.of(2025, 8, 27), LocalDate.of(2025, 9, 26), "MK017", "Advertising Executive"));
        jobs.add(new Job("Marketing", strategicComm, LocalDate.of(2025, 8, 29), LocalDate.of(2025, 9, 29), "MK018", "Market Research Analyst"));
        jobs.add(new Job("Marketing", digitalDynamics, LocalDate.of(2025, 8, 31), LocalDate.of(2025, 10, 2), "MK019", "Influencer Relations Manager"));
        jobs.add(new Job("Marketing", digitalDynamics, LocalDate.of(2025, 9, 5), LocalDate.of(2025, 10, 12), "MK020", "Creative Director"));

        jobs.add(new Job("Engineering", advancedManufacturing, LocalDate.of(2025, 8, 20), LocalDate.of(2025, 9, 18), "EN001", "Mechanical Engineer"));
        jobs.add(new Job("Engineering", precisionEngineering, LocalDate.of(2025, 8, 18), LocalDate.of(2025, 9, 15), "EN002", "Civil Engineer"));
        jobs.add(new Job("Engineering", greenEnergy, LocalDate.of(2025, 8, 22), LocalDate.of(2025, 9, 20), "EN003", "Electrical Engineer"));
        jobs.add(new Job("Engineering", advancedManufacturing, LocalDate.of(2025, 8, 16), LocalDate.of(2025, 9, 12), "EN004", "Chemical Engineer"));
        jobs.add(new Job("Engineering", precisionEngineering, LocalDate.of(2025, 8, 24), LocalDate.of(2025, 9, 22), "EN005", "Aerospace Engineer"));
        jobs.add(new Job("Engineering", greenEnergy, LocalDate.of(2025, 8, 26), LocalDate.of(2025, 9, 25), "EN006", "Environmental Engineer"));
        jobs.add(new Job("Engineering", precisionEngineering, LocalDate.of(2025, 8, 28), LocalDate.of(2025, 9, 28), "EN007", "Structural Engineer"));
        jobs.add(new Job("Engineering", advancedManufacturing, LocalDate.of(2025, 8, 30), LocalDate.of(2025, 10, 1), "EN008", "Industrial Engineer"));
        jobs.add(new Job("Engineering", greenEnergy, LocalDate.of(2025, 9, 1), LocalDate.of(2025, 9, 30), "EN009", "Biomedical Engineer"));
        jobs.add(new Job("Engineering", engineeringSolutions, LocalDate.of(2025, 9, 2), LocalDate.of(2025, 10, 5), "EN010", "Software Engineer"));
        jobs.add(new Job("Engineering", advancedManufacturing, LocalDate.of(2025, 9, 3), LocalDate.of(2025, 10, 8), "EN011", "Manufacturing Engineer"));
        jobs.add(new Job("Engineering", buildTech, LocalDate.of(2025, 9, 4), LocalDate.of(2025, 10, 10), "EN012", "Quality Assurance Engineer"));
        jobs.add(new Job("Engineering", advancedManufacturing, LocalDate.of(2025, 8, 19), LocalDate.of(2025, 9, 14), "EN013", "Project Engineer"));
        jobs.add(new Job("Engineering", precisionEngineering, LocalDate.of(2025, 8, 21), LocalDate.of(2025, 9, 16), "EN014", "Design Engineer"));
        jobs.add(new Job("Engineering", advancedManufacturing, LocalDate.of(2025, 8, 23), LocalDate.of(2025, 9, 19), "EN015", "Process Engineer"));
        jobs.add(new Job("Engineering", greenEnergy, LocalDate.of(2025, 8, 25), LocalDate.of(2025, 9, 24), "EN016", "Safety Engineer"));
        jobs.add(new Job("Engineering", engineeringSolutions, LocalDate.of(2025, 8, 27), LocalDate.of(2025, 9, 26), "EN017", "Systems Engineer"));
        jobs.add(new Job("Engineering", precisionEngineering, LocalDate.of(2025, 8, 29), LocalDate.of(2025, 9, 29), "EN018", "Robotics Engineer"));
        jobs.add(new Job("Engineering", advancedManufacturing, LocalDate.of(2025, 8, 31), LocalDate.of(2025, 10, 2), "EN019", "Materials Engineer"));
        jobs.add(new Job("Engineering", greenEnergy, LocalDate.of(2025, 9, 5), LocalDate.of(2025, 10, 12), "EN020", "Nuclear Engineer"));

        return jobs;
    }

    private static void saveJobsToFile(List<Job> jobs) {
        File file = new File("src\\main\\Files\\Jobs.bin");

        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            for (Job job : jobs) {
                oos.writeObject(job);
            }

            System.out.println("Successfully saved " + jobs.size() + " jobs to Jobs.bin");

        } catch (IOException e) {
            System.out.println("Error saving jobs to file!");
        }
    }

}