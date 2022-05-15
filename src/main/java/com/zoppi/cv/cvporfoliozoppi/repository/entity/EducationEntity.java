package com.zoppi.cv.cvporfoliozoppi.repository.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Education")
public class EducationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 100)
    private String institute;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false, updatable = false)
    private PersonEntity person;

    public EducationEntity() {
    }
    public EducationEntity(Long id, String title, String institute,LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.title = title;
        this.institute= institute;
        this.startDate = startDate;
        this.endDate = endDate;
    }



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

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "EducationEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", institute='" + institute + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", person=" + person +
                '}';
    }
}
