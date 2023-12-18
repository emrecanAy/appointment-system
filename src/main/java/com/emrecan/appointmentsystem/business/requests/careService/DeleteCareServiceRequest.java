package com.emrecan.appointmentsystem.business.requests.careService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCareServiceRequest {

	private String careServiceId;
}
