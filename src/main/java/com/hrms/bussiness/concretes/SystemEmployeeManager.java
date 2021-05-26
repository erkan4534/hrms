package com.hrms.bussiness.concretes;

import com.hrms.bussiness.abstracts.SystemEmployeeService;
import com.hrms.core.utilities.MessageBundle;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.SystemEmployeeDao;
import com.hrms.entities.concretes.SystemEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SystemEmployeeManager implements SystemEmployeeService {

    private SystemEmployeeDao employeeDao;

    @Autowired
    public SystemEmployeeManager(SystemEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public DataResult<List<SystemEmployee>> getAll() {
        return  new SuccessDataResult<>(employeeDao.findAll(), MessageBundle.getMessageTr("systemEmployee.list"));
    }

    @Override
    public Result add(SystemEmployee systemEmployee) {
        employeeDao.save(systemEmployee);
        return new SuccessResult(MessageBundle.getMessageTr("systemEmployee.add"));
    }
}
