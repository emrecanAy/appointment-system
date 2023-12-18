package com.emrecan.appointmentsystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrecan.appointmentsystem.business.abstracts.CustomerService;
import com.emrecan.appointmentsystem.business.constants.Messages;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessDataResult;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessResult;
import com.emrecan.appointmentsystem.dataAccess.abstracts.CustomerDao;
import com.emrecan.appointmentsystem.entities.Customer;

@Service
public class CustomerManager implements CustomerService {

	private final CustomerDao _customerDao;
	
	@Autowired
	public CustomerManager(CustomerDao _customerDao) {
		this._customerDao = _customerDao;
	}

	@Override
	public DataResult<Customer> getById(String customerId) {
		return new SuccessDataResult<Customer>(this._customerDao.getCustomerByCustomerId(customerId), Messages.EntityListed);
	}

	@Override
	public DataResult<List<Customer>> getAll() {
		return new SuccessDataResult<List<Customer>>(this._customerDao.getAllCustomersByIsDeletedFalse(), Messages.EntitiesListed);
	}
	
	@Override
	public DataResult<List<Customer>> getAllDeletedCustomers() {
		return new SuccessDataResult<List<Customer>>(
				this._customerDao.getAllCustomersByIsDeletedTrue(), Messages.EntitiesListed);
	}
	
	@Override
	public DataResult<Customer> getByEmail(String email) {
		return new SuccessDataResult<Customer>(this._customerDao.getCustomerByEmail(email), Messages.EntityListed);
	}

	@Override
	public Result add(Customer customer) {
		this._customerDao.save(customer);
		return new SuccessResult(Messages.EntityAdded);
	}

	@Override
	public Result update(Customer customer) {
		this._customerDao.save(customer);
		return new SuccessResult(Messages.EntityUpdated);
	}

	@Override
	public Result delete(Customer customer) {
		this._customerDao.delete(customer);
		return new SuccessResult(Messages.EntityDeleted);
	}

	

	
	
	
}
