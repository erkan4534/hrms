package com.hrms.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployerDto {

    private String email;
    private String telNo;
    private String firmName;
    private String webSite;
}
