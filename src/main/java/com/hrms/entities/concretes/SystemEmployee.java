package com.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SystemEmployees")
public class SystemEmployee implements Serializable {

    @Id
    @Column(name = "Id")
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    @NotBlank(message = "Name field can not be null or empty")
    private String name;

    @Column(name = "Surname")
    @NotBlank(message = "Surname field can not be null or empty")
    private String surname;

    @Column(name = "NationalId",unique = true)
    @NotBlank(message = "NationalId field can not be null or empty")
    private String nationalId;

    @Column(name = "BirthDate")
    @NotNull(message = "BirthDate field can not be null or empty")
    private Date birthDate;

}
