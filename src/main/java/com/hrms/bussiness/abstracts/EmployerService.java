package com.hrms.bussiness.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Employer;
import com.hrms.entities.dto.EmployerDto;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll(EmployerDto employerDto,@PathVariable int pageNo,@PathVariable int pageSize);
    Result add(Employer employer);
    Result edit(Employer employer,Long id);
}
