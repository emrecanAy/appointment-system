package com.emrecan.appointmentsystem.business.concretes;

import com.emrecan.appointmentsystem.business.abstracts.StaffCareServiceService;
import com.emrecan.appointmentsystem.business.constants.Messages;
import com.emrecan.appointmentsystem.business.requests.staffCareService.CreateStaffCareServiceRequest;
import com.emrecan.appointmentsystem.business.requests.staffCareService.DeleteStaffCareServiceRequest;
import com.emrecan.appointmentsystem.business.requests.staffCareService.UpdateStaffCareServiceRequest;
import com.emrecan.appointmentsystem.business.responses.staffCareService.GetAllStaffCareServicesResponse;
import com.emrecan.appointmentsystem.business.responses.staffCareService.GetStaffCareServiceResponse;
import com.emrecan.appointmentsystem.core.utilities.mappers.ModelMapperService;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessDataResult;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessResult;
import com.emrecan.appointmentsystem.dataAccess.abstracts.StaffCareServiceDao;
import com.emrecan.appointmentsystem.entities.StaffCareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Emrecan
 * @created 23/12/2023 - 22:23
 */

@Service
public class StaffCareServiceManager implements StaffCareServiceService {


    private final StaffCareServiceDao _staffCareServiceDao;
    private final ModelMapperService _modelMapperService;

    @Autowired
    public StaffCareServiceManager(StaffCareServiceDao staffCareServiceDao, ModelMapperService modelMapperService) {
        this._staffCareServiceDao = staffCareServiceDao;
        this._modelMapperService = modelMapperService;
    }
    @Override
    public DataResult<GetStaffCareServiceResponse> getById(String staffCareServiceId) {
        StaffCareService staffCareService = this._staffCareServiceDao.getByStaffCareServiceId(staffCareServiceId);
        GetStaffCareServiceResponse staffCareServiceResponse = this._modelMapperService.forResponse().map(staffCareService, GetStaffCareServiceResponse.class);
        return new SuccessDataResult<>(staffCareServiceResponse, Messages.EntitiesListed);
    }

    @Override
    public DataResult<List<GetAllStaffCareServicesResponse>> getAll() {
        List<StaffCareService> staffCareServices = this._staffCareServiceDao.getAllStaffCareServicesByIsDeleted(false);
        List<GetAllStaffCareServicesResponse> staffCareServicesResponse = staffCareServices.stream()
                .map(staffCareService->this._modelMapperService.forResponse().map(staffCareService, GetAllStaffCareServicesResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<>(staffCareServicesResponse, Messages.EntitiesListed);
    }

    @Override
    public DataResult<List<GetAllStaffCareServicesResponse>> getAllDeleted() {
        List<StaffCareService> staffCareServices = this._staffCareServiceDao.getAllStaffCareServicesByIsDeleted(true);
        List<GetAllStaffCareServicesResponse> staffCareServicesResponse = staffCareServices.stream()
                .map(staffCareService->this._modelMapperService.forResponse().map(staffCareService, GetAllStaffCareServicesResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<>(staffCareServicesResponse, Messages.EntitiesListed);
    }

    @Override
    public DataResult<List<GetAllStaffCareServicesResponse>> getAllStaffCareServicesByStaffIdAndIsDeleted(String staffId, boolean isDeleted) {
        List<StaffCareService> staffCareServices = this._staffCareServiceDao.getAllStaffCareServicesByStaffIdAndIsDeleted(staffId, isDeleted);
        List<GetAllStaffCareServicesResponse> staffCareServicesResponse = staffCareServices.stream()
                .map(staffCareService->this._modelMapperService.forResponse().map(staffCareService, GetAllStaffCareServicesResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<>(staffCareServicesResponse, Messages.EntitiesListed);
    }

    @Override
    public DataResult<List<GetAllStaffCareServicesResponse>> getAllStaffCareServicesByCareServiceIdAndIsDeleted(String careServiceId, boolean isDeleted) {
        List<StaffCareService> staffCareServices = this._staffCareServiceDao.getAllStaffCareServicesByCareServiceIdAndIsDeleted(careServiceId, isDeleted);
        List<GetAllStaffCareServicesResponse> staffCareServicesResponse = staffCareServices.stream()
                .map(staffCareService->this._modelMapperService.forResponse().map(staffCareService, GetAllStaffCareServicesResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<>(staffCareServicesResponse, Messages.EntitiesListed);
    }

    @Override
    public Result add(CreateStaffCareServiceRequest createStaffCareServiceRequest) {
        StaffCareService staffCareService = this._modelMapperService.forRequest().map(createStaffCareServiceRequest, StaffCareService.class);
        this._staffCareServiceDao.save(staffCareService);
        return new SuccessResult(Messages.EntityAdded);
    }

    @Override
    public Result update(UpdateStaffCareServiceRequest updateStaffCareServiceRequest) {
        StaffCareService staffCareService = this._modelMapperService.forRequest().map(updateStaffCareServiceRequest, StaffCareService.class);
        this._staffCareServiceDao.save(staffCareService);
        return new SuccessResult(Messages.EntityUpdated);
    }

    @Override
    public Result delete(DeleteStaffCareServiceRequest deleteStaffCareServiceRequest) {
        StaffCareService staffCareService = this._modelMapperService.forRequest().map(deleteStaffCareServiceRequest, StaffCareService.class);
        this._staffCareServiceDao.deleteByStaffCareServiceId(staffCareService.getStaffCareServiceId());
        return new SuccessResult(Messages.EntityDeleted);
    }
}
