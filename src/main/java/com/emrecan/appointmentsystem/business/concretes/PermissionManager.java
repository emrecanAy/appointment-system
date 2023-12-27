package com.emrecan.appointmentsystem.business.concretes;

import com.emrecan.appointmentsystem.business.abstracts.PermissionService;
import com.emrecan.appointmentsystem.business.constants.Messages;
import com.emrecan.appointmentsystem.business.requests.permission.CreatePermissionRequest;
import com.emrecan.appointmentsystem.business.requests.permission.DeletePermissionRequest;
import com.emrecan.appointmentsystem.business.requests.permission.SetPermissionStatusRequest;
import com.emrecan.appointmentsystem.business.requests.permission.UpdatePermissionRequest;
import com.emrecan.appointmentsystem.business.responses.permission.GetAllPermissionsResponse;
import com.emrecan.appointmentsystem.business.responses.permission.GetPermissionResponse;
import com.emrecan.appointmentsystem.core.utilities.mappers.ModelMapperService;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessDataResult;
import com.emrecan.appointmentsystem.core.utilities.results.SuccessResult;
import com.emrecan.appointmentsystem.dataAccess.abstracts.PermissionDao;
import com.emrecan.appointmentsystem.entities.Permission;
import com.emrecan.appointmentsystem.entities.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Emrecan
 * @created 27/12/2023 - 17:08
 */

@Service
public class PermissionManager implements PermissionService {

