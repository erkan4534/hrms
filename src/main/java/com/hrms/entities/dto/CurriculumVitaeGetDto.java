package com.hrms.entities.dto;

import com.hrms.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class CurriculumVitaeGetDto {
    private Long id;
    private Candidate candidate;
    private String linkedinAddress;
    private String githubAddress;
    private String coverLetter;

    private String educationPartName;
    private String educationSchoolName;
    private Date educationStartingDate;
    private Date educationGraduationDate;

    private String experienceFirmName;
    private String experiencePositionName;
    private Date experienceStartingDate;
    private Date experienceQuitDate;

    private String language;
    private Long languageDegree;

    private String abilityName;
}
