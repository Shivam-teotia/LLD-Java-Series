package linkedin.entities;

import java.time.LocalDate;

public class Education {
    private String school;
    private String degree;
    private LocalDate startDate;
    private LocalDate endDate;

    public Education(String school, LocalDate endDate, LocalDate startDate, String degree) {
        this.school = school;
        this.endDate = endDate;
        this.startDate = startDate;
        this.degree = degree;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
