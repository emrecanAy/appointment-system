package com.emrecan.appointmentsystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emrecan.appointmentsystem.entities.CareService;

public interface CareServiceDao extends JpaRepository<CareService, String>{

	CareService getByCareServiceId(String careServiceId);
	List<CareService> getAllCareServicesByIsDeleted(boolean isDeleted);
	
}
