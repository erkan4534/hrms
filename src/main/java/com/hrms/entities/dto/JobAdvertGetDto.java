package com.hrms.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class JobAdvertGetDto {
    private String firmName;
    private String positionName;
    private Long openPositionsNumber;
    private LocalDateTime createDate;
    private LocalDateTime applyDeadline;
}
