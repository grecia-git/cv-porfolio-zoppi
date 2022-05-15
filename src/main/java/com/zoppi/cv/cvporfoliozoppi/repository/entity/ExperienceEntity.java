package com.zoppi.cv.cvporfoliozoppi.repository.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Experience")
public class ExperienceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    private String rol;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false, updatable = false)
    private PersonEntity person;

    public ExperienceEntity() {
    }

    public ExperienceEntity(Long id, String rol, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.rol = rol;
        this.startDate = startDate;
        this.endDate = endDate;
    }

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

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "ExperienceEntity{" +
                "id=" + id +
                ", rol='" + rol + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", person=" + person +
                '}';
    }
}
