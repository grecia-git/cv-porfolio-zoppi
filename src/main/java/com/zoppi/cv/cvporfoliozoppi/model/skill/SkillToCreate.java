package com.zoppi.cv.cvporfoliozoppi.model.skill;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class SkillToCreate {
    @NotBlank
    @Size(min = 1, max = 100)
    private String category;
    @NotBlank
    @Size(min = 1, max = 100)
    private String type;
    @NotBlank
    @Size(min = 1, max = 100)
    private String level;
    @NotNull
    private Long personId;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "SkillToCreate{" +
                "category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", personId=" + personId +
                '}';
    }
}
