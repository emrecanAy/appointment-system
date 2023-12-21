package com.emrecan.appointmentsystem.business.requests.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Emrecan
 * @created 21/12/2023 - 16:40
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetCareServiceRequest {

    private String careServiceId;

}
