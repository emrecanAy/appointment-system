package com.emrecan.appointmentsystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emrecan.appointmentsystem.entities.CareService;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CareServiceDao extends JpaRepository<CareService, String>{

	CareService getByCareServiceId(String careServiceId);
	List<CareService> getAllCareServicesByIsDeleted(boolean isDeleted);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update CareService c set c.isDeleted = true where c.careServiceId=:careServiceId")
	void deleteByCareServiceId(@Param("careServiceId") String careServiceId);
	
}
