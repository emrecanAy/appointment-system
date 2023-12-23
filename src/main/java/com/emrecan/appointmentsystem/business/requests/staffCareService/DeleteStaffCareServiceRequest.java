package com.emrecan.appointmentsystem.business.requests.staffCareService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Emrecan
 * @created 23/12/2023 - 22:16
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteStaffCareServiceRequest {
    private String staffCareServiceId;
}
