package com.Techno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Techno.entity.Employee;
import com.Techno.entity.LeaveEn;
import com.Techno.repository.EmployeeRepo;
import com.Techno.repository.LeaveRepo;

import jakarta.validation.Valid;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	LeaveRepo leaveRepo;

	public Employee saveEmployee(@Valid Employee employee) {
		return employeeRepo.save(employee);
	}

	public Employee getEmployeeById(Long id) {
		return employeeRepo.findById(id).get();
	}

	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}

	public Employee updateEmployee(@Valid Employee empNew, Long id) {
		Employee emp = new Employee();
		if(empNew.getEmployeeName()!=null) {
			emp.setEmployeeName(empNew.getEmployeeName());			
		}
		if(empNew.getDepartment()!=null) {
			emp.setDepartment(empNew.getDepartment());			
		}
		if(empNew.getJobTitle()!=null) {
			emp.setJobTitle(empNew.getJobTitle());			
		}
		if(empNew.getMobile()!=null) {
			emp.setMobile(empNew.getMobile());		
		}

		if(empNew.getEmail()!=null) {
			emp.setEmail(empNew.getEmail());		
		}
		
		if(empNew.getDob()!=null) {
			emp.setDob(empNew.getDob());		
		}
		if(empNew.getGender()!=null) {
			emp.setGender(empNew.getGender());		
		}
		if(empNew.getAddress()!=null) {
			emp.setAddress(empNew.getAddress());		
		}
		
		return employeeRepo.save(emp);
	}

	public String deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
		return "Delete Successfull";
	}
	
	
	
	
	public List<LeaveEn> getLeavesByEmployeeId(Long empid){
		return leaveRepo.findSelectedFieldsByEmployeeId(empid);
	}
	
	
}
