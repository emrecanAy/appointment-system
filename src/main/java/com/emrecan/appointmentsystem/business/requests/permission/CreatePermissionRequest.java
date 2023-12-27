package com.emrecan.appointmentsystem.business.requests.permission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author Emrecan
 * @created 27/12/2023 - 16:48
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePermissionRequest {

    private String staffId;
    private LocalDateTime permissionDate;
    private LocalTime permissionStartHour;
    private LocalTime permissionEndHour;
    private String permissionReason;

}
