package com.emrecan.appointmentsystem.webApi.controllers;

import com.emrecan.appointmentsystem.business.abstracts.StaffConfigService;
import com.emrecan.appointmentsystem.business.constants.Messages;
import com.emrecan.appointmentsystem.business.requests.staffConfig.CreateStaffConfigRequest;
import com.emrecan.appointmentsystem.business.requests.staffConfig.DeleteStaffConfigRequest;
import com.emrecan.appointmentsystem.business.requests.staffConfig.UpdateStaffConfigRequest;
import com.emrecan.appointmentsystem.business.responses.staffConfig.GetAllStaffConfigsResponse;
import com.emrecan.appointmentsystem.business.responses.staffConfig.GetStaffConfigResponse;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Emrecan
 * @created 27/12/2023 - 01:17
 */

@RestController
@RequestMapping("/api/staffconfigs")
public class StaffConfigsController {

    private final StaffConfigService _staffConfigService;
    @Autowired
    public StaffConfigsController(StaffConfigService staffConfigService) {
        this._staffConfigService = staffConfigService;
    }

    @GetMapping("/{staffConfigId}")
    public ResponseEntity<DataResult<GetStaffConfigResponse>> getById(@PathVariable(name = "staffConfigId") String staffConfigId){
        DataResult<GetStaffConfigResponse> staffConfig = this._staffConfigService.getById(staffConfigId);
        if(staffConfig.isSuccess()){
            return new ResponseEntity<>(staffConfig, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(staffConfig, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/staff/{staffId}")
    public ResponseEntity<DataResult<GetStaffConfigResponse>> getByStaffId(@PathVariable(name = "staffId") String staffId){
        DataResult<GetStaffConfigResponse> staffConfig = this._staffConfigService.getByStaffId(staffId);
        if(staffConfig.isSuccess()){
            return new ResponseEntity<>(staffConfig, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(staffConfig, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<GetAllStaffConfigsResponse>>> getAll(){
        DataResult<List<GetAllStaffConfigsResponse>> staffConfig = this._staffConfigService.getAll();
        if(staffConfig.isSuccess()){
            return new ResponseEntity<>(staffConfig, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(staffConfig, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getalldeleted")
    public ResponseEntity<DataResult<List<GetAllStaffConfigsResponse>>> getAllDeleted(){
        DataResult<List<GetAllStaffConfigsResponse>> staffConfig = this._staffConfigService.getAllDeleted();
        if(staffConfig.isSuccess()){
            return new ResponseEntity<>(staffConfig, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(staffConfig, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody CreateStaffConfigRequest createStaffConfigRequest) {
        Result result = this._staffConfigService.add(createStaffConfigRequest);
        if(result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Result> update(@RequestBody UpdateStaffConfigRequest updateStaffConfigRequest) {
        Result result = this._staffConfigService.update(updateStaffConfigRequest);
        if(result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/delete")
    public ResponseEntity<Result> delete(@RequestBody DeleteStaffConfigRequest deleteStaffConfigRequest) {
        Result result = this._staffConfigService.delete(deleteStaffConfigRequest);
        if(result.isSuccess()) {
            result.setMessage(Messages.EntityDeleted);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }






}
