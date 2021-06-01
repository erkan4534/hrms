package com.hrms.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
public class JobAdvertAddDto {

    @NotNull
    private Long employerId;

    @NotNull
    private Long positionId;

    @NotBlank
    private String description;

    @NotNull
    private Long cityId;

    @PositiveOrZero
    private Long minSalary;

    @PositiveOrZero
    private Long maxSalary;

    @Positive
    @NotNull
    private Long openPositionsNumber;

    @JsonIgnore
    private final LocalDateTime createDate = LocalDateTime.now();

    @Future
    private LocalDateTime applyDeadline;
}
