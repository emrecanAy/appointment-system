package com.emrecan.appointmentsystem.business.requests.staffConfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Emrecan
 * @created 26/12/2023 - 23:49
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteStaffConfigRequest {

    private String staffConfigId;
}
