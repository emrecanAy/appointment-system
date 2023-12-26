package com.emrecan.appointmentsystem.business.concretes;

import com.emrecan.appointmentsystem.business.abstracts.StaffConfigService;
import com.emrecan.appointmentsystem.business.constants.Messages;
import com.emrecan.appointmentsystem.business.requests.staffConfig.CreateStaffConfigRequest;
import com.emrecan.appointmentsystem.business.requests.staffConfig.DeleteStaffConfigRequest;
import com.emrecan.appointmentsystem.business.requests.staffConfig.UpdateStaffConfigRequest;
import com.emrecan.appointmentsystem.business.responses.staffConfig.GetAllStaffConfigsResponse;
import com.emrecan.appointmentsystem.business.responses.staffConfig.GetStaffConfigResponse;
import com.emrecan.appointmentsystem.core.utilities.mappers.ModelMapperService;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessDataResult;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessResult;
import com.emrecan.appointmentsystem.dataAccess.abstracts.StaffConfigDao;
import com.emrecan.appointmentsystem.entities.StaffConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Emrecan
 * @created 27/12/2023 - 00:16
 */

@Service
public class StaffConfigManager implements StaffConfigService {

    private final StaffConfigDao _staffConfigDao;
    private final ModelMapperService _modelMapperService;

    @Autowired
    public StaffConfigManager(StaffConfigDao staffConfigDao, ModelMapperService modelMapperService) {
        this._staffConfigDao = staffConfigDao;
        this._modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<GetStaffConfigResponse> getById(String staffConfigId) {
        StaffConfig staffConfig = this._staffConfigDao.getStaffConfigByStaffConfigIdAndIsDeleted(staffConfigId, false);
        GetStaffConfigResponse staffConfigResponse = this._modelMapperService.forResponse().map(staffConfig, GetStaffConfigResponse.class);
        return new SuccessDataResult<>(staffConfigResponse, Messages.EntityListed);
    }

    @Override
    public DataResult<GetStaffConfigResponse> getByStaffId(String staffId) {
        StaffConfig staffConfig = this._staffConfigDao.getStaffConfigByStaffIdAndIsDeleted(staffId, false);
        GetStaffConfigResponse staffConfigResponse = this._modelMapperService.forResponse().map(staffConfig, GetStaffConfigResponse.class);
        return new SuccessDataResult<>(staffConfigResponse, Messages.EntityListed);
    }

    @Override
    public DataResult<List<GetAllStaffConfigsResponse>> getAll() {
        List<StaffConfig> staffConfigs = this._staffConfigDao.getAllByIsDeleted(false);
        List<GetAllStaffConfigsResponse> staffConfigsResponse = staffConfigs.stream().map(staffConfig->this._modelMapperService.forResponse().map(staffConfig, GetAllStaffConfigsResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(staffConfigsResponse, Messages.EntitiesListed);
    }

    @Override
    public DataResult<List<GetAllStaffConfigsResponse>> getAllDeleted() {
        List<StaffConfig> staffConfigs = this._staffConfigDao.getAllByIsDeleted(true);
        List<GetAllStaffConfigsResponse> staffConfigsResponse = staffConfigs.stream().map(staffConfig->this._modelMapperService.forResponse().map(staffConfig, GetAllStaffConfigsResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(staffConfigsResponse, Messages.EntitiesListed);
    }

    @Override
    public Result add(CreateStaffConfigRequest createStaffConfigRequest) {
        StaffConfig staffConfig = this._modelMapperService.forRequest().map(createStaffConfigRequest, StaffConfig.class);
        this._staffConfigDao.save(staffConfig);
        return new SuccessResult(Messages.EntityAdded);
    }

    @Override
    public Result update(UpdateStaffConfigRequest updateStaffConfigRequest) {
        StaffConfig staffConfig = this._modelMapperService.forRequest().map(updateStaffConfigRequest, StaffConfig.class);
        this._staffConfigDao.save(staffConfig);
        return new SuccessResult(Messages.EntityUpdated);
    }

    @Override
    public Result delete(DeleteStaffConfigRequest deleteStaffConfigRequest) {
        StaffConfig staffConfig = this._modelMapperService.forRequest().map(deleteStaffConfigRequest, StaffConfig.class);
        this._staffConfigDao.deleteByStaffConfigId(staffConfig.getStaffConfigId());
        return new SuccessResult(Messages.EntityDeleted);
    }
}
