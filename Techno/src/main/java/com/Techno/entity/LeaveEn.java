package com.Techno.entity;

import java.sql.Date;
import java.time.LocalDate;

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
public class LeaveEn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long leaveRequestId;
	
	@NotBlank(message = "Leave type is required")
    private String leaveType;
	
	@NotNull(message = "Start Date is required")
    private Date startDate;
	
	@NotNull(message = "End Date is required")
    private Date endDate;
	
	@NotBlank(message = "reason is required")
    private String reason;
	
	@NotBlank(message = "leaveStatus is required")
    private String leaveStatus;
    
    
    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name="employee_id")
    private Employee employee;
    
    
    public void setTime(LocalDate localDate) {
    	this.startDate = Date.valueOf(localDate);
    }
    
}
