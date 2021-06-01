package com.hrms.bussiness.concretes;

import com.hrms.bussiness.abstracts.JobAdvertService;
import com.hrms.core.utilities.MessageBundle;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.dataAccess.abstracts.*;
import com.hrms.entities.concretes.JobAdvert;
import com.hrms.entities.dto.JobAdvertAddDto;
import com.hrms.entities.dto.JobAdvertGetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobAdvertManager implements JobAdvertService {

    private JobAdvertDao jobAdvertDao;
    private CityDao cityDao;
    private EmployerDao employerDao;
    private PositionDao positionDao;

    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertDao, CityDao cityDao,
                            EmployerDao employerDao, PositionDao positionDao) {
        this.jobAdvertDao = jobAdvertDao;
        this.cityDao = cityDao;
        this.employerDao = employerDao;
        this.positionDao = positionDao;
    }

    @Override
    public DataResult<List<JobAdvertGetDto>> getAllActivePositionJob() {
        return new SuccessDataResult(jobAdvertDao.getAllActivePositionJob(),MessageBundle.getMessageTr("jobAdvert.list"));
    }

    @Override
    public DataResult<List<JobAdvertGetDto>> getAllActivePositionJobOrderByApplyDeadline() {
        return new SuccessDataResult(jobAdvertDao.getAllActivePositionJobOrderByApplyDeadline(),MessageBundle.getMessageTr("jobAdvert.list"));
    }

    @Override
    public DataResult<List<JobAdvertGetDto>> getActivePositionJobForOneFirm(Long employerId) {
        return new SuccessDataResult(jobAdvertDao.getActivePositionJobForOneFirm(employerId), MessageBundle.getMessageTr("jobAdvert.list"));
    }

    @Override
    public Result add(JobAdvertAddDto jobAdvertAddDto) {
        JobAdvert jobAdvert = convertToJobAdvert(jobAdvertAddDto);
        return new SuccessDataResult(jobAdvertDao.save(jobAdvert),MessageBundle.getMessageTr("jobAdvert.add"));
    }

    private JobAdvert convertToJobAdvert(JobAdvertAddDto jobAdvertAddDto) {
        JobAdvert jobAdvert = null;
        try {
            jobAdvert = new JobAdvert();
            jobAdvert.setEmployer(this.employerDao.getById(jobAdvertAddDto.getEmployerId()));
            jobAdvert.setCity(this.cityDao.getById(jobAdvertAddDto.getCityId()));
            jobAdvert.setPosition(this.positionDao.getById(jobAdvertAddDto.getPositionId()));
            jobAdvert.setDescription(jobAdvertAddDto.getDescription());
            jobAdvert.setOpenPositionsNumber(jobAdvertAddDto.getOpenPositionsNumber());
            jobAdvert.setApplyDeadline(jobAdvertAddDto.getApplyDeadline());
            jobAdvert.setMinSalary(jobAdvertAddDto.getMinSalary());
            jobAdvert.setMaxSalary(jobAdvertAddDto.getMaxSalary());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobAdvert;
    }
}
