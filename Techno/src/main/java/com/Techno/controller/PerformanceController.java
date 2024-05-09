package com.Techno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Techno.entity.Performance;
import com.Techno.service.PerformanceService;

@RestController
@RequestMapping("/performanceModule")
@Validated
public class PerformanceController {

	@Autowired
	PerformanceService performanceService;

	
	
	@PostMapping("/save")
	public Performance createPerformance(@RequestBody Performance performance) {
		return performanceService.savePerformance(performance);
	}
	
	
	@GetMapping("/findById/{id}")
	public Performance getPerformanceById(@PathVariable Long id) {
		return performanceService.getPerformanceById(id);
	}
	
	
	@GetMapping("/findAll")
	public List<Performance> getAllPerformances() {
		return performanceService.getAllPerformances();
	}

	


	@PutMapping("/update/{id}")
	public Performance updatePerformance(@PathVariable Long id, @RequestBody Performance updatedPerformance) {
		return performanceService.updatePerformance(id, updatedPerformance);
	}

	@DeleteMapping("/delete/{id}")
	public String deletePerformance(@PathVariable Long id) {
		performanceService.deletePerformance(id);
		return "Delete Successfull";
	}
}
