package com.sapient.weatherapp.model;

/**
 * @author ayupant
 */

import lombok.Data;

@Data
public class Main {

	private float temp;

	private float temp_min;

	private float temp_max;

	private float pressure;

	private float sea_level;

	private float grnd_level;

	private float humidity;

	private float temp_kf;

}
