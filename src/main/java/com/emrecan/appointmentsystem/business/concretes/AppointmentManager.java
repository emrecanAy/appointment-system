package com.emrecan.appointmentsystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrecan.appointmentsystem.business.abstracts.AppointmentService;
import com.emrecan.appointmentsystem.business.constants.Messages;
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
	
	@Autowired
	public AppointmentManager(AppointmentDao _appointmentDao) {
		this._appointmentDao = _appointmentDao;
	}

	@Override
	public DataResult<Appointment> getByAppointmentId(String appointmentId) {
		return new SuccessDataResult<Appointment>(this._appointmentDao.getAppointmentByAppointmentId(appointmentId), Messages.EntityListed);
	}

	@Override
	public DataResult<List<Appointment>> getAll() {
		return new SuccessDataResult<List<Appointment>>(this._appointmentDao.getAllAppointmentsByIsDeleted(false), Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<Appointment>> getAllDeletedAppointments() {
		return new SuccessDataResult<List<Appointment>>(this._appointmentDao.getAllAppointmentsByIsDeleted(true), Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<Appointment>> getAllDeletedAppointmentsByStaff(String staffId) {
		return new SuccessDataResult<List<Appointment>>(this._appointmentDao.getAllAppointmentsByStaffIdAndIsDeletedTrue(staffId), Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<Appointment>> getAllDeletedAppointmentsByCustomer(String customerId) {
		return new SuccessDataResult<List<Appointment>>(this._appointmentDao.getAllAppointmentsByCustomerIdAndIsDeletedTrue(customerId), Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<Appointment>> getAllWaitingAppointments() {
		return new SuccessDataResult<List<Appointment>>(this._appointmentDao.getAllAppointmentsByStatusIs(Status.WAITING), Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<Appointment>> getAllAcceptedAppointments() {
		return new SuccessDataResult<List<Appointment>>(this._appointmentDao.getAllAppointmentsByStatusIs(Status.ACCEPTED), Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<Appointment>> getAllDeclinedAppointments() {
		return new SuccessDataResult<List<Appointment>>(this._appointmentDao.getAllAppointmentsByStatusIs(Status.DECLINED), Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<Appointment>> getAllByStaff(String staffId) {
		return new SuccessDataResult<List<Appointment>>(this._appointmentDao.getAllAppointmentsByStaffIdAndIsDeletedFalse(staffId), Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<Appointment>> getAllByCustomer(String customerId) {
		return new SuccessDataResult<List<Appointment>>(this._appointmentDao.getAllAppointmentsByCustomerIdAndIsDeletedFalse(customerId), Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<Appointment>> getAllWaitingAppointmentsByStaff(String staffId) {
		return new SuccessDataResult<List<Appointment>>(this._appointmentDao.getAllAppointmentsByStaffIdAndIsDeletedFalseAndStatusIs(staffId, Status.WAITING), Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<Appointment>> getAllAcceptedAppointmentsByStaff(String staffId) {
		return new SuccessDataResult<List<Appointment>>(this._appointmentDao.getAllAppointmentsByStaffIdAndIsDeletedFalseAndStatusIs(staffId, Status.ACCEPTED), Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<Appointment>> getAllDeclinedAppointmentsByStaff(String staffId) {
		return new SuccessDataResult<List<Appointment>>(this._appointmentDao.getAllAppointmentsByStaffIdAndIsDeletedFalseAndStatusIs(staffId, Status.DECLINED), Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<Appointment>> getAllWaitingAppointmentsByCustomer(String customerId) {
		return new SuccessDataResult<List<Appointment>>(this._appointmentDao.getAllAppointmentsByCustomerIdAndIsDeletedFalseAndStatusIs(customerId, Status.WAITING), Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<Appointment>> getAllAcceptedAppointmentsByCustomer(String customerId) {
		return new SuccessDataResult<List<Appointment>>(this._appointmentDao.getAllAppointmentsByCustomerIdAndIsDeletedFalseAndStatusIs(customerId, Status.ACCEPTED), Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<Appointment>> getAllDeclinedAppointmentsByCustomer(String customerId) {
		return new SuccessDataResult<List<Appointment>>(this._appointmentDao.getAllAppointmentsByCustomerIdAndIsDeletedFalseAndStatusIs(customerId, Status.DECLINED), Messages.EntitiesListed);
	}

	@Override
	public Result add(Appointment appointment) {
		this._appointmentDao.save(appointment);
		return new SuccessResult(Messages.EntityAdded);
	}

	@Override
	public Result update(Appointment appointment) {
		this._appointmentDao.save(appointment);
		return new SuccessResult(Messages.EntityUpdated);
	}

	@Override
	public Result delete(Appointment appointment) {
		appointment.setDeleted(true);
		this._appointmentDao.save(appointment);
		return new SuccessResult(Messages.EntityDeleted);
		
	}

	@Override
	public Result setStatusAccepted(Appointment appointment) {
		appointment.setStatus(Status.ACCEPTED);
		this._appointmentDao.save(appointment);
		return new SuccessResult(Messages.EntityUpdated);
	}

	@Override
	public Result setStatusDeclined(Appointment appointment) {
		appointment.setStatus(Status.DECLINED);
		this._appointmentDao.save(appointment);
		return new SuccessResult(Messages.EntityUpdated);
	}

	@Override
	public Result setStatusWaiting(Appointment appointment) {
		appointment.setStatus(Status.WAITING);
		this._appointmentDao.save(appointment);
		return new SuccessResult(Messages.EntityUpdated);
	}

	
	
}
