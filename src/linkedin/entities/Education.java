package linkedin.entities;

public class Education {
    private String school;
    private String degree;
    private final int startYear;
    private final int endYear;

    public Education(String school, String degree, int startYear, int endYear) {
        this.school = school;
        this.degree = degree;
        this.startYear = startYear;
        this.endYear = endYear;
    }
}
