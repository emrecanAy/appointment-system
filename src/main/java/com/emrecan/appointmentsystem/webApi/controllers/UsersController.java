package com.emrecan.appointmentsystem.webApi.controllers;

import java.util.List;

import com.emrecan.appointmentsystem.business.requests.user.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emrecan.appointmentsystem.business.abstracts.UserService;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.entities.User;

@RestController
@RequestMapping("/api/admins")
public class UsersController {

	private final UserService _userService;
	
	@Autowired
	public UsersController(UserService userService) {
		this._userService = userService;
	}
	
	@GetMapping("/{adminId}")
	public DataResult<User> getById(@PathVariable String adminId) {
		return this._userService.getById(adminId);
	}
	
	@GetMapping("/getall")
	public DataResult<List<User>> getAll(){
		
		return this._userService.getAll();
	}

	@PostMapping("/add")
	public Result Add(@RequestBody CreateUserRequest createUserRequest) {
		return this._userService.add(createUserRequest);
	}
	
	
}
