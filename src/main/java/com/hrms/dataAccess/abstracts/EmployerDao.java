package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.Employer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmployerDao extends JpaRepository<Employer,Long>, JpaSpecificationExecutor<Employer> {
    Employer getByPerson_Email(String email);
}
