package com.emrecan.appointmentsystem.business.abstracts;

import java.util.List;

import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.entities.Appointment;

public interface AppointmentService {

	DataResult<Appointment> getByAppointmentId(String appointmentId);
	DataResult<List<Appointment>> getAll();//
	DataResult<List<Appointment>> getAllDeletedAppointments();//
	DataResult<List<Appointment>> getAllDeletedAppointmentsByStaff();//
	DataResult<List<Appointment>> getAllDeletedAppointmentsByCustomer();//
	DataResult<List<Appointment>> getAllWaitingAppointments();//
	DataResult<List<Appointment>> getAllAcceptedAppointments();//
	DataResult<List<Appointment>> getAllDeclinedAppointments();//
	DataResult<List<Appointment>> getAllByStaff(String staffId);//
	DataResult<List<Appointment>> getAllByCustomer(String customerId);//
	DataResult<List<Appointment>> getAllWaitingAppointmentsByStaff(String staffId);//
	DataResult<List<Appointment>> getAllAcceptedAppointmentsByStaff(String staffId);//
	DataResult<List<Appointment>> getAllDeclinedAppointmentsByStaff(String staffId);//
	DataResult<List<Appointment>> getAllWaitingAppointmentsByCustomer(String customerId);
	DataResult<List<Appointment>> getAllAcceptedAppointmentsByCustomer(String customerId);
	DataResult<List<Appointment>> getAllDeclinedAppointmentsByCustomer(String customerId);
	Result add(Appointment appointment);
	Result update(Appointment appointment);
	Result delete(Appointment appointment);
	
}
