package com.emrecan.appointmentsystem.business.abstracts;

import java.util.List;

import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.entities.Admin;

public interface AdminService {

	DataResult<Admin> getById(String adminId);
	DataResult<List<Admin>> getAll();
	Result add(Admin admin);
	
}
