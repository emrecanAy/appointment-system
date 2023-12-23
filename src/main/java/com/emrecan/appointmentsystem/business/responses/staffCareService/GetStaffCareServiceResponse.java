package com.emrecan.appointmentsystem.business.responses.staffCareService;

import com.emrecan.appointmentsystem.business.responses.careService.GetCareServiceResponse;
import com.emrecan.appointmentsystem.business.responses.staff.GetStaffResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Emrecan
 * @created 23/12/2023 - 22:17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetStaffCareServiceResponse {

    private String staffCareServiceId;
    private GetCareServiceResponse careService;
    private GetStaffResponse staff;
    private double careServicePrice;
    private String note;
    private int careServiceDuration;
}
