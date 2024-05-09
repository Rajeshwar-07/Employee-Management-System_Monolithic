package com.Techno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Techno.entity.LeaveEn;
import com.Techno.repository.LeaveRepo;

import jakarta.validation.Valid;

@Service
public class LeaveService {

	@Autowired
	LeaveRepo leaveRepo;

	public LeaveEn saveLeave(@Valid LeaveEn leave) {
		return leaveRepo.save(leave);
	}

	public LeaveEn getLeaveById(Long id) {
		return leaveRepo.findById(id).get();
	}

	public List<LeaveEn> getAllLeave() {
		return leaveRepo.findAll();
	}

	public LeaveEn updateLeavee(LeaveEn updateLeave, Long id) {
		LeaveEn le = new LeaveEn();

		if (le.getLeaveRequestId() != null) {
			le.setLeaveRequestId(updateLeave.getLeaveRequestId());
		}
		if (le.getLeaveType() != null) {
			le.setLeaveType(updateLeave.getLeaveType());
		}
		if (le.getStartDate() != null) {
			le.setStartDate(updateLeave.getStartDate());
		}
		if (le.getEndDate() != null) {
			le.setEndDate(updateLeave.getEndDate());
		}
		if (le.getReason() != null) {
			le.setReason(updateLeave.getReason());
		}

		return leaveRepo.save(le);
	}

	public String deleteLeave(Long id) {
		leaveRepo.deleteById(id);
		return "Delete Successfull";
	}

}
