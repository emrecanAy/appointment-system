package com.emrecan.appointmentsystem.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import com.emrecan.appointmentsystem.core.entities.IEntity;
import com.emrecan.appointmentsystem.entities.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "appointments")
public class Appointment implements IEntity {

	@Id
	@GeneratedValue(generator = "uuid-hibernate-generator")
	@GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "AppointmentId")
	private String appointmentId;
	
	@Column(name = "CustomerId")
	private String customerId;
	
	@Column(name = "StaffId")
	private String staffId;
	
	@Column(name = "AppointmentDate")
	private Date appointmentDate;
	
	@Column(name = "Status")
	private Status status = Status.WAITING;
	
	@Column(name = "CreatedAt")
	@CreatedDate
	private final Date createdAt = Date.valueOf(LocalDate.now());
	
	@Column(name = "IsDeleted")
	private boolean isDeleted = false;
	
	
	
}
