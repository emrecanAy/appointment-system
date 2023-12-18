package com.emrecan.appointmentsystem.business.requests.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteAppointmentRequest {

	private String appointmentId;
}
