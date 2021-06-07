package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LanguageDao extends JpaRepository<Language,Long> {
    List<Language> getByCurriculumVitae_Id(Long curriculumVitaeId);
}
