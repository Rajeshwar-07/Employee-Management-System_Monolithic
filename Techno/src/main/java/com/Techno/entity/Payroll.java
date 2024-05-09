package com.Techno.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Payroll {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long payrollId;

	@NotNull(message = "Basic salary is required")
	@Positive(message = "Basic salary must be positive")
	private double basicSalary;

	@NotNull(message = "Allowances are required")
	@Positive(message = "Allowances must be positive")
	private double allowances;

	@NotNull(message = "Deductions are required")
	@Positive(message = "Deductions must be positive")
	private double deductions;


	private double netSalary;
	private String payrollPeriod;
	private String paymentMethod;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "employee_id")
	private Employee employee;
}
