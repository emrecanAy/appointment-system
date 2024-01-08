package com.emrecan.appointmentsystem.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrecan.appointmentsystem.business.abstracts.CustomerService;
import com.emrecan.appointmentsystem.business.constants.Messages;
import com.emrecan.appointmentsystem.business.requests.customer.CreateCustomerRequest;
import com.emrecan.appointmentsystem.business.requests.customer.DeleteCustomerRequest;
import com.emrecan.appointmentsystem.business.requests.customer.UpdateCustomerRequest;
import com.emrecan.appointmentsystem.business.responses.customer.GetAllCustomersResponse;
import com.emrecan.appointmentsystem.business.responses.customer.GetCustomerResponse;
import com.emrecan.appointmentsystem.core.utilities.mappers.ModelMapperService;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessDataResult;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessResult;
import com.emrecan.appointmentsystem.dataAccess.abstracts.CustomerDao;
import com.emrecan.appointmentsystem.entities.Customer;

@Service
public class CustomerManager implements CustomerService {

	private final CustomerDao _customerDao;
	private final ModelMapperService _modelMapperService;
	
	@Autowired
	public CustomerManager(CustomerDao customerDao, ModelMapperService modelMapperService) {
		this._customerDao = customerDao;
		this._modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<GetCustomerResponse> getById(String customerId) {
		Customer customer = this._customerDao.getCustomerByCustomerId(customerId);
		GetCustomerResponse customerResponse = this._modelMapperService.forResponse().map(customer, GetCustomerResponse.class);
		return new SuccessDataResult<>(customerResponse, Messages.EntityListed);
	}

	@Override
	public DataResult<List<GetAllCustomersResponse>> getAll() {
		List<Customer> customers = this._customerDao.getAllCustomersByIsDeleted(false);
		List<GetAllCustomersResponse> customersResponse = customers.stream().map(customer->this._modelMapperService.forResponse().map(customer, GetAllCustomersResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<>(customersResponse, Messages.EntitiesListed);
	}
	
	@Override
	public DataResult<List<GetAllCustomersResponse>> getAllDeletedCustomers() {
		List<Customer> customers = this._customerDao.getAllCustomersByIsDeleted(true);
		List<GetAllCustomersResponse> customersResponse = customers.stream().map(customer->this._modelMapperService.forResponse().map(customer, GetAllCustomersResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<>(customersResponse, Messages.EntitiesListed);
	}
	
	@Override
	public DataResult<GetCustomerResponse> getByEmail(String email){
		Customer customer = this._customerDao.getCustomerByEmail(email);
		GetCustomerResponse customerResponse = this._modelMapperService.forResponse().map(customer, GetCustomerResponse.class);
		return new SuccessDataResult<>(customerResponse, Messages.EntityListed);
	}

	@Override
	public DataResult<GetCustomerResponse> getByUsername(String userName) {
		Customer customer = this._customerDao.getCustomerByUserName(userName);
		GetCustomerResponse customerResponse = this._modelMapperService.forResponse().map(customer, GetCustomerResponse.class);
		return new SuccessDataResult<>(customerResponse, Messages.EntityListed);
	}

	@Override
	public Result add(CreateCustomerRequest createCustomerRequest) {
		Customer customer = this._modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
		this._customerDao.save(customer);
		return new SuccessResult(Messages.EntityAdded);
	}

	@Override
	public Result update(UpdateCustomerRequest updateCustomerRequest) {
		Customer customer = this._modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
		this._customerDao.save(customer);
		return new SuccessResult(Messages.EntityUpdated);
	}

	@Override
	public Result delete(DeleteCustomerRequest deleteCustomerRequest) {
		this._customerDao.deleteByCustomerId(deleteCustomerRequest.getCustomerId());
		return new SuccessResult(Messages.EntityDeleted);
	}

	

	
	
	
}
