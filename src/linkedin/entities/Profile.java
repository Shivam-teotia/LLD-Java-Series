package linkedin.entities;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    private String summary;
    private final List<Experience> experiences = new ArrayList<>();
    private final List<Education> educations = new ArrayList<>();

    public void setSummary(String summary){
        this.summary = summary;
    }

    public void addEducation(Education education){
        this.educations.add(education);
    }

    public void addExperience(Experience experience){
        this.experiences.add(experience);
    }

    public String getSummary() {
        return summary;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public List<Education> getEducations() {
        return educations;
    }
}
