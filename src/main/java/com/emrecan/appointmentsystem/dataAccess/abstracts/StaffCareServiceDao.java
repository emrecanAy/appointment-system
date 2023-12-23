package com.emrecan.appointmentsystem.dataAccess.abstracts;

import com.emrecan.appointmentsystem.entities.StaffCareService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Emrecan
 * @created 23/12/2023 - 21:58
 */
public interface StaffCareServiceDao extends JpaRepository<StaffCareService, String> {
    StaffCareService getByStaffCareServiceId(String staffCareServiceId);
    List<StaffCareService> getAllStaffCareServicesByIsDeleted(boolean isDeleted);
    List<StaffCareService> getAllStaffCareServicesByStaffIdAndIsDeleted(String staffId, boolean isDeleted);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update StaffCareService s set s.isDeleted = true where s.staffCareServiceId=:staffCareServiceId")
    void deleteByStaffCareServiceId(@Param("staffCareServiceId") String staffCareServiceId);
}
