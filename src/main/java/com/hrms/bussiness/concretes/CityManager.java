package com.hrms.bussiness.concretes;

import com.hrms.bussiness.abstracts.CityService;
import com.hrms.core.utilities.MessageBundle;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.CityDao;
import com.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult(cityDao.findAll(),MessageBundle.getMessageTr("city.list"));
    }

    @Override
    public Result add(City city) {
        cityDao.save(city);
        return new SuccessResult(MessageBundle.getMessageTr("city.add"));
    }
}
