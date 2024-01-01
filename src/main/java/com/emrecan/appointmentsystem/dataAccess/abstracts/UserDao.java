package com.emrecan.appointmentsystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emrecan.appointmentsystem.entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserDao extends JpaRepository<User, String>{

	User getUserByUserId(String userId);
	List<User> getAllUsersByIsDeletedFalse();

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update User u set u.isDeleted = true where u.userId=:userId")
	void deleteByUserId(@Param("userId") String userId);
	
}
