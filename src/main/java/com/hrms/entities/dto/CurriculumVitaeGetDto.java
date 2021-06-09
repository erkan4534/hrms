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

    private String partName;
    private String schoolName;
    private Date startingDate;
    private Date graduationDate;

    private String firmName;
    private String positionName;
    private Date experienceStartingDate;
    private Date quitDate;

    private String language;
    private Long degree;

    private String name;
}
