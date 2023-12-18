package com.emrecan.appointmentsystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emrecan.appointmentsystem.entities.Appointment;
import com.emrecan.appointmentsystem.entities.enums.Status;

public interface AppointmentDao extends JpaRepository<Appointment, String>{

	Appointment getAppointmentByAppointmentId(String appointmentId);
	List<Appointment> getAllAppointmentsByIsDeleted(boolean isDeleted);
	List<Appointment> getAllAppointmentsByStatusIs(Status status);
	List<Appointment> getAllAppointmentsByIsDeletedFalseAndStatusIs(Status status);
	List<Appointment> getAllAppointmentsByStaffIdAndIsDeletedTrue(String staffId);
	List<Appointment> getAllAppointmentsByStaffIdAndIsDeletedFalse(String staffId);
	List<Appointment> getAllAppointmentsByCustomerIdAndIsDeletedTrue(String customerId);
	List<Appointment> getAllAppointmentsByCustomerIdAndIsDeletedFalse(String customerId);
	List<Appointment> getAllAppointmentsByStaffIdAndIsDeletedFalseAndStatusIs(String staffId, Status status);
	List<Appointment> getAllAppointmentsByCustomerIdAndIsDeletedFalseAndStatusIs(String customerId, Status status);
	
	
}
