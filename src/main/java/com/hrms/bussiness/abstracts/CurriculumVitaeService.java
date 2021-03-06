package com.hrms.bussiness.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.CurriculumVitae;
import java.util.List;

public interface CurriculumVitaeService {
    DataResult<List<CurriculumVitae>> getAll();
    Result add(CurriculumVitae curriculumVitae);
    DataResult<List<CurriculumVitae>> getAllViewCurriculumVitae(Long curriculumVitaeId);
}
