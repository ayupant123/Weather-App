package com.sapient.weatherapp.model;

/**
 * @author ayupant
 */

import lombok.Data;

@Data
public class WeatherDetail {

	private float id;

	private String main;

	private String description;

	private String icon;

}
