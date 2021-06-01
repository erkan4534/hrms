package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.JobAdvert;
import com.hrms.entities.dto.JobAdvertGetDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobAdvertDao extends JpaRepository<JobAdvert,Long> {

   @Query("SELECT new com.hrms.entities.dto.JobAdvertGetDto (u.employer.firmName,u.position.name,u.openPositionsNumber,u.createDate,u.applyDeadline) FROM JobAdvert u")
   List<JobAdvertGetDto> getAllActivePositionJob();

   @Query("SELECT new com.hrms.entities.dto.JobAdvertGetDto (u.employer.firmName,u.position.name,u.openPositionsNumber,u.createDate,u.applyDeadline) FROM JobAdvert u order by u.applyDeadline desc")
   List<JobAdvertGetDto> getAllActivePositionJobOrderByApplyDeadline();

   @Query("SELECT new com.hrms.entities.dto.JobAdvertGetDto (u.employer.firmName,u.position.name,u.openPositionsNumber,u.createDate,u.applyDeadline) FROM JobAdvert u where u.employer.id=:employerId order by u.applyDeadline desc")
   List<JobAdvertGetDto> getActivePositionJobForOneFirm(@Param("employerId") Long employerId);

}
