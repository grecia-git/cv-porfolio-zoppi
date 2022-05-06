package com.zoppi.cv.cvporfoliozoppi.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "Skill")
public class SkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    private String category;

    @Column(nullable = false, length = 100)
    private String type;

    @Column(nullable = false, length = 100)
    private String level;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    private PersonEntity person;


    public SkillEntity() {
    }

    public SkillEntity(Long id, String category, String type, String level) {
        this.id = id;
        this.category = category;
        this.type = type;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public String getLevel() {
        return level;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "SkillEntity{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", person=" + person +
                '}';
    }
}
