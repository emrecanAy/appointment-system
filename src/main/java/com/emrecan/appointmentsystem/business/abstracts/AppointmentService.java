package com.emrecan.appointmentsystem.business.abstracts;

import java.util.List;

import com.emrecan.appointmentsystem.business.requests.appointment.CreateAppointmentRequest;
import com.emrecan.appointmentsystem.business.requests.appointment.DeleteAppointmentRequest;
import com.emrecan.appointmentsystem.business.requests.appointment.SetAppointmentStatusRequest;
import com.emrecan.appointmentsystem.business.requests.appointment.UpdateAppointmentRequest;
import com.emrecan.appointmentsystem.business.responses.appointment.GetAllAppointmentsResponse;
import com.emrecan.appointmentsystem.business.responses.appointment.GetAppointmentResponse;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;

public interface AppointmentService {

	DataResult<GetAppointmentResponse> getByAppointmentId(String appointmentId);
	DataResult<List<GetAllAppointmentsResponse>> getAll();
	DataResult<List<GetAllAppointmentsResponse>> getAllDeletedAppointments();
	DataResult<List<GetAllAppointmentsResponse>> getAllDeletedAppointmentsByStaff(String staffId);
	DataResult<List<GetAllAppointmentsResponse>> getAllDeletedAppointmentsByCustomer(String customerId);
	DataResult<List<GetAllAppointmentsResponse>> getAllWaitingAppointments();
	DataResult<List<GetAllAppointmentsResponse>> getAllAcceptedAppointments();
	DataResult<List<GetAllAppointmentsResponse>> getAllDeclinedAppointments();
	DataResult<List<GetAllAppointmentsResponse>> getAllByStaff(String staffId);
	DataResult<List<GetAllAppointmentsResponse>> getAllByCustomer(String customerId);
	DataResult<List<GetAllAppointmentsResponse>> getAllWaitingAppointmentsByStaff(String staffId);
	DataResult<List<GetAllAppointmentsResponse>> getAllAcceptedAppointmentsByStaff(String staffId);
	DataResult<List<GetAllAppointmentsResponse>> getAllDeclinedAppointmentsByStaff(String staffId);
	DataResult<List<GetAllAppointmentsResponse>> getAllWaitingAppointmentsByCustomer(String customerId);
	DataResult<List<GetAllAppointmentsResponse>> getAllAcceptedAppointmentsByCustomer(String customerId);
	DataResult<List<GetAllAppointmentsResponse>> getAllDeclinedAppointmentsByCustomer(String customerId);
	DataResult<List<GetAllAppointmentsResponse>> getAllWaitingAndAcceptedAppointmentsByStaff(String staffId);
	Result add(CreateAppointmentRequest createAppointmentRequest);
	Result update(UpdateAppointmentRequest updateAppointmentRequest);
	Result delete(DeleteAppointmentRequest deleteAppointmentRequest);
	Result setStatusAccepted(SetAppointmentStatusRequest setAppointmentStatusRequest);
	Result setStatusDeclined(SetAppointmentStatusRequest setAppointmentStatusRequest);
	Result setStatusWaiting(SetAppointmentStatusRequest setAppointmentStatusRequest);
	Result setStatusCancelled(SetAppointmentStatusRequest setAppointmentStatusRequest);
	Result checkAppointmentsAndGetTotalEarningByStaff(String staffId);


}
