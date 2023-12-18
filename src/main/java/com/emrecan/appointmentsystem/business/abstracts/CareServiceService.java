package com.emrecan.appointmentsystem.business.abstracts;

import java.util.List;

import com.emrecan.appointmentsystem.business.requests.careService.CreateCareServiceRequest;
import com.emrecan.appointmentsystem.business.requests.careService.DeleteCareServiceRequest;
import com.emrecan.appointmentsystem.business.requests.careService.UpdateCareServiceRequest;
import com.emrecan.appointmentsystem.business.responses.careService.GetAllCareServicesResponse;
import com.emrecan.appointmentsystem.business.responses.careService.GetCareServiceResponse;
import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.entities.CareService;

public interface CareServiceService {

	DataResult<GetCareServiceResponse> getById(String careServiceId);
	DataResult<List<GetAllCareServicesResponse>> getAll();
	DataResult<List<GetAllCareServicesResponse>> getAllDeleted();
	Result add(CreateCareServiceRequest createCareServiceRequest);
	Result update(UpdateCareServiceRequest updateCareServiceRequest);
	Result delete(DeleteCareServiceRequest deleteCareServiceRequest);
	
}
