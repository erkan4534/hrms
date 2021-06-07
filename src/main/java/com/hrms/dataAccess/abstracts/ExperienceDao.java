package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.Experience;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExperienceDao extends JpaRepository<Experience,Long> {
    List<Experience> getByCurriculumVitae_Id(Long curriculumVitaeId, Sort sort);
}
