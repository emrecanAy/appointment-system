package com.emrecan.appointmentsystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emrecan.appointmentsystem.entities.Admin;

public interface AdminDao extends JpaRepository<Admin, String>{

	Admin getAdminByAdminId(String adminId);
	List<Admin> getAllAdminsByIsDeletedFalse();
	
}
