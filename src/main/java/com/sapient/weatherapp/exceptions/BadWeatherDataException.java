package com.sapient.weatherapp.exceptions;

public class BadWeatherDataException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public BadWeatherDataException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BadWeatherDataException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BadWeatherDataException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BadWeatherDataException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BadWeatherDataException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
