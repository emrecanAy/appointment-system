package com.emrecan.appointmentsystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emrecan.appointmentsystem.entities.Staff;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface StaffDao extends JpaRepository<Staff, String>{

	List<Staff> getAllByIsDeleted(boolean isDeleted);
	Staff getStaffByStaffId(String staffId);
	Staff getStaffByEmail(String email);
	Staff getStaffByEmailAndPassword(String email, String password);
	List<Staff> findByStaffCareServices_CareService_CareServiceId(String careServiceId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Staff s set s.isDeleted = true where s.staffId=:staffId")
	void deleteByStaffId(@Param("staffId") String staffId);
}
