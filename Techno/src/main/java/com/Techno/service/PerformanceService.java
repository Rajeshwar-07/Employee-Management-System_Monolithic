package com.Techno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Techno.entity.Performance;
import com.Techno.repository.PerformanceRepo;

import jakarta.validation.Valid;

@Service
public class PerformanceService {

	@Autowired
	PerformanceRepo performanceRepo;

	public Performance savePerformance(@Valid Performance performance) {
		return performanceRepo.save(performance);
	}

	public Performance getPerformanceById(Long id) {
		return performanceRepo.findById(id).get();
	}

	public List<Performance> getAllPerformances() {
		return performanceRepo.findAll();
	}

	public Performance updatePerformance(Long id, Performance updatedPerformance) {
		Performance existingPerformance = performanceRepo.findById(id).get();
		existingPerformance.setGoalsAndObjectives(updatedPerformance.getGoalsAndObjectives());
		existingPerformance.setMetricsAndTargets(updatedPerformance.getMetricsAndTargets());
		existingPerformance.setEvaluationScores(updatedPerformance.getEvaluationScores());
		existingPerformance.setOverallPerformanceRating(updatedPerformance.getOverallPerformanceRating());
		existingPerformance.setFeedbackAndComments(updatedPerformance.getFeedbackAndComments());

		return performanceRepo.save(existingPerformance);
	}

	public String deletePerformance(Long performanceId) {
		performanceRepo.deleteById(performanceId);
		return "Delete Successfull";
	}

}
