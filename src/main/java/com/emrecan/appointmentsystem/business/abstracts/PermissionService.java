package com.emrecan.appointmentsystem.business.abstracts;

import com.emrecan.appointmentsystem.business.requests.permission.CreatePermissionRequest;
import com.emrecan.appointmentsystem.business.requests.permission.DeletePermissionRequest;
import com.emrecan.appointmentsystem.business.requests.permission.SetPermissionStatusRequest;
import com.emrecan.appointmentsystem.business.requests.permission.UpdatePermissionRequest;
import com.emrecan.appointmentsystem.business.responses.permission.GetAllPermissionsResponse;
import com.emrecan.appointmentsystem.business.responses.permission.GetPermissionResponse;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;

import java.util.List;

/**
 * @author Emrecan
 * @created 27/12/2023 - 16:47
 */
public interface PermissionService {
    DataResult<GetPermissionResponse> getById(String permissionId);
    DataResult<List<GetAllPermissionsResponse>> getAll();
    DataResult<List<GetAllPermissionsResponse>> getAllDeleted();
    DataResult<List<GetAllPermissionsResponse>> getAllByStatusIsWaiting();
    DataResult<List<GetAllPermissionsResponse>> getAllByStatusIsDeclined();
    DataResult<List<GetAllPermissionsResponse>> getAllByStatusIsAccepted();
    DataResult<List<GetAllPermissionsResponse>> getAllByStatusIsCancelled();
    DataResult<List<GetAllPermissionsResponse>> getAllByStaffId(String staffId);
    DataResult<List<GetAllPermissionsResponse>> getAllByStaffIdAndStatusIsWaiting(String staffId);
    DataResult<List<GetAllPermissionsResponse>> getAllByStaffIdAndStatusIsAccepted(String staffId);
    DataResult<List<GetAllPermissionsResponse>> getAllByStaffIdAndStatusIsDeclined(String staffId);
    DataResult<List<GetAllPermissionsResponse>> getAllByStaffIdAndStatusIsCancelled(String staffId);
    Result add(CreatePermissionRequest createPermissionRequest);
    Result update(UpdatePermissionRequest updatePermissionRequest);
    Result delete(DeletePermissionRequest deletePermissionRequest);

    Result setStatusAccepted(SetPermissionStatusRequest setPermissionStatusRequest);
    Result setStatusDeclined(SetPermissionStatusRequest setPermissionStatusRequest);
    Result setStatusCancelled(SetPermissionStatusRequest setPermissionStatusRequest);
    Result setStatusWaiting(SetPermissionStatusRequest setPermissionStatusRequest);

}
