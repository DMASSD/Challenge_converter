package com.conversor;

/**
 * This class contains the ConverterException Exception which 
 * serves mainly to stop the whole operation of the program when
 * the user does not select any option.
 * @author Daniel
 */
public class ConverterException extends RuntimeException{
	
	/**
	 * The ConverterException Exception serves mainly to stop
	 * the whole operation of the program when
	 * the user does not select any option.
	 */
	private static final long serialVersionUID = 1L;

	public ConverterException() {
		super();
	}
	
	public ConverterException(String message) {
		super(message);
	}

	
}
