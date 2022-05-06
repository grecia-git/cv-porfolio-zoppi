package com.zoppi.cv.cvporfoliozoppi.repository;

import com.zoppi.cv.cvporfoliozoppi.repository.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}



