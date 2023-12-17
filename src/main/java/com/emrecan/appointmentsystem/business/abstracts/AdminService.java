package com.emrecan.appointmentsystem.business.abstracts;

import java.util.List;
import java.util.Optional;

import com.emrecan.appointmentsystem.core.utilities.results.IDataResult;
import com.emrecan.appointmentsystem.core.utilities.results.IResult;
import com.emrecan.appointmentsystem.entities.Admin;

public interface AdminService {

	IDataResult<Admin> getById(String id);
	IDataResult<List<Admin>> getAll();
	IResult add(Admin admin);
	
}
