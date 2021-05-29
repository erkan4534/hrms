package com.hrms.core.adapters.concretes;

import com.hrms.core.adapters.abstracts.NotificationAdapter;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Service;

@Service
public class NotificationAdapterImpl implements NotificationAdapter {

    @Override
    public void sendMail(String email) {

    }

    @Override
    public Result verifyEmail(String email) {

        return new SuccessResult("Email doğrulaması gerçekleşmiştir");
    }
}
