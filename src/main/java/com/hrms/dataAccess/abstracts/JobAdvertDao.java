package com.hrms.dataAccess.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.entities.concretes.JobAdvert;
import com.hrms.entities.dto.JobAdvertGetDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface JobAdvertDao extends JpaRepository<JobAdvert,Long> {

   @Query("SELECT new com.hrms.entities.dto.JobAdvertGetDto (u.employer.firmName,u.position.name,u.openPositionsNumber,u.createDate,u.applyDeadline) FROM JobAdvert u")
   List<JobAdvertGetDto> getAllActivePositionJob();
}
