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

import com.emrecan.appointmentsystem.business.abstracts.CareServiceService;
import com.emrecan.appointmentsystem.business.requests.careService.CreateCareServiceRequest;
import com.emrecan.appointmentsystem.business.requests.careService.DeleteCareServiceRequest;
import com.emrecan.appointmentsystem.business.requests.careService.UpdateCareServiceRequest;
import com.emrecan.appointmentsystem.business.responses.careService.GetAllCareServicesResponse;
import com.emrecan.appointmentsystem.business.responses.careService.GetCareServiceResponse;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;

@RestController
@RequestMapping("/api/care-services")
public class CareServicesController {

	private final CareServiceService _careServiceService;

	@Autowired
	public CareServicesController(CareServiceService _careServiceService) {
		this._careServiceService = _careServiceService;
	}
	
	@GetMapping("/{careServiceId}")
	public ResponseEntity<DataResult<GetCareServiceResponse>> getById(@PathVariable(name = "careServiceId") String careServiceId) {
		DataResult<GetCareServiceResponse> careService = this._careServiceService.getById(careServiceId);
		if(careService.isSuccess()) {
			return new ResponseEntity<>(careService, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(careService, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<GetAllCareServicesResponse>>> getAll(){
		DataResult<List<GetAllCareServicesResponse>> careServices = this._careServiceService.getAll(); 
		if(careServices.isSuccess()) {
			return new ResponseEntity<>(careServices, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(careServices, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getalldeleted")
	public ResponseEntity<DataResult<List<GetAllCareServicesResponse>>> getAllDeleted(){
		DataResult<List<GetAllCareServicesResponse>> careServices = this._careServiceService.getAllDeleted(); 
		if(careServices.isSuccess()) {
			return new ResponseEntity<>(careServices, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(careServices, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody CreateCareServiceRequest createCareServiceRequest) {
		Result result = this._careServiceService.add(createCareServiceRequest); 
		if(result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Result> update(@RequestBody UpdateCareServiceRequest updateCareServiceRequest) {
		Result result = this._careServiceService.update(updateCareServiceRequest); 
		if(result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody DeleteCareServiceRequest deleteCareServiceRequest) {
		Result result = this._careServiceService.delete(deleteCareServiceRequest); 
		if(result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
