package com.sapient.weatherapp.exceptions;

/**
 * Class for handling exception if some data is not found
 *
 * @author ayupant
 * @version 1.0
 * @since 9-11-2022
 *
 */

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
