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

import com.Techno.entity.LeaveEn;
import com.Techno.service.LeaveService;

@RestController
@RequestMapping("/leaveModule")
@Validated
public class LeaveController {
	
	@Autowired
	LeaveService leaveService;
	
	
	
	@PostMapping("/save")
	public LeaveEn saveLeave(@RequestBody LeaveEn leave) {
		return leaveService.saveLeave(leave);
	}
	
	
	@GetMapping("/findById/{id}")
	public LeaveEn getLeaveById(@PathVariable Long id) {
		return leaveService.getLeaveById(id);
	}
	
	@GetMapping("/findAll")
	public List<LeaveEn> getAllLeave(){
		return leaveService.getAllLeave();
	}
	
	@PutMapping("/update/{id}")
	public LeaveEn updateLeave(@RequestBody LeaveEn leave,@PathVariable Long id) {
		return leaveService.updateLeavee(leave, id);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteLeave(@PathVariable Long id) {
		leaveService.deleteLeave(id);
		return "Delete Successful";
	}
	
}
