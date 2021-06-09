package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.*;
import com.hrms.entities.dto.CurriculumVitaeGetDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae,Long> {

    @Query("SELECT NEW com.hrms.entities.dto.CurriculumVitaeGetDto(" +
            "cv.id,cv.candidate,cv.linkedinAddress,cv.githubAddress,cv.coverLetter," +
            "edu.partName,edu.schoolName,edu.startingDate,edu.graduationDate," +
            "exp.firmName,exp.positionName,exp.startingDate,exp.quitDate," +
            "lang.language,lang.degree," +
            "abi.abilityName)" +
            "FROM  CurriculumVitae cv " +
            "INNER JOIN cv.educations edu " +
            "INNER JOIN cv.experiences exp " +
            "INNER JOIN cv.languages lang " +
            "INNER JOIN cv.abilities abi " +
            "WHERE cv.id=:curriculumVitaeId ")
    List<CurriculumVitaeGetDto> getAllViewCurriculumVitae(@Param("curriculumVitaeId") Long curriculumVitaeId);
}




