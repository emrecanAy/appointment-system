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
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.entities.CareService;

@RestController
@RequestMapping("/api/care-services")
public class CareServiceController {

	private final CareServiceService _careServiceService;

	@Autowired
	public CareServiceController(CareServiceService _careServiceService) {
		this._careServiceService = _careServiceService;
	}
	
	@GetMapping("/{careServiceId}")
	public ResponseEntity<DataResult<CareService>> getById(@PathVariable(name = "careServiceId") String careServiceId) {
		DataResult<CareService> careService = this._careServiceService.getById(careServiceId);
		if(careService.isSuccess()) {
			return new ResponseEntity<DataResult<CareService>>(careService, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<CareService>>(careService, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<CareService>>> getAll(){
		DataResult<List<CareService>> careServices = this._careServiceService.getAll(); 
		if(careServices.isSuccess()) {
			return new ResponseEntity<DataResult<List<CareService>>>(careServices, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<List<CareService>>>(careServices, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getalldeleted")
	public ResponseEntity<DataResult<List<CareService>>> getAllDeleted(){
		DataResult<List<CareService>> careServices = this._careServiceService.getAllDeleted(); 
		if(careServices.isSuccess()) {
			return new ResponseEntity<DataResult<List<CareService>>>(careServices, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<List<CareService>>>(careServices, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody CareService careService) {
		Result result = this._careServiceService.add(careService); 
		if(result.isSuccess()) {
			return new ResponseEntity<Result>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Result> update(@RequestBody CareService careService) {
		Result result = this._careServiceService.update(careService); 
		if(result.isSuccess()) {
			return new ResponseEntity<Result>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody CareService careService) {
		Result result = this._careServiceService.delete(careService); 
		if(result.isSuccess()) {
			return new ResponseEntity<Result>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
