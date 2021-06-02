package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationDao extends JpaRepository<Education,Long> {
}
