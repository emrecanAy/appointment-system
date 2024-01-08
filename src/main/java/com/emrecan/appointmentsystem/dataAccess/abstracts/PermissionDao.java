package com.emrecan.appointmentsystem.dataAccess.abstracts;

import com.emrecan.appointmentsystem.entities.Permission;
import com.emrecan.appointmentsystem.entities.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Emrecan
 * @created 27/12/2023 - 16:46
 */
public interface PermissionDao extends JpaRepository<Permission, String> {
    Permission getPermissionByPermissionId(String permissionId);
    List<Permission> getAllPermissionsByIsDeletedOrderByPermissionDateDesc(boolean isDeleted);
    List<Permission> getAllByIsDeletedFalseAndPermissionStatusIs(Status status);
    List<Permission> getAllByStaffIdAndIsDeleted(String staffId, boolean isDeleted);
    List<Permission> getAllByIsDeletedFalseAndStaffIdAndAndPermissionStatusIs(String staffId, Status status);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Permission p set p.permissionStatus = 0 where p.permissionId=:permissionId")
    void setStatusAccepted(String permissionId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Permission p set p.permissionStatus = 2 where p.permissionId=:permissionId")
    void setStatusDeclined(String permissionId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Permission p set p.permissionStatus = 3 where p.permissionId=:permissionId")
    void setStatusCancelled(String permissionId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Permission p set p.permissionStatus = 1 where p.permissionId=:permissionId")
    void setStatusWaiting(String permissionId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Permission p set p.isDeleted = true where p.permissionId=:permissionId")
    void deleteByPermissionId(@Param("permissionId") String permissionId);


}
