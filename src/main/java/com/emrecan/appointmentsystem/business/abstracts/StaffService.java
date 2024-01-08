package com.emrecan.appointmentsystem.business.abstracts;

import java.util.List;

import com.emrecan.appointmentsystem.business.requests.staff.CreateStaffRequest;
import com.emrecan.appointmentsystem.business.requests.staff.DeleteStaffRequest;
import com.emrecan.appointmentsystem.business.requests.staff.UpdateStaffRequest;
import com.emrecan.appointmentsystem.business.responses.staff.GetAllStaffResponse;
import com.emrecan.appointmentsystem.business.responses.staff.GetStaffResponse;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;

public interface StaffService {

	DataResult<GetStaffResponse> getById(String staffId);
	DataResult<GetStaffResponse> getByEmail(String email);
	DataResult<GetStaffResponse> getByEmailAndPassword(String email, String password);
	DataResult<List<GetAllStaffResponse>> getAll();
	DataResult<List<GetAllStaffResponse>> getAllDeletedStaffs();
	Result add(CreateStaffRequest createStaffRequest);
	Result update(UpdateStaffRequest updateStaffRequest);
	Result delete(DeleteStaffRequest deleteStaffRequest);
	
}
