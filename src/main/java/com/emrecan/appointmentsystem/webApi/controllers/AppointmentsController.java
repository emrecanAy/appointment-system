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
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.entities.Appointment;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentsController {

	private final AppointmentService _appointmentService;

	@Autowired
	public AppointmentsController(AppointmentService _appointmentService) {
		this._appointmentService = _appointmentService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<Appointment>>> getAll(){
		DataResult<List<Appointment>> staffs = this._appointmentService.getAll(); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<DataResult<List<Appointment>>>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<List<Appointment>>>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallwaiting")
	public ResponseEntity<DataResult<List<Appointment>>> getAllWaitingAppointments(){
		DataResult<List<Appointment>> staffs = this._appointmentService.getAllWaitingAppointments(); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<DataResult<List<Appointment>>>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<List<Appointment>>>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallwaiting/staff/{staffId}")
	public ResponseEntity<DataResult<List<Appointment>>> getAllWaitingAppointmentsByStaff(@PathVariable(name = "staffId") String staffId){
		DataResult<List<Appointment>> staffs = this._appointmentService.getAllWaitingAppointmentsByStaff(staffId); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<DataResult<List<Appointment>>>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<List<Appointment>>>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallwaiting/customer/{customerId}")
	public ResponseEntity<DataResult<List<Appointment>>> getAllWaitingAppointmentsByCustomer(@PathVariable(name = "customerId") String customerId){
		DataResult<List<Appointment>> staffs = this._appointmentService.getAllWaitingAppointmentsByCustomer(customerId); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<DataResult<List<Appointment>>>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<List<Appointment>>>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallaccepted/")
	public ResponseEntity<DataResult<List<Appointment>>> getAllAcceptedAppointments(){
		DataResult<List<Appointment>> staffs = this._appointmentService.getAllAcceptedAppointments(); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<DataResult<List<Appointment>>>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<List<Appointment>>>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallaccepted/{staffId}")
	public ResponseEntity<DataResult<List<Appointment>>> getAllAcceptedAppointmentsByStaff(@PathVariable(name = "staffId") String staffId){
		DataResult<List<Appointment>> staffs = this._appointmentService.getAllAcceptedAppointmentsByStaff(staffId); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<DataResult<List<Appointment>>>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<List<Appointment>>>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallaccepted/customer/{customerId}")
	public ResponseEntity<DataResult<List<Appointment>>> getAllAcceptedAppointmentsByCustomer(@PathVariable(name = "customerId") String customerId){
		DataResult<List<Appointment>> staffs = this._appointmentService.getAllAcceptedAppointmentsByCustomer(customerId); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<DataResult<List<Appointment>>>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<List<Appointment>>>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getalldeclined")
	public ResponseEntity<DataResult<List<Appointment>>> getAllDeclinedAppointments(){
		DataResult<List<Appointment>> staffs = this._appointmentService.getAllDeclinedAppointments(); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<DataResult<List<Appointment>>>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<List<Appointment>>>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getalldeclined/{staffId}")
	public ResponseEntity<DataResult<List<Appointment>>> getAllDeclinedAppointmentsByStaff(@PathVariable(name = "staffId") String staffId){
		DataResult<List<Appointment>> staffs = this._appointmentService.getAllDeclinedAppointmentsByStaff(staffId); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<DataResult<List<Appointment>>>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<List<Appointment>>>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getalldeclined/customer/{customerId}")
	public ResponseEntity<DataResult<List<Appointment>>> getAllDeclinedAppointmentsByCustomer(@PathVariable(name = "customerId") String customerId){
		DataResult<List<Appointment>> staffs = this._appointmentService.getAllDeclinedAppointmentsByCustomer(customerId); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<DataResult<List<Appointment>>>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<List<Appointment>>>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{appointmentId}")
	public ResponseEntity<DataResult<Appointment>> getById(@PathVariable(name = "appointmentId") String appointmentId) {
		DataResult<Appointment> appointment = this._appointmentService.getByAppointmentId(appointmentId);
		if(appointment.isSuccess()) {
			return new ResponseEntity<DataResult<Appointment>>(appointment, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<Appointment>>(appointment, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/staff/{staffId}")
	public ResponseEntity<DataResult<List<Appointment>>> getAllByStaff(@PathVariable(name = "staffId") String staffId) {
		DataResult<List<Appointment>> appointment = this._appointmentService.getAllByStaff(staffId);
		if(appointment.isSuccess()) {
			return new ResponseEntity<DataResult<List<Appointment>>>(appointment, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<List<Appointment>>>(appointment, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<DataResult<List<Appointment>>> getAllByCustomer(@PathVariable(name = "customerId") String customerId) {
		DataResult<List<Appointment>> appointment = this._appointmentService.getAllByCustomer(customerId);
		if(appointment.isSuccess()) {
			return new ResponseEntity<DataResult<List<Appointment>>>(appointment, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<List<Appointment>>>(appointment, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody Appointment appointment) {
		Result result = this._appointmentService.add(appointment); 
		if(result.isSuccess()) {
			return new ResponseEntity<Result>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Result> update(@RequestBody Appointment appointment) {
		Result result = this._appointmentService.update(appointment); 
		if(result.isSuccess()) {
			return new ResponseEntity<Result>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody Appointment appointment) {
		Result result = this._appointmentService.delete(appointment); 
		if(result.isSuccess()) {
			return new ResponseEntity<Result>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
