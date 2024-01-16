package com.emrecan.appointmentsystem.business.responses.customer;

import com.emrecan.appointmentsystem.entities.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerResponse {
	private String customerId;
	private String firstName;
	private String lastName;
	private String email;
	private Gender gender;
	private String phoneNumber;
	private String userName;
}
