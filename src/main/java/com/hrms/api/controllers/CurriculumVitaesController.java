package com.hrms.api.controllers;

import com.hrms.bussiness.abstracts.CurriculumVitaeService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.CurriculumVitae;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/curriculumVitaes")
public class CurriculumVitaesController {

    private CurriculumVitaeService curriculumVitaeService;

    @Autowired
    public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
        this.curriculumVitaeService = curriculumVitaeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<CurriculumVitae>> getAll() {
        return curriculumVitaeService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody CurriculumVitae curriculumVitae) {
        return curriculumVitaeService.add(curriculumVitae);
    }

    @GetMapping("/getAllViewCurriculumVitae/{curriculumVitaeId}")
    public DataResult<List<CurriculumVitae>> getAllViewCurriculumVitae(@PathVariable Long curriculumVitaeId) {
        return  curriculumVitaeService.getAllViewCurriculumVitae(curriculumVitaeId);
    }
}
