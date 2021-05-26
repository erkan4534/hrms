package com.hrms.api.controllers;

import com.hrms.bussiness.abstracts.SystemEmployeeService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.SystemEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/SystemEmployee")
public class SystemEmployeeController {

    private SystemEmployeeService systemEmployeeService;

    @Autowired
    public SystemEmployeeController(SystemEmployeeService systemEmployeeService) {
        this.systemEmployeeService = systemEmployeeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<SystemEmployee>> getAll(){
        return systemEmployeeService.getAll();
    }

    @PostMapping("/add")
    public Result add (@RequestBody SystemEmployee systemEmployee){
       return systemEmployeeService.add(systemEmployee);
    }
}
