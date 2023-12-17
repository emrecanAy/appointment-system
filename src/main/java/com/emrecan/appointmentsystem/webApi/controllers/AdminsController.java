package com.emrecan.appointmentsystem.webApi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emrecan.appointmentsystem.business.abstracts.AdminService;
import com.emrecan.appointmentsystem.core.utilities.results.IDataResult;
import com.emrecan.appointmentsystem.core.utilities.results.IResult;
import com.emrecan.appointmentsystem.entities.Admin;

@RestController
@RequestMapping("/api/admins")
public class AdminsController {

	private final AdminService _adminService;
	
	@Autowired
	public AdminsController(AdminService _adminService) {
		this._adminService = _adminService;
	}
	
	public Optional<Admin> getById(String id) {
		return null;
	}
	
	@GetMapping("/getall")
	public IDataResult<List<Admin>> getAll(){
		
		return this._adminService.getAll();
	}

	@PostMapping("/add")
	public IResult Add(@RequestBody Admin admin) {
		return this._adminService.add(admin);
	}
	
	
}
