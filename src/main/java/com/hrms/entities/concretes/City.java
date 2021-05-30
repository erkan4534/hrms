package com.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
public class City implements Serializable {

    @Id
    @Column(name = "Id")
    @JsonIgnore
    private Long id;

    @Column(name = "Name")
    @NotBlank(message = "Name field can not be null or empty")
    private String name;

}
