package com.hrms.entities.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class JobAdvertAddDto {
    private Long employerId;
    private Long positionId;
    private String description;
    private Long cityId;
    private Long minSalary;
    private Long maxSalary;
    private Long openPositionsNumber;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private Date applyDeadline;
}
