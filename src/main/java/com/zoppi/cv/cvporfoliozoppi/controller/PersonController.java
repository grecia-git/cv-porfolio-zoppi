package com.zoppi.cv.cvporfoliozoppi.controller;

import com.zoppi.cv.cvporfoliozoppi.model.person.Person;
import com.zoppi.cv.cvporfoliozoppi.model.person.PersonToCreate;
import com.zoppi.cv.cvporfoliozoppi.model.person.PersonToUpdate;
import com.zoppi.cv.cvporfoliozoppi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://zoppi-cv.web.app")
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@RequestBody @Validated PersonToCreate personToCreate) {
        return personService.savePerson(personToCreate);
    }

    @GetMapping(path = {"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Person getPersonById(@PathVariable("id") Long id) {
        return personService.getPersonById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getPersons() {
        return personService.getAllPersons();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person updatePerson(@RequestBody @Validated PersonToUpdate personToUpdate) {
        return personService.updatePerson(personToUpdate);
    }

    @DeleteMapping(path = {"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable("id") Long id) {
        personService.deletePerson(id);
    }

}
