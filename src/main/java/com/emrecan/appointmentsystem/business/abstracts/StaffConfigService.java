package com.emrecan.appointmentsystem.business.abstracts;

import com.emrecan.appointmentsystem.business.requests.staffConfig.CreateStaffConfigRequest;
import com.emrecan.appointmentsystem.business.requests.staffConfig.DeleteStaffConfigRequest;
import com.emrecan.appointmentsystem.business.requests.staffConfig.UpdateStaffConfigRequest;
import com.emrecan.appointmentsystem.business.responses.staffConfig.GetAllStaffConfigsResponse;
import com.emrecan.appointmentsystem.business.responses.staffConfig.GetStaffConfigResponse;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;

import java.util.List;

/**
 * @author Emrecan
 * @created 26/12/2023 - 23:41
 */
public interface StaffConfigService {
    DataResult<GetStaffConfigResponse> getById(String staffConfigId);
    DataResult<GetStaffConfigResponse> getByStaffId(String staffId);
    DataResult<List<GetAllStaffConfigsResponse>> getAll();
    DataResult<List<GetAllStaffConfigsResponse>> getAllDeleted();
    Result add(CreateStaffConfigRequest createStaffConfigRequest);
    Result update(UpdateStaffConfigRequest updateStaffConfigRequest);
    Result delete(DeleteStaffConfigRequest deleteStaffConfigRequest);

}
