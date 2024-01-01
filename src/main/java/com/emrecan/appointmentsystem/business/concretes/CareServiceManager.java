package com.emrecan.appointmentsystem.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrecan.appointmentsystem.business.abstracts.CareServiceService;
import com.emrecan.appointmentsystem.business.constants.Messages;
import com.emrecan.appointmentsystem.business.requests.careService.CreateCareServiceRequest;
import com.emrecan.appointmentsystem.business.requests.careService.DeleteCareServiceRequest;
import com.emrecan.appointmentsystem.business.requests.careService.UpdateCareServiceRequest;
import com.emrecan.appointmentsystem.business.responses.careService.GetAllCareServicesResponse;
import com.emrecan.appointmentsystem.business.responses.careService.GetCareServiceResponse;
import com.emrecan.appointmentsystem.core.utilities.mappers.ModelMapperService;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessDataResult;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessResult;
import com.emrecan.appointmentsystem.dataAccess.abstracts.CareServiceDao;
import com.emrecan.appointmentsystem.entities.CareService;

@Service
public class CareServiceManager implements CareServiceService{

	private final CareServiceDao _careServiceDao;
	private final ModelMapperService _modelMapperService;

	@Autowired
	public CareServiceManager(CareServiceDao _careServiceDao, ModelMapperService modelMapperService) {
		this._careServiceDao = _careServiceDao;
		this._modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<GetCareServiceResponse> getById(String careServiceId) {
		CareService careService = this._careServiceDao.getByCareServiceId(careServiceId);
		GetCareServiceResponse careServiceResponse = this._modelMapperService.forResponse().map(careService, GetCareServiceResponse.class);
		return new SuccessDataResult<>(careServiceResponse, Messages.EntityListed);
	}

	@Override
	public DataResult<List<GetAllCareServicesResponse>> getAll() {
		
		List<CareService> careServices = this._careServiceDao.getAllCareServicesByIsDeleted(false);
		List<GetAllCareServicesResponse> careServicesResponse = careServices.stream()
				.map(careService->this._modelMapperService.forResponse().map(careService, GetAllCareServicesResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<>(careServicesResponse, Messages.EntitiesListed);
	}

	@Override
	public DataResult<List<GetAllCareServicesResponse>> getAllDeleted() {
		List<CareService> careServices = this._careServiceDao.getAllCareServicesByIsDeleted(true);
		List<GetAllCareServicesResponse> careServicesResponse = careServices.stream()
				.map(careService->this._modelMapperService.forResponse().map(careService, GetAllCareServicesResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<>(careServicesResponse, Messages.EntitiesListed);
	}

	@Override
	public Result add(CreateCareServiceRequest createCareServiceRequest) {
		CareService careService = this._modelMapperService.forRequest().map(createCareServiceRequest, CareService.class);
		this._careServiceDao.save(careService);
		return new SuccessResult(Messages.EntityAdded);
	}

	@Override
	public Result update(UpdateCareServiceRequest updateCareServiceRequest) {
		CareService careService = this._modelMapperService.forRequest().map(updateCareServiceRequest, CareService.class);
		this._careServiceDao.save(careService);
		return new SuccessResult(Messages.EntityUpdated);
	}

	@Override
	public Result delete(DeleteCareServiceRequest deleteCareServiceRequest) {
		this._careServiceDao.deleteByCareServiceId(deleteCareServiceRequest.getCareServiceId());
		return new SuccessResult(Messages.EntityDeleted);
	}
	
	
}
