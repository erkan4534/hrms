package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.CurriculumVitae;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae,Long> {

}
