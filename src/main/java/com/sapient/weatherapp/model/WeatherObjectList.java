package com.sapient.weatherapp.model;

/**
 * @author ayupant
 */

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class WeatherObjectList {

	private float dt;

	private Main main;

	private List<WeatherDetail> weather = new ArrayList<WeatherDetail>();

	private Clouds clouds;

	private Wind wind;

	private Sys sys;

	private String dt_txt;

}
