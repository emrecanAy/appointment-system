package com.emrecan.appointmentsystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emrecan.appointmentsystem.entities.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CustomerDao extends JpaRepository<Customer, String>{

	Customer getCustomerByCustomerId(String customerId);
	Customer getCustomerByEmail(String email);
	Customer getCustomerByEmailAndPassword(String email, String password);
	Customer getCustomerByUserName(String userName);
	List<Customer> getAllCustomersByIsDeleted(boolean isDeleted);
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Customer c set c.isDeleted = true where c.customerId=:customerId")
	void deleteByCustomerId(@Param("customerId") String customerId);
	
}
