package com.emrecan.appointmentsystem.business.requests.careService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCareServiceRequest {

	private String careServiceName;
	private String careServiceDescription;
	private String imagePath;
}
