package com.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Educations")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","CurriculumVitaes"})
public class Education implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "educationSeq")
    @SequenceGenerator(name = "educationSeq", sequenceName = "educationSeq", allocationSize = 1)
    @JsonIgnore
    @Column(name = "Id")
    private Long id;

    @Column(name = "PartName")
    private String partName;

    @Column(name = "SchoolName")
    private String schoolName;

    @Column(name = "StartingDate")
    private Date startingDate;

    @Column(name = "GraduationDate")
    private Date graduationDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CurriculumVitaeId",foreignKey = @ForeignKey(name = "education_curriculumVitae_id_fk"))
    private CurriculumVitae curriculumVitae;

}
