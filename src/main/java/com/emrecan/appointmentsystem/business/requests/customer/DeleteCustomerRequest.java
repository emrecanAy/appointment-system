package com.emrecan.appointmentsystem.business.requests.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCustomerRequest {

	private String customerId;
	
}
