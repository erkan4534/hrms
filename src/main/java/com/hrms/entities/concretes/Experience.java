package com.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Experiences")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "experienceSeq")
    @SequenceGenerator(name = "experienceSeq", sequenceName = "experienceSeq", allocationSize = 1)
    @JsonIgnore
    @Column(name = "Id")
    private Long id;

    @Column(name = "FirmName")
    private String firmName;

    @Column(name = "PositionName")
    private String positionName;

    @NotNull
    @Column(name="startingDate")
    private Date startingDate;

    @Column(name="quitDate")
    private Date quitDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CurriculumVitaeId",foreignKey = @ForeignKey(name = "experience_curriculumVitae_id_fk"))
    private CurriculumVitae curriculumVitae;
}
