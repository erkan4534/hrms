package com.hrms.api.controllers;

import com.hrms.bussiness.abstracts.EmployerService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Employer;
import com.hrms.entities.dto.EmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {

    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Employer>> getAll(EmployerDto employerDto){
        return employerService.getAll(employerDto);
    }

    @PostMapping("/add")
    public Result add (@RequestBody Employer employer){
        return employerService.add(employer);
    }
}
