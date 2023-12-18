package com.emrecan.appointmentsystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emrecan.appointmentsystem.entities.Staff;

public interface StaffDao extends JpaRepository<Staff, String>{

	List<Staff> getAllByIsDeleted(boolean isDeleted);
	Staff getStaffByStaffId(String staffId);
	Staff getStaffByEmail(String staffId);
}
