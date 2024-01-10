package com.emrecan.appointmentsystem.business.requests.appointment;

import java.time.LocalDateTime;
import java.util.List;

import com.emrecan.appointmentsystem.business.requests.staffCareService.SetStaffCareServiceRequest;
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
	private LocalDateTime appointmentDate;
	private String appointmentHour;
	private Status status = Status.WAITING;
	private List<SetStaffCareServiceRequest> staffCareServices;
	private String note;
	
}
