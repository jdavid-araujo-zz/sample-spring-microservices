package com.david.departmentservice.exceptiohandler.exception;

public class DepartmentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5014552827880754485L;

	public DepartmentNotFoundException(String errorMessage) {
        super(errorMessage);
    }
	
	public DepartmentNotFoundException() {
        super();
    }
}