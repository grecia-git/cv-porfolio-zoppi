package com.zoppi.cv.cvporfoliozoppi.controller;

import com.zoppi.cv.cvporfoliozoppi.model.experience.Experience;
import com.zoppi.cv.cvporfoliozoppi.model.experience.ExperienceToCreate;
import com.zoppi.cv.cvporfoliozoppi.model.experience.ExperienceToUpdate;
import com.zoppi.cv.cvporfoliozoppi.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://zoppi-cv.web.app")
@RequestMapping("/experience")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Experience createExperience(@RequestBody @Validated ExperienceToCreate experienceToCreate) {
        return experienceService.saveExperience(experienceToCreate);
    }

    @GetMapping(path = {"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Experience getExperienceById(@PathVariable("id") Long id) {
        return experienceService.getExperienceById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Experience> getExperiences() {
        return experienceService.getAllExperiences();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Experience updateExperience(@RequestBody @Validated ExperienceToUpdate experienceToUpdate) {
        return experienceService.updateExperience(experienceToUpdate);
    }

    @DeleteMapping(path = {"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExperience(@PathVariable("id") Long id) {
        experienceService.deleteExperience(id);
    }

}
