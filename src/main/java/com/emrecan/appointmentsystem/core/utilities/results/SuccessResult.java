package com.emrecan.appointmentsystem.core.utilities.results;

public class SuccessResult extends Result implements IResult {

	public SuccessResult() {
		super(true);
		
	}
	
	public SuccessResult(String message) {
		super(true, message);
	}
	
}
