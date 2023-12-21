package com.emrecan.appointmentsystem.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

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
	@Column(name = "appointment_id")
	private String appointmentId;
	
	@Column(name = "CustomerId")
	private String customerId;
	
	@Column(name = "StaffId")
	private String staffId;
	
	@Column(name = "AppointmentDate")
	private Date appointmentDate;
	
	@Column(name = "Status")
	private Status status = Status.WAITING;
	
	@Column(name = "Note")
	private String note;

	@ManyToMany
	@JoinTable(name = "appointments_careservices",
			joinColumns = @JoinColumn(name = "appointment_id"),
			inverseJoinColumns = @JoinColumn(name = "care_service_id"))
	private List<CareService> careServices;
	
	@Column(name = "CreatedAt")
	private final Date createdAt = Date.valueOf(LocalDate.now());
	
	@Column(name = "IsDeleted")
	private boolean isDeleted = false;

}
