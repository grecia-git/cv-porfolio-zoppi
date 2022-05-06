package com.zoppi.cv.cvporfoliozoppi.model.person;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PersonToCreate {

    @Size(max = 200)
    private String profession;
    @NotBlank
    @Size(max = 20)
    private String name;
    @NotBlank
    @Size(max = 20)
    private String surname;
    @Size(max = 800)
    private String description;

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PersonToCreate{" +
                "profession='" + profession + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
