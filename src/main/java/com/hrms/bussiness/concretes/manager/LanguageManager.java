package com.hrms.bussiness.concretes.manager;

import com.hrms.bussiness.abstracts.LanguageService;
import com.hrms.core.utilities.MessageBundle;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.LanguageDao;
import com.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<>(languageDao.findAll(),MessageBundle.getMessageTr("language.add"));
    }

    @Override
    public Result add(Language language) {
        languageDao.save(language);
        return new SuccessResult(MessageBundle.getMessageTr("language.list"));
    }

    @Override
    public DataResult<List<Language>> getLanguages(Long curriculumVitaeId) {
        return new SuccessDataResult<>(languageDao.getByCurriculumVitae_Id(curriculumVitaeId),
        MessageBundle.getMessageTr("language.list"));
    }


}
