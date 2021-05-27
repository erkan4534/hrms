package com.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Positions")
public class Position implements Serializable {

    @Id
    @Column(name = "Id")
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "positionSeq")
    @SequenceGenerator(name = "positionSeq", sequenceName = "positionSeq", allocationSize = 1)
    private Long id;

    @Column(name = "Name",unique = true)
    private String name;

}
