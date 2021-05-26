package com.hrms.bussiness.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.SystemEmployee;
import java.util.List;

public interface SystemEmployeeService {
    DataResult<List<SystemEmployee>> getAll();
    Result add(SystemEmployee systemEmployee);
}
