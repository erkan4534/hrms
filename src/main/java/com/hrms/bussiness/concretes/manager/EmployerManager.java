package com.hrms.bussiness.concretes.manager;

import com.hrms.bussiness.abstracts.EmployerService;
import com.hrms.bussiness.concretes.specification.EmployerSpecification;
import com.hrms.core.adapters.abstracts.NotificationAdapter;
import com.hrms.core.utilities.MessageBundle;
import com.hrms.core.utilities.results.*;
import com.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.entities.concretes.Employer;
import com.hrms.entities.dto.EmployerDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private NotificationAdapter notificationAdapter;
    private EmployerSpecification employerSpecification;

    @Autowired
    public EmployerManager(EmployerDao employerDao,NotificationAdapter notificationAdapter,EmployerSpecification employerSpecification) {
        this.employerDao = employerDao;
        this.notificationAdapter=notificationAdapter;
        this.employerSpecification=employerSpecification;
    }

    @Override
    public DataResult<List<Employer>> getAll(EmployerDto employerDto) {
        return new SuccessDataResult(employerDao.findAll(employerSpecification.getFilter(employerDto)), MessageBundle.getMessageTr("employer.list"));
    }

    @Override
    public Result add(Employer employer) {

        Result result = isValidate(employer);

        if (!result.isSuccess()) {
            return result;
        }

        employerDao.save(employer);
        notificationAdapter.sendMail(employer.getPerson().getEmail());
        return new SuccessResult(MessageBundle.getMessageTr("employer.add"));
    }

    @Override
    public Result edit(Employer employer, Long id) {

        employerDao.findById(id)
                .map(emp -> {
                    emp.setFirmName(employer.getFirmName());
                    emp.setWebSite(employer.getWebSite());
                    emp.getPerson().setEmail(employer.getPerson().getEmail());
                    emp.getPerson().setTelNo(employer.getPerson().getTelNo());
                    emp.getPerson().setPassword(employer.getPerson().getPassword());
                    return employerDao.save(emp);
                });

        return new SuccessResult(MessageBundle.getMessageTr("employer.edit"));
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

        Result emailVerifyResult =notificationAdapter.verifyEmail(employer.getPerson().getEmail());

        if(!emailVerifyResult.isSuccess()){
            message.append(MessageBundle.getMessageTr("employer.validation.email.verify"));
            return new ErrorResult(message.toString());
        }

        return new SuccessResult(message.toString());
    }


}
