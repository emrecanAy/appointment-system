package com.emrecan.appointmentsystem.business.responses.appointment;

import java.time.LocalDateTime;
import java.util.List;

import com.emrecan.appointmentsystem.business.responses.customer.GetCustomerResponse;
import com.emrecan.appointmentsystem.business.responses.staff.GetStaffResponse;
import com.emrecan.appointmentsystem.business.responses.staffCareService.GetStaffCareServiceResponse;
import com.emrecan.appointmentsystem.entities.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAppointmentResponse {
	private String appointmentId;
	private GetCustomerResponse customer;
	private GetStaffResponse staff;
	private LocalDateTime appointmentDate;
	private Status status;
	private List<GetStaffCareServiceResponse> staffCareServices;
	private String note;
}
