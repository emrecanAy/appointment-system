package com.emrecan.appointmentsystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emrecan.appointmentsystem.entities.Appointment;
import com.emrecan.appointmentsystem.entities.enums.Status;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface AppointmentDao extends JpaRepository<Appointment, String>{

	Appointment getAppointmentByAppointmentId(String appointmentId);
	List<Appointment> getAllAppointmentsByIsDeletedOrderByAppointmentDateDesc(boolean isDeleted);
	List<Appointment> getAllAppointmentsByStatusIs(Status status);
	List<Appointment> getAllAppointmentsByIsDeletedFalseAndStatusIs(Status status);
	List<Appointment> getAllAppointmentsByStaffIdAndIsDeletedTrue(String staffId);
	List<Appointment> getAllAppointmentsByStaffIdAndIsDeletedFalse(String staffId);
	List<Appointment> getAllAppointmentsByCustomerIdAndIsDeletedTrue(String customerId);
	List<Appointment> getAllAppointmentsByCustomerIdAndIsDeletedFalse(String customerId);
	List<Appointment> getAllAppointmentsByStaffIdAndIsDeletedFalseAndStatusIs(String staffId, Status status);
	List<Appointment> getAllAppointmentsByStaffIdAndIsDeletedFalseAndStatusIsAndStatusIs(String staffId, Status status1, Status status2);
	List<Appointment> getAllAppointmentsByCustomerIdAndIsDeletedFalseAndStatusIs(String customerId, Status status);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Appointment a set a.isDeleted = true where a.appointmentId=:appointmentId")
	void deleteByAppointmentId(@Param("appointmentId") String appointmentId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Appointment a set a.status = 0 where a.appointmentId=:appointmentId")
	void setStatusAccepted(String appointmentId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Appointment a set a.status = 2 where a.appointmentId=:appointmentId")
	void setStatusDeclined(String appointmentId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Appointment a set a.status = 3 where a.appointmentId=:appointmentId")
	void setStatusCancelled(String appointmentId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Appointment a set a.status = 1 where a.appointmentId=:appointmentId")
	void setStatusWaiting(String appointmentId);
	
	
}
