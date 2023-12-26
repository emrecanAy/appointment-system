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

import com.emrecan.appointmentsystem.business.abstracts.StaffService;
import com.emrecan.appointmentsystem.business.constants.Messages;
import com.emrecan.appointmentsystem.business.requests.staff.CreateStaffRequest;
import com.emrecan.appointmentsystem.business.requests.staff.DeleteStaffRequest;
import com.emrecan.appointmentsystem.business.requests.staff.UpdateStaffRequest;
import com.emrecan.appointmentsystem.business.responses.staff.GetAllStaffResponse;
import com.emrecan.appointmentsystem.business.responses.staff.GetStaffResponse;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;

@RestController
@RequestMapping("/api/staff")
public class StaffsController {
	
	private final StaffService _staffService;

	@Autowired
	public StaffsController(StaffService _staffService) {
		this._staffService = _staffService;
	}
	
	@GetMapping("/{staffId}")
	public ResponseEntity<DataResult<GetStaffResponse>> getById(@PathVariable(name = "staffId") String staffId) {
		DataResult<GetStaffResponse> staff = this._staffService.getById(staffId);
		if(staff.isSuccess()) {
			return new ResponseEntity<>(staff, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(staff, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<DataResult<GetStaffResponse>> getByEmail(@PathVariable(name = "email") String email) {
		DataResult<GetStaffResponse> staff = this._staffService.getByEmail(email);
		if(staff.isSuccess()) {
			return new ResponseEntity<>(staff, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(staff, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<GetAllStaffResponse>>> getAll(){
		DataResult<List<GetAllStaffResponse>> staffs = this._staffService.getAll(); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getalldeletedstuff")
	public ResponseEntity<DataResult<List<GetAllStaffResponse>>> getAllDeletedStaff(){
		DataResult<List<GetAllStaffResponse>> staffs = this._staffService.getAllDeletedStaffs(); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody CreateStaffRequest createStaffRequest) {
		Result result = this._staffService.add(createStaffRequest); 
		if(result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Result> update(@RequestBody UpdateStaffRequest updateStaffRequest) {
		Result result = this._staffService.update(updateStaffRequest); 
		if(result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody DeleteStaffRequest deleteStaffRequest) {
		Result result = this._staffService.delete(deleteStaffRequest); 
		if(result.isSuccess()) {
			result.setMessage(Messages.EntityDeleted);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	

}
