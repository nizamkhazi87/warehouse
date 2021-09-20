package com.assignment.warehouse.exception;

public class WarehouseException extends RuntimeException{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private final String errorCode;
	
	
	public WarehouseException(String pMessage) {
		super(pMessage);
		errorCode = null;
	}
	
	public WarehouseException(String pErrorCode, String pMessage) {
		super(pMessage);
		errorCode = pErrorCode;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	
	
	

}
