package com.emrecan.appointmentsystem.business.requests.appointment;

import java.sql.Date;

import com.emrecan.appointmentsystem.entities.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAppointmentRequest {

	private String customerId;
	private String staffId;
	private Date appointmentDate;
	private Status status = Status.WAITING;
	private String note;
	
}
