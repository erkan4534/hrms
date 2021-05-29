package com.hrms.core.adapters.abstracts;

import com.hrms.core.utilities.results.Result;

public interface MernisAdapter {
    Result verify(String nationalId);
}
