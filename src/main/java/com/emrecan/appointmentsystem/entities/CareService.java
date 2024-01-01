package com.emrecan.appointmentsystem.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

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
@Table(name = "care_services")
public class CareService implements IEntity {

	@Id
	@GeneratedValue(generator = "uuid-hibernate-generator")
	@GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "care_service_id")
	private String careServiceId;
	
	@Column(name = "care_service_name")
	private String careServiceName;
	
	@Column(name = "care_service_description")
	private String careServiceDescription;

	@Column(name = "care_service_image_path")
	private String imagePath;

	@OneToMany(mappedBy = "careService")
	@JsonIgnore
	private List<StaffCareService> staffCareServices;
	
	@Column(name = "created_at")
	private final LocalDateTime createdAt = LocalDateTime.now();
	
	@Column(name = "is_deleted")
	private boolean isDeleted = false;
	
}
