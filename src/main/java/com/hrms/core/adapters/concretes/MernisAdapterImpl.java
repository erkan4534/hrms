package com.hrms.core.adapters.concretes;

import com.hrms.core.adapters.abstracts.MernisAdapter;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.webServiceClients.MernisApi;
import org.springframework.stereotype.Component;

@Component
public class MernisAdapterImpl implements MernisAdapter {

    @Override
    public Result verify(String nationalId) {
        MernisApi mernisApi = new MernisApi();
        return  new SuccessDataResult<>(mernisApi);
    }

}
