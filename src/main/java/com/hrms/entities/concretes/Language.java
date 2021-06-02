package com.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "languageSeq")
    @SequenceGenerator(name = "languageSeq", sequenceName = "languageSeq", allocationSize = 1)
    @JsonIgnore
    @Column(name = "Id")
    private Long id;

    @NotNull
    @Column(name = "Language")
    private String language;

    @Min(1)
    @Max(5)
    @Column(name = "Degree")
    private Long degree;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CurriculumVitaeId",foreignKey = @ForeignKey(name = "language_curriculumVitae_id_fk"))
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private CurriculumVitae curriculumVitae;
}
