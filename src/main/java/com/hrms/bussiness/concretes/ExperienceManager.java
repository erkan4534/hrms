package com.hrms.bussiness.concretes;

import com.hrms.bussiness.abstracts.ExperienceService;
import com.hrms.core.utilities.MessageBundle;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.ExperienceDao;
import com.hrms.entities.concretes.Education;
import com.hrms.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceManager implements ExperienceService {

    private ExperienceDao experienceDao;

    @Autowired
    public ExperienceManager(ExperienceDao experienceDao) {
        this.experienceDao = experienceDao;
    }

    @Override
    public DataResult<List<Experience>> getAll() {
        return new SuccessDataResult(experienceDao.findAll(), MessageBundle.getMessageTr("experience.list"));
    }

    @Override
    public Result add(Experience experience) {
        experienceDao.save(experience);
        return new SuccessResult(MessageBundle.getMessageTr("experience.add"));
    }

    @Override
    public DataResult<List<Experience>> getAllSortedByQuitDateDesc(Long curriculumVitaeId) {
        return new SuccessDataResult(experienceDao.getByCurriculumVitae_Id(curriculumVitaeId,
        Sort.by(new Sort.Order(Sort.Direction.DESC, "quitDate", Sort.NullHandling.NULLS_FIRST))),
        MessageBundle.getMessageTr("experience.list.graduationDate.desc"));
    }
}
