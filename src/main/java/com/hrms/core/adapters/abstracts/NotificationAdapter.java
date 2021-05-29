package com.hrms.core.adapters.abstracts;

import com.hrms.core.utilities.results.Result;

public interface NotificationAdapter {
    public void sendMail(String email);
    public Result verifyEmail(String email);
}
