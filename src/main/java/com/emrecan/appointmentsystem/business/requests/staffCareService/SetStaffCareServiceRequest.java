package com.emrecan.appointmentsystem.business.requests.staffCareService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Emrecan
 * @created 24/12/2023 - 16:31
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetStaffCareServiceRequest {

    private String staffCareServiceId;
}
