package com.emrecan.appointmentsystem.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emrecan.appointmentsystem.business.abstracts.AppointmentService;
import com.emrecan.appointmentsystem.business.requests.appointment.CreateAppointmentRequest;
import com.emrecan.appointmentsystem.business.requests.appointment.DeleteAppointmentRequest;
import com.emrecan.appointmentsystem.business.requests.appointment.SetAppointmentStatusRequest;
import com.emrecan.appointmentsystem.business.requests.appointment.UpdateAppointmentRequest;
import com.emrecan.appointmentsystem.business.responses.appointment.GetAllAppointmentsResponse;
import com.emrecan.appointmentsystem.business.responses.appointment.GetAppointmentResponse;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentsController {

	private final AppointmentService _appointmentService;

	@Autowired
	public AppointmentsController(AppointmentService _appointmentService) {
		this._appointmentService = _appointmentService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<GetAllAppointmentsResponse>>> getAll(){
		DataResult<List<GetAllAppointmentsResponse>> staffs = this._appointmentService.getAll(); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(staffs, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getalldeleted")
	public ResponseEntity<DataResult<List<GetAllAppointmentsResponse>>> getAllDeleted(){
		DataResult<List<GetAllAppointmentsResponse>> staffs = this._appointmentService.getAllDeletedAppointments();
		if(staffs.isSuccess()) {
			return new ResponseEntity<>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallwaiting")
	public ResponseEntity<DataResult<List<GetAllAppointmentsResponse>>> getAllWaitingAppointments(){
		DataResult<List<GetAllAppointmentsResponse>> staffs = this._appointmentService.getAllWaitingAppointments(); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallwaiting/staff/{staffId}")
	public ResponseEntity<DataResult<List<GetAllAppointmentsResponse>>> getAllWaitingAppointmentsByStaff(@PathVariable(name = "staffId") String staffId){
		DataResult<List<GetAllAppointmentsResponse>> staffs = this._appointmentService.getAllWaitingAppointmentsByStaff(staffId); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallwaiting/customer/{customerId}")
	public ResponseEntity<DataResult<List<GetAllAppointmentsResponse>>> getAllWaitingAppointmentsByCustomer(@PathVariable(name = "customerId") String customerId){
		DataResult<List<GetAllAppointmentsResponse>> staffs = this._appointmentService.getAllWaitingAppointmentsByCustomer(customerId); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallaccepted/")
	public ResponseEntity<DataResult<List<GetAllAppointmentsResponse>>> getAllAcceptedAppointments(){
		DataResult<List<GetAllAppointmentsResponse>> staffs = this._appointmentService.getAllAcceptedAppointments(); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallaccepted/{staffId}")
	public ResponseEntity<DataResult<List<GetAllAppointmentsResponse>>> getAllAcceptedAppointmentsByStaff(@PathVariable(name = "staffId") String staffId){
		DataResult<List<GetAllAppointmentsResponse>> staffs = this._appointmentService.getAllAcceptedAppointmentsByStaff(staffId); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallaccepted/customer/{customerId}")
	public ResponseEntity<DataResult<List<GetAllAppointmentsResponse>>> getAllAcceptedAppointmentsByCustomer(@PathVariable(name = "customerId") String customerId){
		DataResult<List<GetAllAppointmentsResponse>> staffs = this._appointmentService.getAllAcceptedAppointmentsByCustomer(customerId); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getalldeclined")
	public ResponseEntity<DataResult<List<GetAllAppointmentsResponse>>> getAllDeclinedAppointments(){
		DataResult<List<GetAllAppointmentsResponse>> staffs = this._appointmentService.getAllDeclinedAppointments(); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getalldeclined/{staffId}")
	public ResponseEntity<DataResult<List<GetAllAppointmentsResponse>>> getAllDeclinedAppointmentsByStaff(@PathVariable(name = "staffId") String staffId){
		DataResult<List<GetAllAppointmentsResponse>> staffs = this._appointmentService.getAllDeclinedAppointmentsByStaff(staffId); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getalldeclined/customer/{customerId}")
	public ResponseEntity<DataResult<List<GetAllAppointmentsResponse>>> getAllDeclinedAppointmentsByCustomer(@PathVariable(name = "customerId") String customerId){
		DataResult<List<GetAllAppointmentsResponse>> staffs = this._appointmentService.getAllDeclinedAppointmentsByCustomer(customerId); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(staffs, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getallwaitingandaccepted/staff/{staffId}")
	public ResponseEntity<DataResult<List<GetAllAppointmentsResponse>>> getAllWaitingAndAcceptedAppointmentsByStaff(@PathVariable(name = "staffId") String staffId){
		DataResult<List<GetAllAppointmentsResponse>> staffs = this._appointmentService.getAllWaitingAndAcceptedAppointmentsByStaff(staffId);
		if(staffs.isSuccess()) {
			return new ResponseEntity<>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(staffs, HttpStatus.NOT_FOUND);
		}
	}


	@GetMapping("/{appointmentId}")
	public ResponseEntity<DataResult<GetAppointmentResponse>> getById(@PathVariable(name = "appointmentId") String appointmentId) {
		DataResult<GetAppointmentResponse> appointment = this._appointmentService.getByAppointmentId(appointmentId);
		if(appointment.isSuccess()) {
			return new ResponseEntity<>(appointment, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(appointment, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/staff/{staffId}")
	public ResponseEntity<DataResult<List<GetAllAppointmentsResponse>>> getAllByStaff(@PathVariable(name = "staffId") String staffId) {
		DataResult<List<GetAllAppointmentsResponse>> appointment = this._appointmentService.getAllByStaff(staffId);
		if(appointment.isSuccess()) {
			return new ResponseEntity<>(appointment, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(appointment, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<DataResult<List<GetAllAppointmentsResponse>>> getAllByCustomer(@PathVariable(name = "customerId") String customerId) {
		DataResult<List<GetAllAppointmentsResponse>> appointment = this._appointmentService.getAllByCustomer(customerId);
		if(appointment.isSuccess()) {
			return new ResponseEntity<>(appointment, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(appointment, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody() CreateAppointmentRequest createAppointmentRequest) {
		Result result = this._appointmentService.add(createAppointmentRequest); 
		if(result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Result> update(@RequestBody UpdateAppointmentRequest updateAppointmentRequest) {
		Result result = this._appointmentService.update(updateAppointmentRequest); 
		if(result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody DeleteAppointmentRequest deleteAppointmentRequest) {
		Result result = this._appointmentService.delete(deleteAppointmentRequest); 
		if(result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/setstatusaccepted")
	public ResponseEntity<Result> setStatusAccepted(@RequestBody SetAppointmentStatusRequest setAppointmentStatusRequest) {
		Result result = this._appointmentService.setStatusAccepted(setAppointmentStatusRequest); 
		if(result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/setstatuswaiting")
	public ResponseEntity<Result> setStatusWaiting(@RequestBody SetAppointmentStatusRequest setAppointmentStatusRequest) {
		Result result = this._appointmentService.setStatusWaiting(setAppointmentStatusRequest); 
		if(result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/setstatusdeclined")
	public ResponseEntity<Result> setStatusDeclined(@RequestBody SetAppointmentStatusRequest setAppointmentStatusRequest) {
		Result result = this._appointmentService.setStatusDeclined(setAppointmentStatusRequest); 
		if(result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/setstatuscancelled")
	public ResponseEntity<Result> setStatusCancelled(@RequestBody SetAppointmentStatusRequest setAppointmentStatusRequest) {
		Result result = this._appointmentService.setStatusCancelled(setAppointmentStatusRequest);
		if(result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/check-total-earning/{staffId}")
	public ResponseEntity<Result> checkAppointmentsAndGetTotalEarningByStaff(@PathVariable(name = "staffId") String staffId){
		Result result = this._appointmentService.checkAppointmentsAndGetTotalEarningByStaff(staffId);
		if(result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
