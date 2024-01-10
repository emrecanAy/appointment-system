package com.emrecan.appointmentsystem.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.emrecan.appointmentsystem.entities.enums.CustomerRole;
import com.emrecan.appointmentsystem.entities.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import com.emrecan.appointmentsystem.core.entities.IEntity;

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
public class Customer implements IEntity {
	
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
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;

	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	private List<Appointment> appointments;
	
	@Column(name = "created_at")
	private final LocalDateTime createdAt = LocalDateTime.now();
	
	@Column(name = "is_deleted")
	private boolean isDeleted = false;

}
