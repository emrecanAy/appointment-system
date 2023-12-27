package com.emrecan.appointmentsystem.webApi.controllers;

import com.emrecan.appointmentsystem.business.abstracts.PermissionService;
import com.emrecan.appointmentsystem.business.constants.Messages;
import com.emrecan.appointmentsystem.business.requests.permission.CreatePermissionRequest;
import com.emrecan.appointmentsystem.business.requests.permission.DeletePermissionRequest;
import com.emrecan.appointmentsystem.business.requests.permission.SetPermissionStatusRequest;
import com.emrecan.appointmentsystem.business.requests.permission.UpdatePermissionRequest;
import com.emrecan.appointmentsystem.business.responses.permission.GetAllPermissionsResponse;
import com.emrecan.appointmentsystem.business.responses.permission.GetPermissionResponse;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Emrecan
 * @created 27/12/2023 - 17:40
 */

@RestController
@RequestMapping("/api/permissions")
public class PermissionsController {

    private final PermissionService _permissionService;

    @Autowired
    public PermissionsController(PermissionService _permissionService) {
        this._permissionService = _permissionService;
    }

    @GetMapping("/{permissionId}")
    public ResponseEntity<DataResult<GetPermissionResponse>> getById(@PathVariable(name = "permissionId") String permissionId){
        DataResult<GetPermissionResponse> permission = this._permissionService.getById(permissionId);
        if(permission.isSuccess()){
            return new ResponseEntity<>(permission, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(permission, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<GetAllPermissionsResponse>>> getAll(){
        DataResult<List<GetAllPermissionsResponse>> permissions = this._permissionService.getAll();
        if(permissions.isSuccess()){
            return new ResponseEntity<>(permissions, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(permissions, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getalldeleted")
    public ResponseEntity<DataResult<List<GetAllPermissionsResponse>>> getAllDeleted(){
        DataResult<List<GetAllPermissionsResponse>> permissions = this._permissionService.getAllDeleted();
        if(permissions.isSuccess()){
            return new ResponseEntity<>(permissions, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(permissions, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getallwaiting")
    public ResponseEntity<DataResult<List<GetAllPermissionsResponse>>> getAllWaitingPermissions(){
        DataResult<List<GetAllPermissionsResponse>> permissions = this._permissionService.getAllByStatusIsWaiting();
        if(permissions.isSuccess()){
            return new ResponseEntity<>(permissions, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(permissions, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getalldeclined")
    public ResponseEntity<DataResult<List<GetAllPermissionsResponse>>> getAllDeclinedPermissions(){
        DataResult<List<GetAllPermissionsResponse>> permissions = this._permissionService.getAllByStatusIsDeclined();
        if(permissions.isSuccess()){
            return new ResponseEntity<>(permissions, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(permissions, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getallaccepted")
    public ResponseEntity<DataResult<List<GetAllPermissionsResponse>>> getAllAcceptedPermissions(){
        DataResult<List<GetAllPermissionsResponse>> permissions = this._permissionService.getAllByStatusIsAccepted();
        if(permissions.isSuccess()){
            return new ResponseEntity<>(permissions, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(permissions, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getallcancelled")
    public ResponseEntity<DataResult<List<GetAllPermissionsResponse>>> getAllCancelledPermissions(){
        DataResult<List<GetAllPermissionsResponse>> permissions = this._permissionService.getAllByStatusIsCancelled();
        if(permissions.isSuccess()){
            return new ResponseEntity<>(permissions, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(permissions, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/staff/{staffId}")
    public ResponseEntity<DataResult<List<GetAllPermissionsResponse>>> getAllByStaffId(@PathVariable(name = "staffId") String staffId){
        DataResult<List<GetAllPermissionsResponse>> permissions = this._permissionService.getAllByStaffId(staffId);
        if(permissions.isSuccess()){
            return new ResponseEntity<>(permissions, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(permissions, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getallwaiting/staff/{staffId}")
    public ResponseEntity<DataResult<List<GetAllPermissionsResponse>>> getAllWaitingPermissionsByStaffId(@PathVariable(name = "staffId") String staffId){
        DataResult<List<GetAllPermissionsResponse>> permissions = this._permissionService.getAllByStaffIdAndStatusIsWaiting(staffId);
        if(permissions.isSuccess()){
            return new ResponseEntity<>(permissions, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(permissions, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getallaccepted/staff/{staffId}")
    public ResponseEntity<DataResult<List<GetAllPermissionsResponse>>> getAllAcceptedPermissionsByStaffId(@PathVariable(name = "staffId") String staffId){
        DataResult<List<GetAllPermissionsResponse>> permissions = this._permissionService.getAllByStaffIdAndStatusIsAccepted(staffId);
        if(permissions.isSuccess()){
            return new ResponseEntity<>(permissions, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(permissions, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getalldeclined/staff/{staffId}")
    public ResponseEntity<DataResult<List<GetAllPermissionsResponse>>> getAllDeclinedPermissionsByStaffId(@PathVariable(name = "staffId") String staffId){
        DataResult<List<GetAllPermissionsResponse>> permissions = this._permissionService.getAllByStaffIdAndStatusIsDeclined(staffId);
        if(permissions.isSuccess()){
            return new ResponseEntity<>(permissions, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(permissions, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getallcancelled/staff/{staffId}")
    public ResponseEntity<DataResult<List<GetAllPermissionsResponse>>> getAllCancelledPermissionsByStaffId(@PathVariable(name = "staffId") String staffId){
        DataResult<List<GetAllPermissionsResponse>> permissions = this._permissionService.getAllByStaffIdAndStatusIsCancelled(staffId);
        if(permissions.isSuccess()){
            return new ResponseEntity<>(permissions, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(permissions, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody CreatePermissionRequest createPermissionRequest){
        Result result = this._permissionService.add(createPermissionRequest);
        if (result.isSuccess()){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Result> update(@RequestBody UpdatePermissionRequest updatePermissionRequest){
        Result result = this._permissionService.update(updatePermissionRequest);
        if (result.isSuccess()){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Result> delete(@RequestBody DeletePermissionRequest deletePermissionRequest){
        Result result = this._permissionService.delete(deletePermissionRequest);
        if (result.isSuccess()){
            result.setMessage(Messages.EntityDeleted);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/setAccepted")
    public ResponseEntity<Result> setStatusAccepted(@RequestBody SetPermissionStatusRequest setPermissionStatusRequest){
        Result result = this._permissionService.setStatusAccepted(setPermissionStatusRequest);
        if (result.isSuccess()){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/setDeclined")
    public ResponseEntity<Result> setStatusDeclined(@RequestBody SetPermissionStatusRequest setPermissionStatusRequest){
        Result result = this._permissionService.setStatusDeclined(setPermissionStatusRequest);
        if (result.isSuccess()){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/setCancelled")
    public ResponseEntity<Result> setStatusCancelled(@RequestBody SetPermissionStatusRequest setPermissionStatusRequest){
        Result result = this._permissionService.setStatusCancelled(setPermissionStatusRequest);
        if (result.isSuccess()){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/setWaiting")
    public ResponseEntity<Result> setStatusWaiting(@RequestBody SetPermissionStatusRequest setPermissionStatusRequest){
        Result result = this._permissionService.setStatusWaiting(setPermissionStatusRequest);
        if (result.isSuccess()){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }









}
