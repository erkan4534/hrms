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
@Table(name = "Candidates")
public class Candidate implements Serializable {

    @Id
    @Column(name = "Id")
    @JsonIgnore
    private Long id;

    @MapsId
    @JoinColumn(name = "Id")
    @OneToOne
    private Person person;

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
    @Temporal(TemporalType.DATE)
    private Date birthDate;

}
