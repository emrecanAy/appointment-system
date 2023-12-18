package com.emrecan.appointmentsystem.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emrecan.appointmentsystem.business.abstracts.AdminService;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.entities.Admin;

@RestController
@RequestMapping("/api/admins")
public class AdminsController {

	private final AdminService _adminService;
	
	@Autowired
	public AdminsController(AdminService _adminService) {
		this._adminService = _adminService;
	}
	
	@GetMapping("/{adminId}")
	public DataResult<Admin> getById(@PathVariable String adminId) {
		return this._adminService.getById(adminId);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Admin>> getAll(){
		
		return this._adminService.getAll();
	}

	@PostMapping("/add")
	public Result Add(@RequestBody Admin admin) {
		return this._adminService.add(admin);
	}
	
	
}
