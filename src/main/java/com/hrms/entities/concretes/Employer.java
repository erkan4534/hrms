package com.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employers")
public class Employer implements Serializable {

    @Id
    @Column(name = "Id")
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FirmName")
    @NotBlank(message = "FirmName field can not be null or empty")
    private String firmName;

    @Column(name = "WebSite")
    @NotBlank(message = "WebSite field can not be null or empty")
    private String webSite;
}
