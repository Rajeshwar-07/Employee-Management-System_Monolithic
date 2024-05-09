package com.Techno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Techno.entity.Payroll;

@Repository
public interface PayrollRepo extends JpaRepository<Payroll, Long>{

}
