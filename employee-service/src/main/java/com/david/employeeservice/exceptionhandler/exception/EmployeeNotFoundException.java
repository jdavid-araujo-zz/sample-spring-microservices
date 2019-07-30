package com.david.employeeservice.exceptionhandler.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2994190539164506974L;

	public EmployeeNotFoundException(String errorMessage) {
        super(errorMessage);
    }
	
	public EmployeeNotFoundException() {
        super();
    }
}
