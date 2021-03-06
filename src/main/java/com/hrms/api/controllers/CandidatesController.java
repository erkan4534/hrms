package com.hrms.api.controllers;

import com.hrms.bussiness.abstracts.CandidateService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Candidate>> getAll(){
        return candidateService.getAll();
    }

    @PostMapping("/add")
    public Result add (@RequestBody Candidate candidate){
      return candidateService.add(candidate);
    }

}
