package com.emrecan.appointmentsystem.business.responses.careService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCareServiceResponse {
	
	private String careServiceId;
	private String careServiceName;
	private String careServiceDescription;

}
