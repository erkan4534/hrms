package com.hrms.bussiness.concretes;

import com.hrms.bussiness.abstracts.EmployerService;
import com.hrms.core.adapters.abstracts.NotificationAdapter;
import com.hrms.core.utilities.MessageBundle;
import com.hrms.core.utilities.results.*;
import com.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.entities.concretes.Employer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private NotificationAdapter notificationAdapter;

    @Autowired
    public EmployerManager(EmployerDao employerDao,NotificationAdapter notificationAdapter) {
        this.employerDao = employerDao;
        this.notificationAdapter=notificationAdapter;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult(employerDao.findAll(), MessageBundle.getMessageTr("employer.list"));
    }

    @Override
    public Result add(Employer employer) {

        Result result = isValidate(employer);

        if (!result.isSuccess()) {
            return result;
        }

        employerDao.save(employer);
        return new SuccessResult(MessageBundle.getMessageTr("employer.add"));
    }

    public Result isValidate(Employer employer) {

        StringBuilder message = new StringBuilder();

        if (StringUtils.isEmpty(employer.getFirmName())) {
            message.append(MessageBundle.getMessageTr("employer.validation.firmname"));
        }

        if (StringUtils.isEmpty(employer.getWebSite())) {
            message.append(MessageBundle.getMessageTr("employer.validation.website"));
        }

        if (StringUtils.isEmpty(employer.getPerson().getEmail())) {
            message.append(MessageBundle.getMessageTr("employer.validation.email"));
        }

        if (StringUtils.isEmpty(employer.getPerson().getPassword())) {
            message.append(MessageBundle.getMessageTr("employer.validation.password"));
        }

        if (message.length() > 0) {
            message.deleteCharAt(message.length() - 1);
            return new ErrorResult(message.toString());
        }

        String email = employer.getPerson().getEmail();
        String website = employer.getWebSite();

        String emailDomain = email.substring(email.indexOf("@") + 1, email.indexOf("com") - 1);
        String websiteDomain = website.substring(website.indexOf("www") + 4, website.indexOf("com") - 1);

        if (!emailDomain.equals(websiteDomain)) {
            message.append(MessageBundle.getMessageTr("employer.validation.domain"));
            return new ErrorResult(message.toString());
        }

        if (employerDao.getByPerson_Email(employer.getPerson().getEmail()) != null) {
            message.append(MessageBundle.getMessageTr("employer.validation.using.email"));
            return new ErrorResult(message.toString());
        }

        return new SuccessResult(message.toString());
    }


}
