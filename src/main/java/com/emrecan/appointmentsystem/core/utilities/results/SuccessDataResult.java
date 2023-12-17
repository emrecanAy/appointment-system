package com.emrecan.appointmentsystem.core.utilities.results;

import java.util.Optional;

import com.emrecan.appointmentsystem.entities.Admin;

public class SuccessDataResult<T> extends DataResult<T> implements IDataResult<T> {
	
	public SuccessDataResult(T data, String message) {
		super(data, true, message);
		
	}
	
	public SuccessDataResult(T data) {
		super(data, true);
		
	}
	
	public SuccessDataResult(String message) {
		super(null, true, message);
		
	}
	
	public SuccessDataResult() {
		super(null, true);
		
	}
}
