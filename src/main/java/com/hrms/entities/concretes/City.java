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
@Table(name = "Cities")
public class City implements Serializable {

    @Id
    @Column(name = "Id")
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "citySeq")
    @SequenceGenerator(name = "citySeq", sequenceName = "citySeq", allocationSize = 1)
    private Long id;

    @Column(name = "Name")
    @NotBlank(message = "Name field can not be null or empty")
    private String name;

}
