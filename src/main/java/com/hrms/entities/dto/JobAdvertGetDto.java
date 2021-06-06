package com.hrms.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class JobAdvertGetDto {
    private String firmName;
    private String positionName;
    private Long openPositionsNumber;
    private LocalDate createDate;
    private Date applyDeadline;
}
