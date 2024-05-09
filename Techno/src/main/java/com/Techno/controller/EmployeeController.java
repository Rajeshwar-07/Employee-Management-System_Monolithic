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

import com.Techno.entity.Employee;
import com.Techno.entity.LeaveEn;
import com.Techno.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employeeModule")
@Validated
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee emp) {
		return employeeService.saveEmployee(emp);
	}

	@GetMapping("/findById/{id}")
	public Employee findById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}

	@GetMapping("/findAll")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@PutMapping("/update/{id}")
	public Employee updateEmployee(@RequestBody Employee emp, @PathVariable Long id) {
		return employeeService.updateEmployee(emp, id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		return employeeService.deleteEmployee(id);
	}

	@GetMapping("/AllLeavesByEmpId/{employeeId}")
	public List<LeaveEn> findSelectedFieldsByEmployeeId(@PathVariable Long employeeId) {
		return employeeService.getLeavesByEmployeeId(employeeId);
	}
}
