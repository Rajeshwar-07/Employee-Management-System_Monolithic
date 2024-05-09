package com.Techno.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Performance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long performanceId;
	@NotBlank(message = "Goals and objectives are required")
	private String goalsAndObjectives;

	@NotBlank(message = "Metrics and targets are required")
	private String metricsAndTargets;

	@NotNull(message = "Evaluation scores are required")
	private double evaluationScores;

	@NotBlank(message = "Overall performance rating is required")
	private String overallPerformanceRating;
	private String feedbackAndComments;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "employee_id")
	private Employee employee;
}
