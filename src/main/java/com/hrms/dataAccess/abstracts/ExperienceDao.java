package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.Education;
import com.hrms.entities.concretes.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceDao extends JpaRepository<Experience,Long> {
}
