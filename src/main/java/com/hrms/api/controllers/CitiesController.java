package com.hrms.api.controllers;

import com.hrms.bussiness.abstracts.CityService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {

    private CityService cityService;

    @Autowired
    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getAll")
    public DataResult<List<City>> getAll(){
        return cityService.getAll();
    }

    @PostMapping("/add")
    public Result add (@RequestBody City city){
        return cityService.add(city);
    }
}
