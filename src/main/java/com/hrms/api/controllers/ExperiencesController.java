package com.hrms.api.controllers;

import com.hrms.bussiness.abstracts.ExperienceService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {

    private ExperienceService experienceService;

    @Autowired
    public ExperiencesController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Experience>> getAll() {
        return experienceService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Experience experience) {
       return experienceService.add(experience);
    }

    @GetMapping("/getAllSortedByQuitDateDesc/{curriculumVitaeId}")
    DataResult<List<Experience>> getAllSortedByQuitDateDesc(@PathVariable Long curriculumVitaeId){
        return experienceService.getAllSortedByQuitDateDesc(curriculumVitaeId);
    }
}
