package com.zoppi.cv.cvporfoliozoppi.service;

import com.zoppi.cv.cvporfoliozoppi.exception.ObjectNotFound;
import com.zoppi.cv.cvporfoliozoppi.model.skill.Skill;
import com.zoppi.cv.cvporfoliozoppi.model.skill.SkillToCreate;
import com.zoppi.cv.cvporfoliozoppi.model.skill.SkillToUpdate;
import com.zoppi.cv.cvporfoliozoppi.repository.PersonRepository;
import com.zoppi.cv.cvporfoliozoppi.repository.SkillRepository;
import com.zoppi.cv.cvporfoliozoppi.repository.entity.PersonEntity;
import com.zoppi.cv.cvporfoliozoppi.repository.entity.SkillEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public Skill saveSkill(SkillToCreate skillToCreate) {
        // add validation
        logger.info(skillToCreate.toString());
        SkillEntity skillEntity = new SkillEntity();
        skillEntity.setCategory(skillToCreate.getCategory());
        skillEntity.setType(skillToCreate.getType());
        skillEntity.setLevel(skillToCreate.getLevel());
        PersonEntity personEntity = personRepository.getById(skillToCreate.getPersonId());
        skillEntity.setPerson(personEntity);

        SkillEntity skillEntitySaved = skillRepository.saveAndFlush(skillEntity);

        Skill skill = toSkill(skillEntitySaved);
        logger.info(skill.toString());
        return skill;
    }

    @Transactional
    public Skill updateSkill(SkillToUpdate skillToUpdate) {
        // add validation
        logger.info(skillToUpdate.toString());
        SkillEntity skillEntity = new SkillEntity();
        skillEntity.setId(skillToUpdate.getId());
        skillEntity.setCategory(skillToUpdate.getCategory());
        skillEntity.setType(skillToUpdate.getType());
        skillEntity.setLevel(skillToUpdate.getLevel());

        SkillEntity experienceEntityUpdated = skillRepository.saveAndFlush(skillEntity);

        Skill skill = toSkill(experienceEntityUpdated);
        logger.info(skill.toString());
        return skill;
    }

    @Transactional(readOnly = true)
    public Skill getSkillById(Long id) {
        logger.info("Skill ID " + id);
        SkillEntity skillEntity = skillRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Skill with Id " + id + " is not found"));
        Skill skill = toSkill(skillEntity);
        logger.info(skill.toString());
        return skill;
    }

    @Transactional(readOnly = true)
    public List<Skill> getAllSkillsByCategory(String category) {
        List<SkillEntity> experienceEntityList = skillRepository.findAllByCategory(category);
        List<Skill> experienceList = experienceEntityList.stream()
                .map(this::toSkill)
                .collect(Collectors.toList());
        logger.info(experienceList.toString());
        return experienceList;
    }

    @Transactional
    public void deleteSkill(Long id) {
        logger.info("Skill ID " + id);
        Skill skill = getSkillById(id);
        skillRepository.deleteById(skill.getId());
    }

    private Skill toSkill(SkillEntity skillEntity) {
        Skill skill = new Skill();
        skill.setId(skillEntity.getId());
        skill.setCategory(skillEntity.getCategory());
        skill.setType(skillEntity.getType());
        skill.setLevel(skillEntity.getLevel());
        skill.setPersonId(skillEntity.getPerson().getId());
        return skill;
    }
}

