package com.zoppi.cv.cvporfoliozoppi.service;

import com.zoppi.cv.cvporfoliozoppi.exception.ObjectNotFound;
import com.zoppi.cv.cvporfoliozoppi.model.person.Person;
import com.zoppi.cv.cvporfoliozoppi.model.person.PersonToCreate;
import com.zoppi.cv.cvporfoliozoppi.model.person.PersonToUpdate;
import com.zoppi.cv.cvporfoliozoppi.repository.EducationRepository;
import com.zoppi.cv.cvporfoliozoppi.repository.ExperienceRepository;
import com.zoppi.cv.cvporfoliozoppi.repository.PersonRepository;
import com.zoppi.cv.cvporfoliozoppi.repository.SkillRepository;
import com.zoppi.cv.cvporfoliozoppi.repository.entity.PersonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Transactional
    public Person savePerson(PersonToCreate personToCreate) {
        // add validation
        logger.info(personToCreate.toString());
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(personToCreate.getName());
        personEntity.setSurname(personToCreate.getSurname());
        personEntity.setDescription(personToCreate.getDescription());
        personEntity.setProfession(personToCreate.getProfession());
        PersonEntity personEntitySaved = personRepository.saveAndFlush(personEntity);

        Person person = toPerson(personEntitySaved);
        logger.info(personToCreate.toString());
        return person;
    }

    @Transactional
    public Person updatePerson(PersonToUpdate personToUpdate) {
        // add validation
        logger.info(personToUpdate.toString());
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(personToUpdate.getId()); // It needs the id to update
        personEntity.setName(personToUpdate.getName());
        personEntity.setSurname(personToUpdate.getSurname());
        personEntity.setDescription(personToUpdate.getDescription());
        personEntity.setProfession(personToUpdate.getProfession());
        PersonEntity personEntityUpdated = personRepository.saveAndFlush(personEntity);

        Person person = toPerson(personEntityUpdated);
        logger.info(person.toString());
        return person;
    }

    @Transactional(readOnly = true)
    public Person getPersonById(Long id) {
        logger.info("Person ID " + id);
        PersonEntity personEntity = personRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Person with Id " + id + " is not found"));
        Person person = toPerson(personEntity);
        logger.info(person.toString());
        return person;
    }

    @Transactional(readOnly = true)
    public List<Person> getAllPersons() {
        List<PersonEntity> personEntityList = personRepository.findAll();
        List<Person> personList = personEntityList.stream()
                .map(this::toPerson)
                .collect(Collectors.toList());
        logger.info(personEntityList.toString());
        return personList;
    }

    @Transactional
    public void deletePerson(Long id) {
        logger.info("Person ID " + id);
        Person person = getPersonById(id);
        experienceRepository.deleteAllByPerson_id(id);
        educationRepository.deleteAllByPerson_id(id);
        skillRepository.deleteAllByPerson_id(id);
        personRepository.deleteById(person.getId());
    }

    private Person toPerson(PersonEntity personEntity) {
        Person person = new Person();
        person.setProfession(personEntity.getProfession());
        person.setId(personEntity.getId());
        person.setName(personEntity.getName());
        person.setSurname(personEntity.getSurname());
        person.setDescription(personEntity.getDescription());
        return person;
    }
}
