package com.hrms.api.controllers;

import com.hrms.bussiness.abstracts.EducationService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
public class EducationsController {

    private EducationService educationService;

    @Autowired
    public EducationsController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Education>> getAll(){
        return educationService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Education education){
       return educationService.add(education);
    }

    @GetMapping("/getAllSortedByGraduationDateDesc/{curriculumVitaeId}")
    public DataResult<List<Education>> getAllSortedByGraduationDateDesc(@PathVariable Long curriculumVitaeId){
        return educationService.getAllSortedByGraduationDateDesc(curriculumVitaeId);
    }
}
