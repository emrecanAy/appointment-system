package com.emrecan.appointmentsystem.business.responses.permission;

import com.emrecan.appointmentsystem.business.responses.staff.GetStaffResponse;
import com.emrecan.appointmentsystem.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author Emrecan
 * @created 27/12/2023 - 16:49
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPermissionResponse {
    private String permissionId;
    private GetStaffResponse staff;
    private LocalDateTime permissionDate;
    private LocalTime permissionStartHour;
    private LocalTime permissionEndHour;
    private String permissionReason;
    private Status status;
}
