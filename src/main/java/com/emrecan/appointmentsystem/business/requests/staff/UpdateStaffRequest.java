package com.emrecan.appointmentsystem.business.requests.staff;

import com.emrecan.appointmentsystem.entities.enums.Gender;
import com.emrecan.appointmentsystem.entities.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStaffRequest {
	private String staffId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String userName;
	private String password;
	private Role role;
	private Gender gender;
	private String imagePath;
}
