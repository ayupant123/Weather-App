package com.sapient.weatherapp.model;

import lombok.Data;

/**
 *
 * @author ayupant
 * @version 1
 */

@Data
public class WeatherForecast {

	private String date;
	private String message;
	private float temprature;
	private boolean rain;

}
