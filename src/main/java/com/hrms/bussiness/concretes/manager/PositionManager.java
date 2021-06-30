package com.hrms.bussiness.concretes.manager;

import com.hrms.bussiness.abstracts.PositionService;
import com.hrms.core.utilities.MessageBundle;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.PositionDao;
import com.hrms.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PositionManager implements PositionService {

    private PositionDao positionDao;

    @Autowired
    public PositionManager(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @Override
    public DataResult<List<Position>> getAll() {
        return new SuccessDataResult(positionDao.findAll(),MessageBundle.getMessageTr("position.add"));
    }

    @Override
    public Result add(Position position) {
        positionDao.save(position);
        return new SuccessResult(MessageBundle.getMessageTr("position.list"));
    }
}
