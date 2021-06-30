package com.hrms.bussiness.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Employer;
import com.hrms.entities.dto.EmployerDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll(Employer employer, Pageable pageable);
    Result add(Employer employer);
}
