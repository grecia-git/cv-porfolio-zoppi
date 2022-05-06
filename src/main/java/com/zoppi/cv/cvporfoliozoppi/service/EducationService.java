package com.zoppi.cv.cvporfoliozoppi.service;

import com.zoppi.cv.cvporfoliozoppi.exception.ObjectNotFound;
import com.zoppi.cv.cvporfoliozoppi.model.education.Education;
import com.zoppi.cv.cvporfoliozoppi.model.education.EducationToCreate;
import com.zoppi.cv.cvporfoliozoppi.model.education.EducationToUpdate;
import com.zoppi.cv.cvporfoliozoppi.repository.EducationRepository;
import com.zoppi.cv.cvporfoliozoppi.repository.PersonRepository;
import com.zoppi.cv.cvporfoliozoppi.repository.entity.EducationEntity;
import com.zoppi.cv.cvporfoliozoppi.repository.entity.PersonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public Education saveEducation(EducationToCreate educationToCreate) {
        // add validation
        logger.info(educationToCreate.toString());
        EducationEntity educationEntity = new EducationEntity();
        educationEntity.setTitle(educationToCreate.getTitle());
        educationEntity.setInstitute(educationToCreate.getInstitute());
        educationEntity.setStartDate(educationToCreate.getStartDate());
        educationEntity.setEndDate(educationToCreate.getEndDate());
        PersonEntity personEntity = personRepository.getById(educationToCreate.getPersonId());
        educationEntity.setPerson(personEntity);

        EducationEntity educationEntitySaved = educationRepository.saveAndFlush(educationEntity);

        Education education = toEducation(educationEntitySaved);
        logger.info(education.toString());
        return education;
    }

    @Transactional
    public Education updateEducation(EducationToUpdate educationToUpdate) {
        // add validation
        logger.info(educationToUpdate.toString());
        EducationEntity educationEntity = new EducationEntity();
        educationEntity.setId(educationToUpdate.getId()); // It needs the id to update
        educationEntity.setTitle(educationToUpdate.getTitle());
        educationEntity.setInstitute(educationToUpdate.getInstitute());
        educationEntity.setStartDate(educationToUpdate.getStartDate());
        educationEntity.setEndDate(educationToUpdate.getEndDate());

        EducationEntity educationEntityUpdated = educationRepository.saveAndFlush(educationEntity);

        Education education = toEducation(educationEntityUpdated);
        logger.info(education.toString());
        return education;
    }

    @Transactional(readOnly = true)
    public Education getEducationById(Long id) {
        logger.info("Education ID " + id);
        EducationEntity educationEntity = educationRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Education with Id " + id + " is not found"));
        Education education = toEducation(educationEntity);
        logger.info(education.toString());
        return education;
    }

    @Transactional(readOnly = true)
    public List<Education> getAllEducations() {
        List<EducationEntity> educationEntityList = educationRepository.findAll();
        List<Education> educationList = educationEntityList.stream()
                .map(this::toEducation)
                .collect(Collectors.toList());
        logger.info(educationList.toString());
        return educationList;
    }

    @Transactional
    public void deleteEducation(Long id) {
        logger.info("Education ID " + id);
        Education education = getEducationById(id);
        educationRepository.deleteById(education.getId());
    }

    private Education toEducation(EducationEntity educationEntity) {
        Education education = new Education();
        education.setId(educationEntity.getId());
        education.setTitle(educationEntity.getTitle());
        education.setInstitute(educationEntity.getInstitute());
        education.setStartDate(educationEntity.getStartDate());
        education.setEndDate(educationEntity.getEndDate());
        education.setPersonId(educationEntity.getPerson().getId());
        return education;
    }
}
