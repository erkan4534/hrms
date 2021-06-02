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
    @JoinColumn(name = "EmployerId",foreignKey = @ForeignKey(name = "jobAdverts_employer_id_fk"))
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Employer employer;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "PositionId",foreignKey = @ForeignKey(name = "jobAdverts_position_id_fk"))
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Position position;

    @NotNull
    @Column(name = "Description")
    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CityId",foreignKey = @ForeignKey(name = "jobAdverts_city_id_fk"))
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private City city;

    @NotNull
    @Column(name = "Status")
    private Integer status=Integer.valueOf(1);

    @PositiveOrZero
    @Column(name = "MinSalary")
    private Long minSalary;

    @PositiveOrZero
    @Column(name = "MaxSalary")
    private Long maxSalary;

    @Positive
    @NotNull
    @Column(name = "OpenPositionsNumber")
    private Long openPositionsNumber;

    @Column(name = "CreateDate")
    @JsonIgnore
    private final LocalDateTime createDate = LocalDateTime.now();

    @Future
    @Column(name = "ApplyDeadLine")
    private LocalDateTime applyDeadline;

}
