package com.hrms.api.controllers;

import com.hrms.bussiness.abstracts.EmployerService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Employer;
import com.hrms.entities.dto.EmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/getAll/{pageNo}/{pageSize}")
    public DataResult<List<Employer>> getAll(EmployerDto employerDto,@PathVariable int pageNo,@PathVariable int pageSize) {
        return employerService.getAll(employerDto,pageNo,pageSize);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employer employer) {
        return employerService.add(employer);
    }

    @PutMapping("/edit/{id}")
    public Result edit(@RequestBody Employer employer, @PathVariable Long id) {
        return employerService.edit(employer, id);
    }
}
