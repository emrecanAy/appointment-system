package com.emrecan.appointmentsystem.dataAccess.abstracts;

import com.emrecan.appointmentsystem.entities.StaffConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Emrecan
 * @created 26/12/2023 - 23:41
 */
public interface StaffConfigDao extends JpaRepository<StaffConfig, String> {
    StaffConfig getStaffConfigByStaffConfigIdAndIsDeleted(String staffConfigId, boolean isDeleted);
    StaffConfig getStaffConfigByStaffIdAndIsDeleted(String staffId, boolean isDeleted);

    List<StaffConfig> getAllByIsDeleted(boolean isDeleted);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update StaffConfig s set s.isDeleted = true where s.staffConfigId=:staffConfigId")
    void deleteByStaffConfigId(@Param("staffConfigId") String staffConfigId);
}
