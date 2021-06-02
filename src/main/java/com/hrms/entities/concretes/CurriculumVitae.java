package com.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CurriculumVitaes")
public class CurriculumVitae {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curriculumVitaeSeq")
    @SequenceGenerator(name = "curriculumVitaeSeq", sequenceName = "curriculumVitaeSeq", allocationSize = 1)
    @JsonIgnore
    @Column(name = "Id")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CandidateId",foreignKey = @ForeignKey(name = "curriculumVitae_candidate_id_fk"))
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Candidate candidate;

    @Column(name = "LinkedinAddress")
    private  String linkedinAddress;

    @Column(name = "GithubAddress")
    private  String githubAddress;

    @Column(name = "CoverLetter")
    private String coverLetter;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<Education> educations;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<Experience> experiences;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<Language> languages;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<Ability> abilities;
}
