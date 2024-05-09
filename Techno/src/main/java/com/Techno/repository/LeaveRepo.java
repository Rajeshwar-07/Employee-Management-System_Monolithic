package com.Techno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Techno.entity.LeaveEn;

@Repository
public interface LeaveRepo extends JpaRepository<LeaveEn, Long>{

	@Query(value = "SELECT * FROM leave_en WHERE leave_en.employee_id = :employeeId", nativeQuery = true)
	List<LeaveEn> findSelectedFieldsByEmployeeId(@Param("employeeId") Long employeeId);


}
