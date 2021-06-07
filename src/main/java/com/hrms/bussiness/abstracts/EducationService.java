package com.hrms.bussiness.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Education;
import java.util.List;

public interface EducationService {
    DataResult<List<Education>> getAll();
    Result add(Education education);
    DataResult<List<Education>> getAllSortedByGraduationDateDesc(Long curriculumVitaeId);
}
