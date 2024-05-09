package com.Techno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Techno.entity.Performance;

@Repository
public interface PerformanceRepo extends JpaRepository<Performance, Long>{

}
