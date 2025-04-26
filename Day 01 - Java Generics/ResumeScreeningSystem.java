package Day1.JavaGenerics;
import java.util.*;

abstract class JobRole {
    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public abstract void evaluateResume();
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName) {
        super(candidateName);
    }

    public void evaluateResume() {
        System.out.println(getCandidateName() + " applying for Software Engineer: Java, Spring, GitHub check");
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName) {
        super(candidateName);
    }

    public void evaluateResume() {
        System.out.println(getCandidateName() + " applying for Data Scientist: Python, ML models, Kaggle profile check");
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName) {
        super(candidateName);
    }

    public void evaluateResume() {
        System.out.println(getCandidateName() + " applying for Product Manager: Roadmaps, Strategy, Communication review");
    }
}

class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public void processResume() {
        jobRole.evaluateResume();
    }

    public T getJobRole() {
        return jobRole;
    }
}

class ScreeningPipeline {
    public static void screenAll(List<? extends JobRole> resumes) {
        for (JobRole role : resumes) {
            role.evaluateResume();
        }
    }

    public static <T extends JobRole> void screenOne(Resume<T> resume) {
        resume.processResume();
    }
}
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Alice"));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Bob"));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Charlie"));

        ScreeningPipeline.screenOne(seResume);
        ScreeningPipeline.screenOne(dsResume);
        ScreeningPipeline.screenOne(pmResume);

        List<JobRole> pipeline = Arrays.asList(
                new SoftwareEngineer("Dana"),
                new DataScientist("Eli"),
                new ProductManager("Fay")
        );

        ScreeningPipeline.screenAll(pipeline);
    }
}
