package com.zoppi.cv.cvporfoliozoppi.controller;

import com.zoppi.cv.cvporfoliozoppi.model.skill.Skill;
import com.zoppi.cv.cvporfoliozoppi.model.skill.SkillToCreate;
import com.zoppi.cv.cvporfoliozoppi.model.skill.SkillToUpdate;
import com.zoppi.cv.cvporfoliozoppi.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://zoppi-cv.web.app")
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Skill createSkill(@RequestBody @Validated SkillToCreate skillToCreate) {
        return skillService.saveSkill(skillToCreate);
    }

    @GetMapping(path = {"/{category}"})
    @ResponseStatus(HttpStatus.OK)
    public List<Skill> getAllSkillsByCategory(@PathVariable("category") String category) {
        return skillService.getAllSkillsByCategory(category);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Skill updateSkill(@RequestBody @Validated SkillToUpdate skillToUpdate) {
        return skillService.updateSkill(skillToUpdate);
    }

    @DeleteMapping(path = {"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSkill(@PathVariable("id") Long id) {
        skillService.deleteSkill(id);
    }

}
