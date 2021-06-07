package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.Education;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EducationDao extends JpaRepository<Education,Long> {
    List<Education> getByCurriculumVitae_Id(Long curriculumVitaeId,Sort sort);
}
