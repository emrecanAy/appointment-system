package com.emrecan.appointmentsystem.business.abstracts;

import java.util.List;

import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.entities.Customer;

public interface CustomerService {

	DataResult<Customer> getById(String id);
	DataResult<Customer> getByEmail(String email);
	DataResult<List<Customer>> getAll();
	DataResult<List<Customer>> getAllDeletedCustomers();
	Result add(Customer customer);
	Result update(Customer customer);
	Result delete(Customer customer);
	
}
