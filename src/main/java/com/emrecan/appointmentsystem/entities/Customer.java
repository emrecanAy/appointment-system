package com.emrecan.appointmentsystem.entities;

import java.util.List;

import javax.persistence.*;

import com.emrecan.appointmentsystem.entities.enums.CustomerRole;
import com.emrecan.appointmentsystem.entities.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "customers")
public class Customer extends User {
	
	@Id
	@GeneratedValue(generator = "uuid-hibernate-generator")
	@GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "customer_id")
	private String customerId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "gender")
	private Gender gender;

	@Column(name = "role")
	private CustomerRole role = CustomerRole.NORMAL_CUSTOMER;
	
	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	private List<Appointment> appointments;

}
