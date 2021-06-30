package com.hrms.bussiness.concretes.manager;

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
        return new SuccessDataResult<>(convertToCurriculumVitae(curriculumVitaeId),MessageBundle.getMessageTr("curriculumVitae.getAllViewCurriculumVitae"));
    }

    private List<CurriculumVitae> convertToCurriculumVitae(Long curriculumVitaeId) {
        List<CurriculumVitaeGetDto> curriculumVitaeGetDtoList = curriculumVitaeDao.getAllViewCurriculumVitae(curriculumVitaeId);
        List<CurriculumVitae> curriculumVitaeList = new ArrayList<>();
        try {
            curriculumVitaeGetDtoList.stream().forEach(curriculumVitaeDto -> {
                CurriculumVitae curriculumVitae = new CurriculumVitae();
                curriculumVitae.setId(curriculumVitaeDto.getId());
                curriculumVitae.setCandidate(curriculumVitaeDto.getCandidate());
                curriculumVitae.setLinkedinAddress(curriculumVitaeDto.getLinkedinAddress());
                curriculumVitae.setGithubAddress(curriculumVitaeDto.getGithubAddress());
                curriculumVitae.setCoverLetter(curriculumVitaeDto.getCoverLetter());

                Education education = new Education();
                education.setPartName(curriculumVitaeDto.getPartName());
                education.setSchoolName(curriculumVitaeDto.getSchoolName());
                education.setStartingDate(curriculumVitaeDto.getStartingDate());
                education.setGraduationDate(curriculumVitaeDto.getGraduationDate());
                curriculumVitae.getEducations().add(education);

                Experience experience = new Experience();
                experience.setFirmName(curriculumVitaeDto.getFirmName());
                experience.setPositionName(curriculumVitaeDto.getPositionName());
                experience.setQuitDate(curriculumVitaeDto.getQuitDate());
                experience.setStartingDate(curriculumVitaeDto.getStartingDate());
                curriculumVitae.getExperiences().add(experience);

                Language language = new Language();
                language.setLanguage(curriculumVitaeDto.getLanguage());
                language.setDegree(curriculumVitaeDto.getDegree());
                curriculumVitae.getLanguages().add(language);

                Ability ability = new Ability();
                ability.setAbilityName(curriculumVitaeDto.getName());

                curriculumVitae.getAbilities().add(ability);
                curriculumVitaeList.add(curriculumVitae);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return curriculumVitaeList;
    }
}
