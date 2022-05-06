package com.zoppi.cv.cvporfoliozoppi.service;

import com.zoppi.cv.cvporfoliozoppi.exception.ObjectNotFound;
import com.zoppi.cv.cvporfoliozoppi.model.experience.Experience;
import com.zoppi.cv.cvporfoliozoppi.model.experience.ExperienceToCreate;
import com.zoppi.cv.cvporfoliozoppi.model.experience.ExperienceToUpdate;
import com.zoppi.cv.cvporfoliozoppi.model.person.Person;
import com.zoppi.cv.cvporfoliozoppi.model.person.PersonToCreate;
import com.zoppi.cv.cvporfoliozoppi.model.person.PersonToUpdate;
import com.zoppi.cv.cvporfoliozoppi.repository.ExperienceRepository;
import com.zoppi.cv.cvporfoliozoppi.repository.PersonRepository;
import com.zoppi.cv.cvporfoliozoppi.repository.entity.ExperienceEntity;
import com.zoppi.cv.cvporfoliozoppi.repository.entity.PersonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExperienceService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public Experience saveExperience(ExperienceToCreate experienceToCreate) {
        // add validation
        logger.info(experienceToCreate.toString());
        ExperienceEntity experienceEntity = new ExperienceEntity();
        experienceEntity.setRol(experienceToCreate.getRol());
        experienceEntity.setStartDate(experienceToCreate.getStartDate());
        experienceEntity.setEndDate(experienceToCreate.getEndDate());
        PersonEntity personEntity = personRepository.getById(experienceToCreate.getPersonId());
        experienceEntity.setPerson(personEntity);

        ExperienceEntity experienceEntitySaved = experienceRepository.saveAndFlush(experienceEntity);

        Experience experience = toExperience(experienceEntitySaved);
        logger.info(experience.toString());
        return experience;
    }

    @Transactional
    public Experience updateExperience(ExperienceToUpdate experienceToUpdate) {
        // add validation
        logger.info(experienceToUpdate.toString());
        ExperienceEntity experienceEntity = new ExperienceEntity();
        experienceEntity.setId(experienceToUpdate.getId()); // It needs the id to update
        experienceEntity.setRol(experienceToUpdate.getRol());
        experienceEntity.setStartDate(experienceToUpdate.getStartDate());
        experienceEntity.setEndDate(experienceToUpdate.getEndDate());

        ExperienceEntity experienceEntityUpdated = experienceRepository.saveAndFlush(experienceEntity);

        Experience experience = toExperience(experienceEntityUpdated);
        logger.info(experience.toString());
        return experience;
    }

    @Transactional(readOnly = true)
    public Experience getExperienceById(Long id) {
        logger.info("Experience ID " + id);
        ExperienceEntity experienceEntity = experienceRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Experience with Id " + id + " is not found"));
        Experience experience = toExperience(experienceEntity);
        logger.info(experience.toString());
        return experience;
    }

    @Transactional(readOnly = true)
    public List<Experience> getAllExperiences() {
        List<ExperienceEntity> experienceEntityList = experienceRepository.findAll();
        List<Experience> experienceList = experienceEntityList.stream()
                .map(this::toExperience)
                .collect(Collectors.toList());
        logger.info(experienceList.toString());
        return experienceList;
    }

    @Transactional
    public void deleteExperience(Long id) {
        logger.info("Experience ID " + id);
        Experience experience = getExperienceById(id);
        experienceRepository.deleteById(experience.getId());
    }

    private Experience toExperience(ExperienceEntity experienceEntity) {
        Experience experience = new Experience();
        experience.setId(experienceEntity.getId());
        experience.setRol(experienceEntity.getRol());
        experience.setStartDate(experienceEntity.getStartDate());
        experience.setEndDate(experienceEntity.getEndDate());
        experience.setPersonId(experienceEntity.getPerson().getId());
        return experience;
    }
}
