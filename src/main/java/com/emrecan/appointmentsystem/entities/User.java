package com.emrecan.appointmentsystem.entities;

import java.time.LocalDateTime;
import com.emrecan.appointmentsystem.core.entities.IEntity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class User implements IEntity {

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "created_at")
	private final LocalDateTime createdAt = LocalDateTime.now();

	@Column(name = "is_deleted")
	private boolean isDeleted = false;
}

