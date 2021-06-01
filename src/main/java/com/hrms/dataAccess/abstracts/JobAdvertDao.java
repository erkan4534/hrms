package com.hrms.dataAccess.abstracts;

import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.JobAdvert;
import com.hrms.entities.dto.JobAdvertGetDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;
import java.util.List;

public interface JobAdvertDao extends JpaRepository<JobAdvert,Long> {

   @Query("SELECT new com.hrms.entities.dto.JobAdvertGetDto (u.employer.firmName,u.position.name,u.openPositionsNumber,u.createDate,u.applyDeadline) FROM JobAdvert u where u.status=1")
   List<JobAdvertGetDto> getAllActivePositionJob();

   @Query("SELECT new com.hrms.entities.dto.JobAdvertGetDto (u.employer.firmName,u.position.name,u.openPositionsNumber,u.createDate,u.applyDeadline) FROM JobAdvert u where u.status=1 order by u.applyDeadline desc")
   List<JobAdvertGetDto> getAllActivePositionJobOrderByApplyDeadline();

   @Query("SELECT new com.hrms.entities.dto.JobAdvertGetDto (u.employer.firmName,u.position.name,u.openPositionsNumber,u.createDate,u.applyDeadline) FROM JobAdvert u where u.employer.id=:employerId and u.status=1 order by u.applyDeadline desc")
   List<JobAdvertGetDto> getActivePositionJobForOneFirm(@Param("employerId") Long employerId);

   @Transactional
   @Modifying
   @Query("update JobAdvert u set u.status=0 where u.id =:jobAdvertId")
   Integer jobAdvertStatusSetPassive(@Param("jobAdvertId")  Long jobAdvertId);

   @Transactional
   @Modifying
   @Query("update JobAdvert u set u.status=1 where u.id =:jobAdvertId")
   Integer jobAdvertStatusSetActive(@Param("jobAdvertId")  Long jobAdvertId);
}
