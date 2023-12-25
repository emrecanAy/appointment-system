package com.emrecan.appointmentsystem.business.abstracts;

import com.emrecan.appointmentsystem.business.requests.staffCareService.CreateStaffCareServiceRequest;
import com.emrecan.appointmentsystem.business.requests.staffCareService.DeleteStaffCareServiceRequest;
import com.emrecan.appointmentsystem.business.requests.staffCareService.UpdateStaffCareServiceRequest;
import com.emrecan.appointmentsystem.business.responses.staffCareService.GetAllStaffCareServicesResponse;
import com.emrecan.appointmentsystem.business.responses.staffCareService.GetStaffCareServiceResponse;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;

import java.util.List;

/**
 * @author Emrecan
 * @created 23/12/2023 - 22:14
 */
public interface StaffCareServiceService {
    DataResult<GetStaffCareServiceResponse> getById(String careServiceId);
    DataResult<List<GetAllStaffCareServicesResponse>> getAll();
    DataResult<List<GetAllStaffCareServicesResponse>> getAllDeleted();
    DataResult<List<GetAllStaffCareServicesResponse>> getAllStaffCareServicesByStaffIdAndIsDeleted(String staffId, boolean isDeleted);
    DataResult<List<GetAllStaffCareServicesResponse>> getAllStaffCareServicesByCareServiceIdAndIsDeleted(String careServiceId, boolean isDeleted);
    Result add(CreateStaffCareServiceRequest createStaffCareServiceRequest);
    Result update(UpdateStaffCareServiceRequest updateStaffCareServiceRequest);
    Result delete(DeleteStaffCareServiceRequest deleteStaffCareServiceRequest);
}
