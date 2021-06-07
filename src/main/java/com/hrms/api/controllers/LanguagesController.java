package com.hrms.api.controllers;

import com.hrms.bussiness.abstracts.LanguageService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Language>> getAll(){
        return languageService.getAll();
    }

    @PostMapping("/add")
    public Result add (@RequestBody Language language){
        return languageService.add(language);
    }

    @GetMapping("/getLanguages/{curriculumVitaeId}")
    DataResult<List<Language>> getLanguages(@PathVariable Long curriculumVitaeId){
        return languageService.getLanguages(curriculumVitaeId);
    }
}
