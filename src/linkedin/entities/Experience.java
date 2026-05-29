package linkedin.entities;

import java.time.LocalDate;

public class Experience {
    private final String title;
    private final String companyName;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Experience(String title, String company, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.companyName = company;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
