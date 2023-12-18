package com.emrecan.appointmentsystem.business.abstracts;

import java.util.List;

import com.emrecan.appointmentsystem.core.utilities.results.DataResult;
import com.emrecan.appointmentsystem.core.utilities.results.Result;
import com.emrecan.appointmentsystem.entities.CareService;

public interface CareServiceService {

	DataResult<CareService> getById(String careServiceId);
	DataResult<List<CareService>> getAll();
	DataResult<List<CareService>> getAllDeleted();
	Result add(CareService careService);
	Result update(CareService careService);
	Result delete(CareService careService);
	
}
