package com.emrecan.appointmentsystem.business.responses.staffConfig;

import com.emrecan.appointmentsystem.business.responses.staff.GetStaffResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

/**
 * @author Emrecan
 * @created 26/12/2023 - 23:50
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetStaffConfigResponse {

    private String staffConfigId;
    private GetStaffResponse staff;
    private LocalTime startShiftHour;
    private LocalTime endShiftHour;
    private LocalTime breakHour;
    private int breakTime; //minutes
    private int slotSpacing; //minutes
}
