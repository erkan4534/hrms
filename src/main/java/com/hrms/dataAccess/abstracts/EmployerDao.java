package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.Employer;
import com.hrms.entities.dto.EmployerDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface EmployerDao extends JpaRepository<Employer,Long>, JpaSpecificationExecutor<Employer> {
    Employer getByPerson_Email(String email);
}
