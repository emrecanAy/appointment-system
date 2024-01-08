package com.emrecan.appointmentsystem.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.emrecan.appointmentsystem.business.abstracts.CustomerService;
import com.emrecan.appointmentsystem.business.constants.Messages;
import com.emrecan.appointmentsystem.business.requests.customer.CreateCustomerRequest;
import com.emrecan.appointmentsystem.business.requests.customer.DeleteCustomerRequest;
import com.emrecan.appointmentsystem.business.requests.customer.UpdateCustomerRequest;
import com.emrecan.appointmentsystem.business.responses.customer.GetAllCustomersResponse;
import com.emrecan.appointmentsystem.business.responses.customer.GetCustomerResponse;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

	private final CustomerService _customerService;

	@Autowired
	public CustomersController(CustomerService _customerService) {
		this._customerService = _customerService;
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<DataResult<GetCustomerResponse>> getById(@PathVariable(name = "customerId") String customerId) {
		DataResult<GetCustomerResponse> customer = this._customerService.getById(customerId);
		if(customer.isSuccess()) {
			return new ResponseEntity<>(customer, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(customer, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<DataResult<GetCustomerResponse>> getByEmail(@PathVariable(name = "email") String email) {
		DataResult<GetCustomerResponse> customer = this._customerService.getByEmail(email);
		if(customer.isSuccess()) {
			return new ResponseEntity<>(customer, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(customer, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/username/{username}")
	public ResponseEntity<DataResult<GetCustomerResponse>> getByUsername(@PathVariable(name = "username") String username) {
		DataResult<GetCustomerResponse> customer = this._customerService.getByUsername(username);
		if(customer.isSuccess()) {
			return new ResponseEntity<>(customer, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(customer, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/email-password")
	public ResponseEntity<DataResult<GetCustomerResponse>> getByEmailAndPassword(@RequestParam(name = "email") String email, @RequestParam(name="password") String password) {
		DataResult<GetCustomerResponse> customer = this._customerService.getByEmailAndPassword(email, password);
		if(customer.isSuccess()) {
			return new ResponseEntity<>(customer, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(customer, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<GetAllCustomersResponse>>> getAll(){
		DataResult<List<GetAllCustomersResponse>> customers = this._customerService.getAll(); 
		if(customers.isSuccess()) {
			return new ResponseEntity<>(customers, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(customers, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getalldeletedcustomers")
	public ResponseEntity<DataResult<List<GetAllCustomersResponse>>> getAllDeletedCustomers(){
		DataResult<List<GetAllCustomersResponse>> customers = this._customerService.getAllDeletedCustomers(); 
		if(customers.isSuccess()) {
			return new ResponseEntity<>(customers, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(customers, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody CreateCustomerRequest createCustomerRequest) {
		Result result = this._customerService.add(createCustomerRequest); 
		if(result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Result> update(@RequestBody UpdateCustomerRequest updateCustomerRequest) {
		Result result = this._customerService.update(updateCustomerRequest);
		if(result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody DeleteCustomerRequest deleteCustomerRequest) {
		Result result = this._customerService.delete(deleteCustomerRequest);
		if(result.isSuccess()) {
			result.setMessage(Messages.EntityDeleted);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
}
