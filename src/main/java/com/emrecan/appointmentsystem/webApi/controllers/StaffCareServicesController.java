package com.emrecan.appointmentsystem.webApi.controllers;

import com.emrecan.appointmentsystem.business.abstracts.StaffCareServiceService;
import com.emrecan.appointmentsystem.business.requests.staffCareService.CreateStaffCareServiceRequest;
import com.emrecan.appointmentsystem.business.requests.staffCareService.DeleteStaffCareServiceRequest;
import com.emrecan.appointmentsystem.business.requests.staffCareService.UpdateStaffCareServiceRequest;
import com.emrecan.appointmentsystem.business.responses.staffCareService.GetAllStaffCareServicesResponse;
import com.emrecan.appointmentsystem.business.responses.staffCareService.GetStaffCareServiceResponse;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Emrecan
 * @created 23/12/2023 - 22:56
 */

@RestController
@RequestMapping("/api/staffcareservices")
public class StaffCareServicesController {

    private final StaffCareServiceService _staffCareServiceService;
    @Autowired
    public StaffCareServicesController(StaffCareServiceService staffCareServiceService) {
        this._staffCareServiceService = staffCareServiceService;
    }

    @GetMapping("/{staffCareServiceId}")
    public ResponseEntity<DataResult<GetStaffCareServiceResponse>> getById(@PathVariable(name = "staffCareServiceId") String staffCareServiceId) {
        DataResult<GetStaffCareServiceResponse> staffCareService = this._staffCareServiceService.getById(staffCareServiceId);
        if(staffCareService.isSuccess()) {
            return new ResponseEntity<>(staffCareService, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(staffCareService, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<GetAllStaffCareServicesResponse>>> getAll(){
        DataResult<List<GetAllStaffCareServicesResponse>> careServices = this._staffCareServiceService.getAll();
        if(careServices.isSuccess()) {
            return new ResponseEntity<>(careServices, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(careServices, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getalldeleted")
    public ResponseEntity<DataResult<List<GetAllStaffCareServicesResponse>>> getAllDeleted(){
        DataResult<List<GetAllStaffCareServicesResponse>> careServices = this._staffCareServiceService.getAllDeleted();
        if(careServices.isSuccess()) {
            return new ResponseEntity<>(careServices, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(careServices, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getallbystaff/{staffId}")
    public ResponseEntity<DataResult<List<GetAllStaffCareServicesResponse>>> getAllStaffCareServicesByStaff(@PathVariable(name = "staffId") String staffId){
        DataResult<List<GetAllStaffCareServicesResponse>> careServices = this._staffCareServiceService.getAllStaffCareServicesByStaffIdAndIsDeleted(staffId, false);
        if(careServices.isSuccess()) {
            return new ResponseEntity<>(careServices, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(careServices, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getallbycareservice/{careServiceId}")
    public ResponseEntity<DataResult<List<GetAllStaffCareServicesResponse>>> getAllStaffCareServicesByCareService(@PathVariable(name = "careServiceId") String careServiceId){
        DataResult<List<GetAllStaffCareServicesResponse>> careServices = this._staffCareServiceService.getAllStaffCareServicesByCareServiceIdAndIsDeleted(careServiceId, false);
        if(careServices.isSuccess()) {
            return new ResponseEntity<>(careServices, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(careServices, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getalldeletedbystaff/{staffId}")
    public ResponseEntity<DataResult<List<GetAllStaffCareServicesResponse>>> getAllDeletedStaffCareServicesByStaff(@PathVariable(name = "staffId") String staffId){
        DataResult<List<GetAllStaffCareServicesResponse>> careServices = this._staffCareServiceService.getAllStaffCareServicesByStaffIdAndIsDeleted(staffId, true);
        if(careServices.isSuccess()) {
            return new ResponseEntity<>(careServices, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(careServices, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody CreateStaffCareServiceRequest createStaffCareServiceRequest) {
        Result result = this._staffCareServiceService.add(createStaffCareServiceRequest);
        if(result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Result> update(@RequestBody UpdateStaffCareServiceRequest updateStaffCareServiceRequest) {
        Result result = this._staffCareServiceService.update(updateStaffCareServiceRequest);
        if(result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/delete")
    public ResponseEntity<Result> delete(@RequestBody DeleteStaffCareServiceRequest deleteStaffCareServiceRequest) {
        Result result = this._staffCareServiceService.delete(deleteStaffCareServiceRequest);
        if(result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }






}
