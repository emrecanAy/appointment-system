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

import com.emrecan.appointmentsystem.business.abstracts.CustomerService;
import com.emrecan.appointmentsystem.business.constants.Messages;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.entities.Customer;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

	private final CustomerService _customerService;

	@Autowired
	public CustomersController(CustomerService _customerService) {
		this._customerService = _customerService;
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<DataResult<Customer>> getById(@PathVariable(name = "customerId") String customerId) {
		DataResult<Customer> customer = this._customerService.getById(customerId);
		if(customer.isSuccess()) {
			return new ResponseEntity<DataResult<Customer>>(customer, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<Customer>>(customer, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<DataResult<Customer>> getByEmail(@PathVariable(name = "email") String email) {
		DataResult<Customer> customer = this._customerService.getByEmail(email);
		if(customer.isSuccess()) {
			return new ResponseEntity<DataResult<Customer>>(customer, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<Customer>>(customer, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<Customer>>> getAll(){
		DataResult<List<Customer>> customers = this._customerService.getAll(); 
		if(customers.isSuccess()) {
			return new ResponseEntity<DataResult<List<Customer>>>(customers, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<List<Customer>>>(customers, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getalldeletedcustomers")
	public ResponseEntity<DataResult<List<Customer>>> getAllDeletedCustomers(){
		DataResult<List<Customer>> customers = this._customerService.getAllDeletedCustomers(); 
		if(customers.isSuccess()) {
			return new ResponseEntity<DataResult<List<Customer>>>(customers, HttpStatus.OK);
		}else {
			return new ResponseEntity<DataResult<List<Customer>>>(customers, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody Customer customer) {
		Result result = this._customerService.add(customer); 
		if(result.isSuccess()) {
			return new ResponseEntity<Result>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Result> update(@RequestBody Customer customer) {
		Result result = this._customerService.update(customer);
		if(result.isSuccess()) {
			return new ResponseEntity<Result>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody Customer customer) {
		customer.setDeleted(true);
		Result result = this._customerService.update(customer);
		if(result.isSuccess()) {
			result.setMessage(Messages.EntityDeleted);
			return new ResponseEntity<Result>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
}
