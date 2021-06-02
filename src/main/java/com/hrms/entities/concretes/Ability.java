package com.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Abilities")
public class Ability {

    @Id
    @Column(name = "Id")
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "abilitySeq")
    @SequenceGenerator(name = "abilitySeq", sequenceName = "abilitySeq", allocationSize = 1)
    private Long id;

    @Column(name = "AbilityName")
    @NotBlank(message = "Name field can not be null or empty")
    private String abilityName;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CurriculumVitaeId",foreignKey = @ForeignKey(name = "ability_curriculumVitae_id_fk"))
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private CurriculumVitae curriculumVitae;
}
