package com.emrecan.appointmentsystem.business.requests.staffCareService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Emrecan
 * @created 23/12/2023 - 22:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStaffCareServiceRequest {

    private String careServiceId;
    private String staffId;
    private double careServicePrice;
    private String note;
    private int careServiceDuration;

}
