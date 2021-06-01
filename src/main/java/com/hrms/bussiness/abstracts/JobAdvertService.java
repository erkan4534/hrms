package com.hrms.bussiness.abstracts;


import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.dto.JobAdvertAddDto;
import com.hrms.entities.dto.JobAdvertGetDto;
import org.springframework.data.repository.query.Param;

import java.text.ParseException;
import java.util.List;


public interface JobAdvertService {
    DataResult<List<JobAdvertGetDto>> getAllActivePositionJob();
    Result add(JobAdvertAddDto jobAdvertAddDto) throws ParseException;
    DataResult<List<JobAdvertGetDto>> getAllActivePositionJobOrderByApplyDeadline();
    DataResult<List<JobAdvertGetDto>> getActivePositionJobForOneFirm(Long employerId);
}
