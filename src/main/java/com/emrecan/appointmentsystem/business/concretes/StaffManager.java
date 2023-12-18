package com.emrecan.appointmentsystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrecan.appointmentsystem.business.abstracts.StaffService;
import com.emrecan.appointmentsystem.business.constants.Messages;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessDataResult;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessResult;
import com.emrecan.appointmentsystem.dataAccess.abstracts.StaffDao;
import com.emrecan.appointmentsystem.entities.Staff;

@Service
public class StaffManager implements StaffService {
	
	private final StaffDao _staffDao;

	@Autowired
	public StaffManager(StaffDao _staffDao) {
		this._staffDao = _staffDao;
	}

	@Override
	public DataResult<Staff> getById(String staffId) {
		return new SuccessDataResult<Staff>(this._staffDao.getStaffByStaffId(staffId), Messages.EntityListed);
	}

	@Override
	public DataResult<Staff> getByEmail(String email) {
		return new SuccessDataResult<Staff>(this._staffDao.getStaffByEmail(email), Messages.EntityListed);
	}

	@Override
	public DataResult<List<Staff>> getAll() {
		return new SuccessDataResult<List<Staff>>(this._staffDao.getAllByIsDeletedFalse(), Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<Staff>> getAllDeletedStaffs() {
		return new SuccessDataResult<List<Staff>>(this._staffDao.getAllByIsDeletedTrue(), Messages.EntitiesListed);
	}

	@Override
	public Result add(Staff staff) {
		this._staffDao.save(staff);
		return new SuccessResult(Messages.EntityAdded);
	}

	@Override
	public Result update(Staff staff) {
		this._staffDao.save(staff);
		return new SuccessResult(Messages.EntityUpdated);
	}

	@Override
	public Result delete(Staff staff) {
		staff.setDeleted(true);
		this._staffDao.save(staff);
		return new SuccessResult(Messages.EntityDeleted);
	}

	
	
}
