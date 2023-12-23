package com.emrecan.appointmentsystem.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrecan.appointmentsystem.business.abstracts.AppointmentService;
import com.emrecan.appointmentsystem.business.constants.Messages;
import com.emrecan.appointmentsystem.business.requests.appointment.CreateAppointmentRequest;
import com.emrecan.appointmentsystem.business.requests.appointment.DeleteAppointmentRequest;
import com.emrecan.appointmentsystem.business.requests.appointment.SetAppointmentStatusRequest;
import com.emrecan.appointmentsystem.business.requests.appointment.UpdateAppointmentRequest;
import com.emrecan.appointmentsystem.business.responses.appointment.GetAllAppointmentsResponse;
import com.emrecan.appointmentsystem.business.responses.appointment.GetAppointmentResponse;
import com.emrecan.appointmentsystem.core.utilities.mappers.ModelMapperService;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessDataResult;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessResult;
import com.emrecan.appointmentsystem.dataAccess.abstracts.AppointmentDao;
import com.emrecan.appointmentsystem.entities.Appointment;
import com.emrecan.appointmentsystem.entities.enums.Status;

@Service
public class AppointmentManager implements AppointmentService{

	private final AppointmentDao _appointmentDao;
	private final ModelMapperService _modelMapperService;
	
	@Autowired
	public AppointmentManager(AppointmentDao appointmentDao, ModelMapperService modelMapperService) {
		this._appointmentDao = appointmentDao;
		this._modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<GetAppointmentResponse> getByAppointmentId(String appointmentId) {
		Appointment appointment = this._appointmentDao.getAppointmentByAppointmentId(appointmentId);
		GetAppointmentResponse appointmentResponse = this._modelMapperService.forResponse().map(appointment, GetAppointmentResponse.class);
		return new SuccessDataResult<>(appointmentResponse, Messages.EntityListed);
	}

	@Override
	public DataResult<List<GetAllAppointmentsResponse>> getAll() {
		List<Appointment> appointments = this._appointmentDao.getAllAppointmentsByIsDeleted(false);
		List<GetAllAppointmentsResponse> appointmentsResponse = appointments.stream().map(appointment->this._modelMapperService.forResponse().map(appointment, GetAllAppointmentsResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<>(appointmentsResponse, Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<GetAllAppointmentsResponse>> getAllDeletedAppointments() {
		List<Appointment> appointments = this._appointmentDao.getAllAppointmentsByIsDeleted(true);
		List<GetAllAppointmentsResponse> appointmentsResponse = appointments.stream().map(appointment->this._modelMapperService.forResponse().map(appointment, GetAllAppointmentsResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<>(appointmentsResponse, Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<GetAllAppointmentsResponse>> getAllDeletedAppointmentsByStaff(String staffId) {
		List<Appointment> appointments = this._appointmentDao.getAllAppointmentsByStaffIdAndIsDeletedTrue(staffId);
		List<GetAllAppointmentsResponse> appointmentsResponse = appointments.stream().map(appointment->this._modelMapperService.forResponse().map(appointment, GetAllAppointmentsResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<>(appointmentsResponse, Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<GetAllAppointmentsResponse>> getAllDeletedAppointmentsByCustomer(String customerId) {
		List<Appointment> appointments = this._appointmentDao.getAllAppointmentsByCustomerIdAndIsDeletedTrue(customerId);
		List<GetAllAppointmentsResponse> appointmentsResponse = appointments.stream().map(appointment->this._modelMapperService.forResponse().map(appointment, GetAllAppointmentsResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<>(appointmentsResponse, Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<GetAllAppointmentsResponse>> getAllWaitingAppointments() {
		List<Appointment> appointments = this._appointmentDao.getAllAppointmentsByStatusIs(Status.WAITING);
		List<GetAllAppointmentsResponse> appointmentsResponse = appointments.stream().map(appointment->this._modelMapperService.forResponse().map(appointment, GetAllAppointmentsResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<>(appointmentsResponse, Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<GetAllAppointmentsResponse>> getAllAcceptedAppointments() {
		List<Appointment> appointments = this._appointmentDao.getAllAppointmentsByStatusIs(Status.ACCEPTED);
		List<GetAllAppointmentsResponse> appointmentsResponse = appointments.stream().map(appointment->this._modelMapperService.forResponse().map(appointment, GetAllAppointmentsResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<>(appointmentsResponse, Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<GetAllAppointmentsResponse>> getAllDeclinedAppointments() {
		List<Appointment> appointments = this._appointmentDao.getAllAppointmentsByStatusIs(Status.DECLINED);
		List<GetAllAppointmentsResponse> appointmentsResponse = appointments.stream().map(appointment->this._modelMapperService.forResponse().map(appointment, GetAllAppointmentsResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<>(appointmentsResponse, Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<GetAllAppointmentsResponse>> getAllByStaff(String staffId) {
		List<Appointment> appointments = this._appointmentDao.getAllAppointmentsByStaffIdAndIsDeletedFalse(staffId);
		List<GetAllAppointmentsResponse> appointmentsResponse = appointments.stream().map(appointment->this._modelMapperService.forResponse().map(appointment, GetAllAppointmentsResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<>(appointmentsResponse, Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<GetAllAppointmentsResponse>> getAllByCustomer(String customerId) {
		List<Appointment> appointments = this._appointmentDao.getAllAppointmentsByCustomerIdAndIsDeletedFalse(customerId);
		List<GetAllAppointmentsResponse> appointmentsResponse = appointments.stream().map(appointment->this._modelMapperService.forResponse().map(appointment, GetAllAppointmentsResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<>(appointmentsResponse, Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<GetAllAppointmentsResponse>> getAllWaitingAppointmentsByStaff(String staffId) {
		List<Appointment> appointments = this._appointmentDao.getAllAppointmentsByStaffIdAndIsDeletedFalseAndStatusIs(staffId, Status.WAITING);
		List<GetAllAppointmentsResponse> appointmentsResponse = appointments.stream().map(appointment->this._modelMapperService.forResponse().map(appointment, GetAllAppointmentsResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<>(appointmentsResponse, Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<GetAllAppointmentsResponse>> getAllAcceptedAppointmentsByStaff(String staffId) {
		List<Appointment> appointments = this._appointmentDao.getAllAppointmentsByStaffIdAndIsDeletedFalseAndStatusIs(staffId, Status.ACCEPTED);
		List<GetAllAppointmentsResponse> appointmentsResponse = appointments.stream().map(appointment->this._modelMapperService.forResponse().map(appointment, GetAllAppointmentsResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<>(appointmentsResponse, Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<GetAllAppointmentsResponse>> getAllDeclinedAppointmentsByStaff(String staffId) {
		List<Appointment> appointments = this._appointmentDao.getAllAppointmentsByStaffIdAndIsDeletedFalseAndStatusIs(staffId, Status.DECLINED);
		List<GetAllAppointmentsResponse> appointmentsResponse = appointments.stream().map(appointment->this._modelMapperService.forResponse().map(appointment, GetAllAppointmentsResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<>(appointmentsResponse, Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<GetAllAppointmentsResponse>> getAllWaitingAppointmentsByCustomer(String customerId) {
		List<Appointment> appointments = this._appointmentDao.getAllAppointmentsByCustomerIdAndIsDeletedFalseAndStatusIs(customerId, Status.WAITING);
		List<GetAllAppointmentsResponse> appointmentsResponse = appointments.stream().map(appointment->this._modelMapperService.forResponse().map(appointment, GetAllAppointmentsResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<>(appointmentsResponse, Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<GetAllAppointmentsResponse>> getAllAcceptedAppointmentsByCustomer(String customerId) {
		List<Appointment> appointments = this._appointmentDao.getAllAppointmentsByCustomerIdAndIsDeletedFalseAndStatusIs(customerId, Status.ACCEPTED);
		List<GetAllAppointmentsResponse> appointmentsResponse = appointments.stream().map(appointment->this._modelMapperService.forResponse().map(appointment, GetAllAppointmentsResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<>(appointmentsResponse, Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<GetAllAppointmentsResponse>> getAllDeclinedAppointmentsByCustomer(String customerId) {
		List<Appointment> appointments = this._appointmentDao.getAllAppointmentsByCustomerIdAndIsDeletedFalseAndStatusIs(customerId, Status.DECLINED);
		List<GetAllAppointmentsResponse> appointmentsResponse = appointments.stream().map(appointment->this._modelMapperService.forResponse().map(appointment, GetAllAppointmentsResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<>(appointmentsResponse, Messages.EntitiesListed);
	}

	@Override
	public Result add(CreateAppointmentRequest createAppointmentRequest) {
		Appointment appointment = this._modelMapperService.forRequest().map(createAppointmentRequest, Appointment.class);
		this._appointmentDao.save(appointment);
		return new SuccessResult(Messages.EntityAdded);
	}

	@Override
	public Result update(UpdateAppointmentRequest updateAppointmentRequest) {
		Appointment appointment = this._modelMapperService.forRequest().map(updateAppointmentRequest, Appointment.class);
		this._appointmentDao.save(appointment);
		return new SuccessResult(Messages.EntityUpdated);
	}

	@Override
	public Result delete(DeleteAppointmentRequest deleteAppointmentRequest) {
		Appointment appointment = this._modelMapperService.forRequest().map(deleteAppointmentRequest, Appointment.class);
		appointment.setDeleted(true);
		this._appointmentDao.save(appointment);
		return new SuccessResult(Messages.EntityDeleted);
		
	}

	@Override
	public Result setStatusAccepted(SetAppointmentStatusRequest setAppointmentStatusRequest) {
		Appointment appointment = this._modelMapperService.forRequest().map(setAppointmentStatusRequest, Appointment.class);
		appointment.setStatus(Status.ACCEPTED);
		this._appointmentDao.save(appointment);
		return new SuccessResult(Messages.EntityUpdated);
	}

	@Override
	public Result setStatusDeclined(SetAppointmentStatusRequest setAppointmentStatusRequest) {
		Appointment appointment = this._modelMapperService.forRequest().map(setAppointmentStatusRequest, Appointment.class);
		appointment.setStatus(Status.DECLINED);
		this._appointmentDao.save(appointment);
		return new SuccessResult(Messages.EntityUpdated);
	}

	@Override
	public Result setStatusWaiting(SetAppointmentStatusRequest setAppointmentStatusRequest) {
		Appointment appointment = this._modelMapperService.forRequest().map(setAppointmentStatusRequest, Appointment.class);
		appointment.setStatus(Status.WAITING);
		this._appointmentDao.save(appointment);
		return new SuccessResult(Messages.EntityUpdated);
	}

	@Override
	public Result setStatusCancelled(SetAppointmentStatusRequest setAppointmentStatusRequest) {
		Appointment appointment = this._modelMapperService.forRequest().map(setAppointmentStatusRequest, Appointment.class);
		appointment.setStatus(Status.CANCELLED);
		this._appointmentDao.save(appointment);
		return new SuccessResult(Messages.EntityUpdated);
	}


}
