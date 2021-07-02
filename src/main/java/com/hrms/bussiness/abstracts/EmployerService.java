package com.hrms.bussiness.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Employer;
import com.hrms.entities.dto.EmployerDto;
import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll(EmployerDto employerDto);
    Result add(Employer employer);
    Result edit(Employer employer,Long id);
}
