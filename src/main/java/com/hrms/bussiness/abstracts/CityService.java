package com.hrms.bussiness.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.City;
import com.hrms.entities.concretes.Employee;
import java.util.List;

public interface CityService {
    DataResult<List<City>> getAll();
    Result add(City city);
}
