package com.zoppi.cv.cvporfoliozoppi.repository;

import com.zoppi.cv.cvporfoliozoppi.repository.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, Long> {

    List<SkillEntity> findAllByPerson_id(Long personId);

    List<SkillEntity> findAllByCategory(String category);

    void deleteAllByPerson_id(Long personId);
}
