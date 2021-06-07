package com.hrms.bussiness.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Education;
import com.hrms.entities.concretes.Experience;
import java.util.List;

public interface ExperienceService {
    DataResult<List<Experience>> getAll();
    Result add(Experience experience);
    DataResult<List<Experience>> getAllSortedByQuitDateDesc(Long curriculumVitaeId);
}
