package com.emrecan.appointmentsystem.business.responses.appointment;

import java.sql.Date;
import java.util.List;

import com.emrecan.appointmentsystem.entities.CareService;
import com.emrecan.appointmentsystem.entities.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAppointmentsResponse {
	private String appointmentId;
	private String customerId;
	private String staffId;
	private Date appointmentDate;
	private Status status;
	private List<CareService> careServices;
	private String note;
}
