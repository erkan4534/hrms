package com.hrms.bussiness.concretes;

import com.hrms.bussiness.abstracts.EducationService;
import com.hrms.core.utilities.MessageBundle;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.EducationDao;
import com.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EducationManager implements EducationService {

    private EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<>(this.educationDao.findAll(), MessageBundle.getMessageTr("education.list"));
    }

    @Override
    public Result add(Education education) {
        this.educationDao.save(education);
        return new SuccessResult(MessageBundle.getMessageTr("education.add"));
    }
}
