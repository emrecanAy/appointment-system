package com.emrecan.appointmentsystem.core.utilities.results;

public class ErrorResult extends Result implements IResult{

	public ErrorResult() {
		super(false);
		
	}
	
	public ErrorResult(String message) {
		super(false, message);
	}
	
}
