package com.emrecan.appointmentsystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emrecan.appointmentsystem.entities.User;

public interface UserDao extends JpaRepository<User, String>{

	User getUserByUserId(String userId);
	List<User> getAllUsersByIsDeletedFalse();
	
}
