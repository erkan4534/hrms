package com.hrms.bussiness.concretes;

import com.hrms.bussiness.abstracts.CurriculumVitaeService;
import com.hrms.core.utilities.MessageBundle;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import com.hrms.dataAccess.abstracts.EducationDao;
import com.hrms.entities.concretes.CurriculumVitae;
import com.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

    private CurriculumVitaeDao curriculumVitaeDao;
    private EducationDao educationDao;

    @Autowired
    public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao, EducationDao educationDao) {
        this.curriculumVitaeDao = curriculumVitaeDao;
        this.educationDao = educationDao;
    }

    @Override
    public DataResult<List<CurriculumVitae>> getAll() {
        return new SuccessDataResult<>(curriculumVitaeDao.findAll());
    }

    @Override
    public Result add(CurriculumVitae curriculumVitae) {
        curriculumVitaeDao.save(curriculumVitae);
        return new SuccessResult(MessageBundle.getMessageTr("curriculumVitae.add"));
    }

    @Override
    public DataResult<List<Education>> getSortDescEducation(Long curriculumVitaeId) {
        return new SuccessDataResult<>(educationDao.getByCurriculumVitae_Id(curriculumVitaeId,
                Sort.by(Sort.Direction.DESC, "graduationDate", Sort.NullHandling.NULLS_FIRST.name())));
    }
}
