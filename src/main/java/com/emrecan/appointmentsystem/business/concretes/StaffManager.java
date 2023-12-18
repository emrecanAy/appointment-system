package com.emrecan.appointmentsystem.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrecan.appointmentsystem.business.abstracts.StaffService;
import com.emrecan.appointmentsystem.business.constants.Messages;
import com.emrecan.appointmentsystem.business.requests.staff.CreateStaffRequest;
import com.emrecan.appointmentsystem.business.requests.staff.DeleteStaffRequest;
import com.emrecan.appointmentsystem.business.requests.staff.UpdateStaffRequest;
import com.emrecan.appointmentsystem.business.responses.staff.GetAllStaffResponse;
import com.emrecan.appointmentsystem.business.responses.staff.GetStaffResponse;
import com.emrecan.appointmentsystem.core.utilities.mappers.ModelMapperService;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessDataResult;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessResult;
import com.emrecan.appointmentsystem.dataAccess.abstracts.StaffDao;
import com.emrecan.appointmentsystem.entities.Staff;

@Service
public class StaffManager implements StaffService {
	
	private final StaffDao _staffDao;
	private final ModelMapperService _modelMapperService;

	@Autowired
	public StaffManager(StaffDao staffDao, ModelMapperService modelMapperService) {
		this._staffDao = staffDao;
		this._modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<GetStaffResponse> getById(String staffId) {
		
		Staff staff = this._staffDao.getStaffByStaffId(staffId);
		GetStaffResponse staffResponse = this._modelMapperService.forResponse().map(staff, GetStaffResponse.class);
		return new SuccessDataResult<GetStaffResponse>(staffResponse, Messages.EntityListed);
	}

	@Override
	public DataResult<GetStaffResponse> getByEmail(String email) {
		Staff staff = this._staffDao.getStaffByEmail(email);
		GetStaffResponse staffResponse = this._modelMapperService.forResponse().map(staff, GetStaffResponse.class);
		return new SuccessDataResult<GetStaffResponse>(staffResponse, Messages.EntityListed);
	}

	@Override
	public DataResult<List<GetAllStaffResponse>> getAll() {
		List<Staff> staffs = this._staffDao.getAllByIsDeleted(false);
		List<GetAllStaffResponse> staffsResponse = staffs.stream().map(staff->this._modelMapperService.forResponse().map(staff, GetAllStaffResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllStaffResponse>>(staffsResponse, Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<GetAllStaffResponse>> getAllDeletedStaffs() {
		List<Staff> staffs = this._staffDao.getAllByIsDeleted(true);
		List<GetAllStaffResponse> staffsResponse = staffs.stream().map(staff->this._modelMapperService.forResponse().map(staff, GetAllStaffResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllStaffResponse>>(staffsResponse, Messages.EntitiesListed);
	}

	@Override
	public Result add(CreateStaffRequest createStaffRequest) {
		Staff staff = this._modelMapperService.forRequest().map(createStaffRequest, Staff.class);
		this._staffDao.save(staff);
		return new SuccessResult(Messages.EntityAdded);
	}

	@Override
	public Result update(UpdateStaffRequest updateStaffRequest) {
		Staff staff = this._modelMapperService.forRequest().map(updateStaffRequest, Staff.class);
		this._staffDao.save(staff);
		return new SuccessResult(Messages.EntityUpdated);
	}

	@Override
	public Result delete(DeleteStaffRequest deleteStaffRequest) {
		Staff staff = this._modelMapperService.forRequest().map(deleteStaffRequest, Staff.class);
		staff.setDeleted(true);
		this._staffDao.save(staff);
		return new SuccessResult(Messages.EntityDeleted);
	}

	
	
}
