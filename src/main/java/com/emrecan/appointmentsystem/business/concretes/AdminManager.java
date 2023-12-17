package com.emrecan.appointmentsystem.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrecan.appointmentsystem.business.abstracts.AdminService;
import com.emrecan.appointmentsystem.business.constants.Messages;
import com.emrecan.appointmentsystem.core.utilities.results.IDataResult;
import com.emrecan.appointmentsystem.core.utilities.results.IResult;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessDataResult;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessResult;
import com.emrecan.appointmentsystem.dataAccess.abstracts.AdminDao;
import com.emrecan.appointmentsystem.entities.Admin;

@Service
public class AdminManager implements AdminService{

	private final AdminDao _adminDao;
	
	@Autowired
	public AdminManager(AdminDao _adminDao) {
		super();
		this._adminDao = _adminDao;
	}

	@Override
	public IDataResult<Admin> getById(String id) {
		return null;
	}

	@Override
	public IDataResult<List<Admin>> getAll() {
		return new SuccessDataResult<List<Admin>>(this._adminDao.findAll(), Messages.EntitiesListed);
	}

	@Override
	public IResult add(Admin admin) {
		this._adminDao.save(admin);
		return new SuccessResult(Messages.EntityAdded);
	}



	
}
