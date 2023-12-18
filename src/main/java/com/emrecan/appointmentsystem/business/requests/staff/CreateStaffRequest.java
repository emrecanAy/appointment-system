package com.emrecan.appointmentsystem.business.requests.staff;

import com.emrecan.appointmentsystem.entities.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStaffRequest {

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String userName;
	private String password;
	private Role role;
	
}
