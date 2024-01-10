package com.emrecan.appointmentsystem.entities;

import java.time.LocalDateTime;
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
	
	@Column(name = "customer_id")
	private String customerId;
	
	@Column(name = "staff_id")
	private String staffId;
	
	@Column(name = "appointment_date")
	private LocalDateTime appointmentDate;

	@Column(name = "appointment_hour")
	private String appointmentHour;
	
	@Column(name = "status")
	private Status status = Status.WAITING;
	
	@Column(name = "note")
	private String note;

	@Column(name = "total_duration")//dakika
	private int totalDuration;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false, insertable = false, updatable = false)
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "staff_id", nullable = false, insertable = false, updatable = false)
	private Staff staff;

	@ManyToMany
	@JoinTable(name = "appointments_staffcareservices",
			joinColumns = @JoinColumn(name = "appointment_id"),
			inverseJoinColumns = @JoinColumn(name = "staff_care_service_id"))
	private List<StaffCareService> staffCareServices;
	
	@Column(name = "created_at")
	private final LocalDateTime createdAt = LocalDateTime.now();
	
	@Column(name = "is_deleted")
	private boolean isDeleted = false;

}
