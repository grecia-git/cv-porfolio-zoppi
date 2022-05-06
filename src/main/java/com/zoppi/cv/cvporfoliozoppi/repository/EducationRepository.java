package com.zoppi.cv.cvporfoliozoppi.repository;

import com.zoppi.cv.cvporfoliozoppi.repository.entity.EducationEntity;
import com.zoppi.cv.cvporfoliozoppi.repository.entity.ExperienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<EducationEntity, Long> {

    List<ExperienceEntity> findAllByPerson_id(Long personId);

    void deleteAllByPerson_id(Long personId);
}
