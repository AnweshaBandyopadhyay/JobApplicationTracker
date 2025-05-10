package model;

import java.time.LocalDate;

public class JobApplication {
    private String company;
    private String title;
    private LocalDate date;
    private String status;

    public JobApplication(String company, String title, LocalDate date, String status) {
        this.company = company;
        this.title = title;
        this.date = date;
        this.status = status;
    }

    public String getCompany() { return company; }
    public String getTitle() { return title; }
    public LocalDate getDate() { return date; }
    public String getStatus() { return status; }

    public void setCompany(String company) { this.company = company; }
    public void setTitle(String title) { this.title = title; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setStatus(String status) { this.status = status; }
}
