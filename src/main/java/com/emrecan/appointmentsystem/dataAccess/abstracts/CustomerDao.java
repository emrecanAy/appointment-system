package com.emrecan.appointmentsystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emrecan.appointmentsystem.entities.Customer;

public interface CustomerDao extends JpaRepository<Customer, String>{

	public Customer getCustomerByCustomerId(String customerId);
	public Customer getCustomerByEmail(String email);
	public List<Customer> getAllCustomersByIsDeleted(boolean isDeleted);
	
}
