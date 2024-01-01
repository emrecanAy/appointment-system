package com.emrecan.appointmentsystem.business.responses.staff;

import com.emrecan.appointmentsystem.entities.enums.Gender;
import com.emrecan.appointmentsystem.entities.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetStaffResponse {
	
	private String staffId;
	private Role role;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String userName;
	private String password;
	private Gender gender;
	private String imagePath;

}