package com.emrecan.appointmentsystem.business.abstracts;

import java.util.List;

import com.emrecan.appointmentsystem.business.requests.customer.CreateCustomerRequest;
import com.emrecan.appointmentsystem.business.requests.customer.DeleteCustomerRequest;
import com.emrecan.appointmentsystem.business.requests.customer.UpdateCustomerRequest;
import com.emrecan.appointmentsystem.business.responses.customer.GetAllCustomersResponse;
import com.emrecan.appointmentsystem.business.responses.customer.GetCustomerResponse;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;

public interface CustomerService {

	DataResult<GetCustomerResponse> getById(String id);
	DataResult<GetCustomerResponse> getByEmail(String email);
	DataResult<List<GetAllCustomersResponse>> getAll();
	DataResult<List<GetAllCustomersResponse>> getAllDeletedCustomers();
	Result add(CreateCustomerRequest createCustomerRequest);
	Result update(UpdateCustomerRequest updateCustomerRequest);
	Result delete(DeleteCustomerRequest deleteCustomerRequest);
	
}
