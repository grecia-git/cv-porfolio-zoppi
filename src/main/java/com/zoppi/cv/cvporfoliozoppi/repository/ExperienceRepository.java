package com.zoppi.cv.cvporfoliozoppi.repository;

import com.zoppi.cv.cvporfoliozoppi.repository.entity.ExperienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<ExperienceEntity, Long> {

    List<ExperienceEntity> findAllByPerson_id(Long personId);

    void deleteAllByPerson_id(Long personId);
}
