package linkedin.entities;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    private String summary;
    private final List<Education> educations = new ArrayList<>();
    private final List<Experience> experiences = new ArrayList<>();

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Education> getEducations() {
        return this.educations;
    }

    public List<Experience> getExperiences() {
        return this.experiences;
    }

    public void addEducation(Education education) {
        this.educations.add(education);
    }

    public void addExperience(Experience experience) {
        this.experiences.add(experience);
    }

    public void display() {
        System.out.println("  Summary: " + (summary != null ? summary : "N/A"));
        System.out.println("  Experience:");
        if (experiences.isEmpty())
            System.out.println("    - None");
        else
            experiences.forEach(exp -> System.out.println("    - " + exp));

        System.out.println("  Education:");
        if (educations.isEmpty())
            System.out.println("    - None");
        else
            educations.forEach(edu -> System.out.println("    - " + edu));
    }
}
