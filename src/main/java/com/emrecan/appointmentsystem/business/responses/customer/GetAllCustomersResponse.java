package com.emrecan.appointmentsystem.business.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCustomersResponse {

	private String customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String userName;
	private String password;
	
}
