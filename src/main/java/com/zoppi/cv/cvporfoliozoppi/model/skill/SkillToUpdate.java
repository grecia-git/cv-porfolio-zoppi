
package com.zoppi.cv.cvporfoliozoppi.model.skill;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SkillToUpdate {
    @NotNull
    private Long id;
    @NotBlank
    @Size(min = 1, max = 100)
    private String category;
    @NotBlank
    @Size(min = 1, max = 100)
    private String type;
    @NotBlank
    @Size(min = 1, max = 100)
    private String level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "SkillToUpdate{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
