package com.zoppi.cv.cvporfoliozoppi.model.experience;

import java.time.LocalDate;

public class Experience {

    private Long id;
    private String rol;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long personId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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
        return "Experience{" +
                "id=" + id +
                ", rol='" + rol + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", personId=" + personId +
                '}';
    }
}
