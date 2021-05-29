package com.hrms.bussiness.concretes;

import com.hrms.bussiness.abstracts.CandidateService;
import com.hrms.core.adapters.abstracts.MernisAdapter;
import com.hrms.core.adapters.abstracts.NotificationAdapter;
import com.hrms.core.utilities.MessageBundle;
import com.hrms.core.utilities.results.*;
import com.hrms.dataAccess.abstracts.CandidateDao;
import com.hrms.entities.concretes.Candidate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;
    private MernisAdapter mernisAdapter;
    private NotificationAdapter notificationAdapter;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, MernisAdapter mernisAdapter,NotificationAdapter notificationAdapter) {
        this.candidateDao = candidateDao;
        this.mernisAdapter = mernisAdapter;
        this.notificationAdapter=notificationAdapter;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<>(candidateDao.findAll(), MessageBundle.getMessageTr("candidate.list"));
    }

    @Override
    public Result add(Candidate candidate) {
        Result result = isValidate(candidate);
        if (!result.isSuccess()) {
            return result;
        }
        candidateDao.save(candidate);
        notificationAdapter.sendMail(candidate.getPerson().getEmail());
        return new SuccessResult(MessageBundle.getMessageTr("candidate.add"));
    }

    public Result isValidate(Candidate candidate) {

        StringBuilder message = new StringBuilder();

        if (StringUtils.isEmpty(candidate.getName())) {
            message.append(MessageBundle.getMessageTr("candidate.validation.name"));
        }

        if (StringUtils.isEmpty(candidate.getSurname())) {
            message.append(MessageBundle.getMessageTr("candidate.validation.surname"));
        }

        if (StringUtils.isEmpty(candidate.getNationalId())) {
            message.append(MessageBundle.getMessageTr("candidate.validation.nationalId"));
        }

        if (candidate.getBirthDate() == null) {
            message.append(MessageBundle.getMessageTr("candidate.validation.birthdate"));
        }

        if (StringUtils.isEmpty(candidate.getPerson().getPassword())) {
            message.append(MessageBundle.getMessageTr("candidate.validation.password"));
        }

        if (StringUtils.isEmpty(candidate.getPerson().getEmail())) {
            message.append(MessageBundle.getMessageTr("candidate.validation.email"));
        }

        if (message.length() > 0) {
            message.deleteCharAt(message.length() - 1);
            return new ErrorResult(message.toString());
        }

        if (candidateDao.getByPerson_Email(candidate.getPerson().getEmail()) != null) {
            message.append(MessageBundle.getMessageTr("candidate.validation.using.email"));
            return new ErrorResult(message.toString());
        }

        if (candidateDao.getByNationalId(candidate.getNationalId()) != null) {
            message.append(MessageBundle.getMessageTr("candidate.validation.using.nationalId"));
            return new ErrorResult(message.toString());
        }

        Result mernisVerifyResult = mernisAdapter.verify(candidate.getNationalId());

        if (!mernisVerifyResult.isSuccess()) {
            message.append(MessageBundle.getMessageTr("candidate.validation.mernis.nationalId.verify"));
            return new ErrorResult(message.toString());
        }

       Result emailVerifyResult =notificationAdapter.verifyEmail(candidate.getPerson().getEmail());

        if(!emailVerifyResult.isSuccess()){
            message.append(MessageBundle.getMessageTr("candidate.validation.email.verify"));
            return new ErrorResult(message.toString());
        }

        return new SuccessResult(message.toString());
    }
}
