package com.emrecan.appointmentsystem.business.responses.appointment;

import java.time.LocalDateTime;

import com.emrecan.appointmentsystem.entities.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAppointmentResponse {
	private String appointmentId;
	private String customerId;
	private String staffId;
	private LocalDateTime appointmentDate;
	private Status status;
	private String note;
}
