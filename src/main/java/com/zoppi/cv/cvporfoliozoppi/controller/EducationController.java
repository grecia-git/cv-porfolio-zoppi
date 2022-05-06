package com.zoppi.cv.cvporfoliozoppi.controller;

import com.zoppi.cv.cvporfoliozoppi.model.education.Education;
import com.zoppi.cv.cvporfoliozoppi.model.education.EducationToCreate;
import com.zoppi.cv.cvporfoliozoppi.model.education.EducationToUpdate;
import com.zoppi.cv.cvporfoliozoppi.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/education")
public class EducationController {

    @Autowired
    private EducationService educationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Education createEducation(@RequestBody @Validated EducationToCreate educationToCreate) {
        return educationService.saveEducation(educationToCreate);
    }

    @GetMapping(path = {"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Education getEducationById(@PathVariable("id") Long id) {
        return educationService.getEducationById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Education> getEducations() {
        return educationService.getAllEducations();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Education updateEducation(@RequestBody @Validated EducationToUpdate educationToUpdate) {
        return educationService.updateEducation(educationToUpdate);
    }

    @DeleteMapping(path = {"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEducation(@PathVariable("id") Long id) {
        educationService.deleteEducation(id);
    }

}
