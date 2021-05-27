package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionDao extends JpaRepository<Position,Long> {
}
