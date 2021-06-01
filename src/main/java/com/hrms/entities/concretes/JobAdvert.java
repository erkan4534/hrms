package com.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "JobAdverts")
public class JobAdvert implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jobAdvertSeq")
    @SequenceGenerator(name = "jobAdvertSeq", sequenceName = "jobAdvertSeq", allocationSize = 1)
    @JsonIgnore
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "employerId",foreignKey = @ForeignKey(name = "jobAdverts_employer_Id_fk"))
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Employer employer;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "positionId",foreignKey = @ForeignKey(name = "jobAdverts_position_Id_fk"))
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Position position;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cityId",foreignKey = @ForeignKey(name = "jobAdverts_city_Id_fk"))
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private City city;

    @PositiveOrZero
    @Column(name = "minSalary")
    private Long minSalary;

    @PositiveOrZero
    @Column(name = "maxSalary")
    private Long maxSalary;

    @Positive
    @NotNull
    @Column(name = "openPositionsNumber")
    private Long openPositionsNumber;

    @Column(name = "createDate")
    @JsonIgnore
    private final LocalDateTime createDate = LocalDateTime.now();

    @Future
    @Column(name = "applyDeadLine")
    private LocalDateTime applyDeadline;

}
