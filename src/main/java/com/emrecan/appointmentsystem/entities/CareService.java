package com.emrecan.appointmentsystem.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "care_services")
public class CareService implements IEntity {

	@Id
	@GeneratedValue(generator = "uuid-hibernate-generator")
	@GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "CareServiceId")
	private String careServiceId;
	
	@Column(name = "ServiceName")
	private String careServiceName;
	
	@Column(name = "ServiceDescription")
	private String careServiceDescription;
	
	@Column(name = "ServicePrice")
	private double careServicePrice;
	
	@Column(name = "CreatedAt")
	private final Date createdAt = Date.valueOf(LocalDate.now());
	
	@Column(name = "IsDeleted")
	private boolean isDeleted = false;
	

	
}