    private final PermissionDao _permissionDao;
    private final ModelMapperService _modelMapperService;
    @Autowired
    public PermissionManager(PermissionDao permissionDao, ModelMapperService modelMapperService) {
        this._permissionDao = permissionDao;
        this._modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<GetPermissionResponse> getById(String permissionId) {
        Permission permission = this._permissionDao.getPermissionByPermissionId(permissionId);
        GetPermissionResponse permissionResponse = this._modelMapperService.forResponse().map(permission, GetPermissionResponse.class);
        return new SuccessDataResult<>(permissionResponse, Messages.EntityListed);
    }
    @Override
    public DataResult<List<GetAllPermissionsResponse>> getAll() {
        List<Permission> permissions = this._permissionDao.getAllByIsDeleted(false);
        List<GetAllPermissionsResponse> permissionsResponse = permissions.stream().map(permission->this._modelMapperService.forResponse().map(permission, GetAllPermissionsResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(permissionsResponse, Messages.EntitiesListed);
    }

    @Override
    public DataResult<List<GetAllPermissionsResponse>> getAllDeleted() {
        List<Permission> permissions = this._permissionDao.getAllByIsDeleted(true);
        List<GetAllPermissionsResponse> permissionsResponse = permissions.stream().map(permission->this._modelMapperService.forResponse().map(permission, GetAllPermissionsResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(permissionsResponse, Messages.EntitiesListed);
    }

    @Override
    public DataResult<List<GetAllPermissionsResponse>> getAllByStatusIsWaiting() {
        List<Permission> permissions = this._permissionDao.getAllByIsDeletedFalseAndPermissionStatusIs(Status.WAITING);
        List<GetAllPermissionsResponse> permissionsResponse = permissions.stream().map(permission->this._modelMapperService.forResponse().map(permission, GetAllPermissionsResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(permissionsResponse, Messages.EntitiesListed);
    }

    @Override
    public DataResult<List<GetAllPermissionsResponse>> getAllByStatusIsDeclined() {
        List<Permission> permissions = this._permissionDao.getAllByIsDeletedFalseAndPermissionStatusIs(Status.DECLINED);
        List<GetAllPermissionsResponse> permissionsResponse = permissions.stream().map(permission->this._modelMapperService.forResponse().map(permission, GetAllPermissionsResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(permissionsResponse, Messages.EntitiesListed);
    }

    @Override
    public DataResult<List<GetAllPermissionsResponse>> getAllByStatusIsAccepted() {
        List<Permission> permissions = this._permissionDao.getAllByIsDeletedFalseAndPermissionStatusIs(Status.ACCEPTED);
        List<GetAllPermissionsResponse> permissionsResponse = permissions.stream().map(permission->this._modelMapperService.forResponse().map(permission, GetAllPermissionsResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(permissionsResponse, Messages.EntitiesListed);
    }

    @Override
    public DataResult<List<GetAllPermissionsResponse>> getAllByStatusIsCancelled() {
        List<Permission> permissions = this._permissionDao.getAllByIsDeletedFalseAndPermissionStatusIs(Status.CANCELLED);
        List<GetAllPermissionsResponse> permissionsResponse = permissions.stream().map(permission->this._modelMapperService.forResponse().map(permission, GetAllPermissionsResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(permissionsResponse, Messages.EntitiesListed);
    }

    @Override
    public DataResult<List<GetAllPermissionsResponse>> getAllByStaffId(String staffId) {
        List<Permission> permissions = this._permissionDao.getAllByStaffIdAndIsDeleted(staffId, false);
        List<GetAllPermissionsResponse> permissionsResponse = permissions.stream().map(permission->this._modelMapperService.forResponse().map(permission, GetAllPermissionsResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(permissionsResponse, Messages.EntitiesListed);
    }

    @Override
    public DataResult<List<GetAllPermissionsResponse>> getAllByStaffIdAndStatusIsWaiting(String staffId) {
        List<Permission> permissions = this._permissionDao.getAllByIsDeletedFalseAndStaffIdAndAndPermissionStatusIs(staffId, Status.WAITING);
        List<GetAllPermissionsResponse> permissionsResponse = permissions.stream().map(permission->this._modelMapperService.forResponse().map(permission, GetAllPermissionsResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(permissionsResponse, Messages.EntitiesListed);
    }

    @Override
    public DataResult<List<GetAllPermissionsResponse>> getAllByStaffIdAndStatusIsAccepted(String staffId) {
        List<Permission> permissions = this._permissionDao.getAllByIsDeletedFalseAndStaffIdAndAndPermissionStatusIs(staffId, Status.ACCEPTED);
        List<GetAllPermissionsResponse> permissionsResponse = permissions.stream().map(permission->this._modelMapperService.forResponse().map(permission, GetAllPermissionsResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(permissionsResponse, Messages.EntitiesListed);
    }

    @Override
    public DataResult<List<GetAllPermissionsResponse>> getAllByStaffIdAndStatusIsDeclined(String staffId) {
        List<Permission> permissions = this._permissionDao.getAllByIsDeletedFalseAndStaffIdAndAndPermissionStatusIs(staffId, Status.DECLINED);
        List<GetAllPermissionsResponse> permissionsResponse = permissions.stream().map(permission->this._modelMapperService.forResponse().map(permission, GetAllPermissionsResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(permissionsResponse, Messages.EntitiesListed);
    }

    @Override
    public DataResult<List<GetAllPermissionsResponse>> getAllByStaffIdAndStatusIsCancelled(String staffId) {
        List<Permission> permissions = this._permissionDao.getAllByIsDeletedFalseAndStaffIdAndAndPermissionStatusIs(staffId, Status.CANCELLED);
        List<GetAllPermissionsResponse> permissionsResponse = permissions.stream().map(permission->this._modelMapperService.forResponse().map(permission, GetAllPermissionsResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(permissionsResponse, Messages.EntitiesListed);
    }

    @Override
    public Result add(CreatePermissionRequest createPermissionRequest) {
        Permission permission = this._modelMapperService.forRequest().map(createPermissionRequest, Permission.class);
        this._permissionDao.save(permission);
        return new SuccessResult(Messages.EntityAdded);
    }

    @Override
    public Result update(UpdatePermissionRequest updatePermissionRequest) {
        Permission permission = this._modelMapperService.forRequest().map(updatePermissionRequest, Permission.class);
        this._permissionDao.save(permission);
        return new SuccessResult(Messages.EntityUpdated);
    }

    @Override
    public Result delete(DeletePermissionRequest deletePermissionRequest) {
        Permission permission = this._modelMapperService.forRequest().map(deletePermissionRequest, Permission.class);
        permission.setDeleted(false);
        this._permissionDao.save(permission);
        return new SuccessResult(Messages.EntityDeleted);
    }

    @Override
    public Result setStatusAccepted(SetPermissionStatusRequest setPermissionStatusRequest) {
        this._permissionDao.setStatusAccepted(setPermissionStatusRequest.getPermissionId());
        return new SuccessResult(Messages.EntityUpdated);
    }

    @Override
    public Result setStatusDeclined(SetPermissionStatusRequest setPermissionStatusRequest) {
        this._permissionDao.setStatusDeclined(setPermissionStatusRequest.getPermissionId());
        return new SuccessResult(Messages.EntityUpdated);
    }

    @Override
    public Result setStatusCancelled(SetPermissionStatusRequest setPermissionStatusRequest) {
        this._permissionDao.setStatusCancelled(setPermissionStatusRequest.getPermissionId());
        return new SuccessResult(Messages.EntityUpdated);
    }

    @Override
    public Result setStatusWaiting(SetPermissionStatusRequest setPermissionStatusRequest) {
        this._permissionDao.setStatusWaiting(setPermissionStatusRequest.getPermissionId());
        return new SuccessResult(Messages.EntityUpdated);
    }
}
