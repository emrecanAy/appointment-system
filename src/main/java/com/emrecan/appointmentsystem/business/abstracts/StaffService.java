package com.emrecan.appointmentsystem.business.abstracts;

import java.util.List;

import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.entities.Staff;

public interface StaffService {

	DataResult<Staff> getById(String staffId);
	DataResult<Staff> getByEmail(String email);
	DataResult<List<Staff>> getAll();
	DataResult<List<Staff>> getAllDeletedStaffs();
	Result add(Staff staff);
	Result update(Staff staff);
	Result delete(Staff staff);
	
}
