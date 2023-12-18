package com.emrecan.appointmentsystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrecan.appointmentsystem.business.abstracts.CareServiceService;
import com.emrecan.appointmentsystem.business.constants.Messages;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessDataResult;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessResult;
import com.emrecan.appointmentsystem.dataAccess.abstracts.CareServiceDao;
import com.emrecan.appointmentsystem.entities.CareService;

@Service
public class CareServiceManager implements CareServiceService{

	private final CareServiceDao _careServiceDao;

	@Autowired
	public CareServiceManager(CareServiceDao _careServiceDao) {
		this._careServiceDao = _careServiceDao;
	}

	@Override
	public DataResult<CareService> getById(String careServiceId) {
		return new SuccessDataResult<CareService>(this._careServiceDao.getByCareServiceId(careServiceId), Messages.EntityListed);
	}

	@Override
	public DataResult<List<CareService>> getAll() {
		return new SuccessDataResult<List<CareService>>(this._careServiceDao.getAllCareServicesByIsDeleted(false), Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<CareService>> getAllDeleted() {
		return new SuccessDataResult<List<CareService>>(this._careServiceDao.getAllCareServicesByIsDeleted(true), Messages.EntitiesListed);
	}

	@Override
	public Result add(CareService careService) {
		this._careServiceDao.save(careService);
		return new SuccessResult(Messages.EntityAdded);
	}

	@Override
	public Result update(CareService careService) {
		this._careServiceDao.save(careService);
		return new SuccessResult(Messages.EntityUpdated);
	}

	@Override
	public Result delete(CareService careService) {
		careService.setDeleted(true);
		this._careServiceDao.save(careService);
		return new SuccessResult(Messages.EntityDeleted);
	}
	
	
}
