package com.emrecan.appointmentsystem.business.abstracts;

import java.util.List;

import com.emrecan.appointmentsystem.business.requests.user.CreateUserRequest;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.entities.User;

public interface UserService {

	DataResult<User> getById(String adminId);
	DataResult<List<User>> getAll();
	Result add(CreateUserRequest createUserRequest);
	
}
