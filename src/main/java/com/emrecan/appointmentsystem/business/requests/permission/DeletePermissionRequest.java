package com.emrecan.appointmentsystem.business.requests.permission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Emrecan
 * @created 27/12/2023 - 16:48
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletePermissionRequest {

    private String permissionId;
}
