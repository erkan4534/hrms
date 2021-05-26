package com.hrms.entities.concretes;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Persons")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Email",unique = true)
    @NotBlank(message = "Email field can not be null or empty")
    private String email;

    @Column(name = "Password")
    @NotBlank(message = "Password field can not be null or empty")
    private String password;

    @Column(name = "TelNo")
    @NotBlank(message = "TelNo field can not be null or empty")
    private String telNo;
}
