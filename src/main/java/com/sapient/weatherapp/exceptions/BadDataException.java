package com.sapient.weatherapp.exceptions;

/**
 * Class for handling exception
 *
 * @author ayupant
 * @version 1.0
 * @since 9-11-2022
 *
 */

public class BadDataException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BadDataException(String message) {
		super(message);
	}

}
