package com.zoppi.cv.cvporfoliozoppi.model.education;

import java.time.LocalDate;

public class Education {

    private Long id;
    private String title;
    private String institute;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long personId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", institute='" + institute + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", personId=" + personId +
                '}';
    }
}
