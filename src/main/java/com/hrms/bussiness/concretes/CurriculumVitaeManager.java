package com.hrms.bussiness.concretes;

import com.hrms.bussiness.abstracts.CurriculumVitaeService;
import com.hrms.core.utilities.MessageBundle;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import com.hrms.entities.concretes.*;
import com.hrms.entities.dto.CurriculumVitaeGetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

    private CurriculumVitaeDao curriculumVitaeDao;

    @Autowired
    public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao) {
        this.curriculumVitaeDao = curriculumVitaeDao;
    }

    @Override
    public DataResult<List<CurriculumVitae>> getAll() {
        return new SuccessDataResult(curriculumVitaeDao.findAll());
    }

    @Override
    public Result add(CurriculumVitae curriculumVitae) {
        curriculumVitaeDao.save(curriculumVitae);
        return new SuccessResult(MessageBundle.getMessageTr("curriculumVitae.add"));
    }

    @Override
    public DataResult<List<CurriculumVitae>> getAllViewCurriculumVitae(Long curriculumVitaeId) {
        return new SuccessDataResult<>(convertToCurriculumVitae(curriculumVitaeId));
    }

    private List<CurriculumVitae> convertToCurriculumVitae(Long curriculumVitaeId) {
        List<CurriculumVitaeGetDto> curriculumVitaeGetDtoList = curriculumVitaeDao.getAllViewCurriculumVitae(curriculumVitaeId);
        List<CurriculumVitae> curriculumVitaeList = new ArrayList<>();
        try {
            curriculumVitaeGetDtoList.stream().forEach(curriculumVitaeDto->{
            CurriculumVitae curriculumVitae = new CurriculumVitae();
          //  curriculumVitae.setId(curriculumVitaeDto.getId());
            curriculumVitae.setCandidate(curriculumVitaeDto.getCandidate());
            curriculumVitae.setLinkedinAddress(curriculumVitaeDto.getLinkedinAddress());
            curriculumVitae.setGithubAddress(curriculumVitaeDto.getGithubAddress());
            curriculumVitae.setCoverLetter(curriculumVitaeDto.getCoverLetter());
           // curriculumVitae.setEducations(curriculumVitaeDto.getEducations());
          //  curriculumVitae.setExperiences(curriculumVitaeDto.getExperiences());
          //  curriculumVitae.setLanguages(curriculumVitaeDto.getLanguages());
          //  curriculumVitae.setAbilities(curriculumVitaeDto.getAbilities());
            curriculumVitaeList.add(curriculumVitae);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return curriculumVitaeList;
    }
}
