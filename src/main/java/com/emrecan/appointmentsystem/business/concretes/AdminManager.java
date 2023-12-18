package com.emrecan.appointmentsystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrecan.appointmentsystem.business.abstracts.AdminService;
import com.emrecan.appointmentsystem.business.constants.Messages;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessDataResult;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessResult;
import com.emrecan.appointmentsystem.dataAccess.abstracts.AdminDao;
import com.emrecan.appointmentsystem.entities.Admin;

@Service
public class AdminManager implements AdminService{

	private final AdminDao _adminDao;
	
	@Autowired
	public AdminManager(AdminDao _adminDao) {
		this._adminDao = _adminDao;
	}

	@Override
	public DataResult<Admin> getById(String adminId) {
		this._adminDao.getAdminByAdminId(adminId);
		return new SuccessDataResult<Admin>(Messages.EntityListed);
	}

	@Override
	public DataResult<List<Admin>> getAll() {
		return new SuccessDataResult<List<Admin>>(this._adminDao.getAllAdminsByIsDeletedFalse(), Messages.EntitiesListed);
	}

	@Override
	public Result add(Admin admin) {
		this._adminDao.save(admin);
		return new SuccessResult(Messages.EntityAdded);
	}



	
}
