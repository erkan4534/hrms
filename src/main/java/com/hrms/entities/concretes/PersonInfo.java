package com.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class

PersonInfo implements Serializable {

    @Column(name = "Email" ,table = "Persons")
    private String email;

    @Column(name = "Password",table = "Persons")
    private String password;

    @Column(name = "TelNo",table = "Persons")
    private String telNo;
}
