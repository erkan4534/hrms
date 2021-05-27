package com.hrms.bussiness.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Position;
import java.util.List;

public interface PositionService {
    DataResult<List<Position>> getAll();
    Result add(Position position);
}
