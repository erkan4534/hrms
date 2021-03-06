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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
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
    public DataResult<List<Employer>> getAll(EmployerDto employerDto, @PathVariable int pageNo, @PathVariable int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Employer> pageData = employerDao.findAll(employerSpecification.getFilter(employerDto),paging);
        return new SuccessDataResult(pageData, MessageBundle.getMessageTr("employer.list"));
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

        Employer editEmployer=employerDao.findById(id)
                .map(emp -> {
                    emp.setFirmName(employer.getFirmName());
                    emp.setWebSite(employer.getWebSite());
                    emp.getPerson().setEmail(employer.getPerson().getEmail());
                    emp.getPerson().setTelNo(employer.getPerson().getTelNo());
                    emp.getPerson().setPassword(employer.getPerson().getPassword());
                    emp.getPerson().setRePassword(employer.getPerson().getRePassword());
                    return emp;
                }).get();

        Result result = isValidate(editEmployer);
        if (!result.isSuccess()) {
            return result;
        }

        employerDao.save(editEmployer);
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

        if(StringUtils.isEmpty(employer.getPerson().getRePassword())){
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

        if (employer.getId()==null && employerDao.getByPerson_Email(employer.getPerson().getEmail()) != null) {
            message.append(MessageBundle.getMessageTr("employer.validation.using.email"));
            return new ErrorResult(message.toString());
        }

        if(!employer.getPerson().getPassword().equals(employer.getPerson().getRePassword())){
            message.append(MessageBundle.getMessageTr("employer.validation.passwords.match"));
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
