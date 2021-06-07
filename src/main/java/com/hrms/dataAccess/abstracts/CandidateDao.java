package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateDao extends JpaRepository<Candidate,Long> {
    Candidate getByPerson_Email(String email);
    Candidate getByNationalId(String nationalId);
}
