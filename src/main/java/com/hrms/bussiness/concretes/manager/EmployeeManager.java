package com.hrms.bussiness.concretes.manager;

import com.hrms.bussiness.abstracts.EmployeeService;
import com.hrms.core.utilities.MessageBundle;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.EmployeeDao;
import com.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult(employeeDao.findAll(), MessageBundle.getMessageTr("employee.list"));
    }

    @Override
    public Result add(Employee employee) {
        employeeDao.save(employee);
        return new SuccessResult(MessageBundle.getMessageTr("employee.add"));
    }
}
