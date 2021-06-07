package com.hrms.bussiness.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Language;
import java.util.List;

public interface LanguageService {
    DataResult<List<Language>> getAll();
    Result add(Language language);
    DataResult<List<Language>> getLanguages(Long curriculumVitaeId);
}
