package com.hrms.api.controllers;

import com.hrms.bussiness.abstracts.JobAdvertService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.dto.JobAdvertAddDto;
import com.hrms.entities.dto.JobAdvertGetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/jobAdverts")
public class JobAdvertController {

    private JobAdvertService jobAdvertService;

    @Autowired
    public JobAdvertController(JobAdvertService jobAdvertService) {
        this.jobAdvertService = jobAdvertService;
    }

    @GetMapping("/getAllActivePositionJob")
    public  DataResult<List<JobAdvertGetDto>> getAllActivePositionJob(){
        return jobAdvertService.getAllActivePositionJob();
    }

    @GetMapping("/getAllActivePositionJobOrderByApplyDeadline")
    public  DataResult<List<JobAdvertGetDto>> getAllActivePositionJobOrderByApplyDeadline(){
        return jobAdvertService.getAllActivePositionJobOrderByApplyDeadline();
    }

    @GetMapping("/getActivePositionJobForOneFirm")
    public  DataResult<List<JobAdvertGetDto>> getActivePositionJobForOneFirm(Long employerId){
        return jobAdvertService.getActivePositionJobForOneFirm(employerId);
    }

    @PostMapping("/add")
    public Result add (@RequestBody JobAdvertAddDto jobAdvertAddDto) throws ParseException {
        return jobAdvertService.add(jobAdvertAddDto);
    }
}
