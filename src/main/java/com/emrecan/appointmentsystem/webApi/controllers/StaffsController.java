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
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.entities.Staff;

@RestController
@RequestMapping("/api/staff")
public class StaffsController {
	
	private final StaffService _staffService;

	@Autowired
	public StaffsController(StaffService _staffService) {
		this._staffService = _staffService;
	}
	
	@GetMapping("/{staffId}")
	public ResponseEntity<DataResult<Staff>> getById(@PathVariable(name = "staffId") String staffId) {
		DataResult<Staff> staff = this._staffService.getById(staffId);
		if(staff.isSuccess()) {
			return new ResponseEntity<DataResult<Staff>>(staff, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<Staff>>(staff, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<DataResult<Staff>> getByEmail(@PathVariable(name = "email") String email) {
		DataResult<Staff> staff = this._staffService.getByEmail(email);
		if(staff.isSuccess()) {
			return new ResponseEntity<DataResult<Staff>>(staff, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<Staff>>(staff, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<Staff>>> getAll(){
		DataResult<List<Staff>> staffs = this._staffService.getAll(); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<DataResult<List<Staff>>>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<List<Staff>>>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getalldeletedstuff")
	public ResponseEntity<DataResult<List<Staff>>> getAllDeletedStaff(){
		DataResult<List<Staff>> staffs = this._staffService.getAllDeletedStaffs(); 
		if(staffs.isSuccess()) {
			return new ResponseEntity<DataResult<List<Staff>>>(staffs, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<List<Staff>>>(staffs, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody Staff staff) {
		Result result = this._staffService.add(staff); 
		if(result.isSuccess()) {
			return new ResponseEntity<Result>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Result> update(@RequestBody Staff staff) {
		Result result = this._staffService.update(staff); 
		if(result.isSuccess()) {
			return new ResponseEntity<Result>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody Staff staff) {
		Result result = this._staffService.delete(staff); 
		if(result.isSuccess()) {
			result.setMessage(Messages.EntityDeleted);
			return new ResponseEntity<Result>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);
		}
	}
	

}
