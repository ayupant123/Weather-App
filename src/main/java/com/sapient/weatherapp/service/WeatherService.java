package com.sapient.weatherapp.service;

import java.util.List;

import com.sapient.weatherapp.model.WeatherForecast;

public interface WeatherService {

	List<WeatherForecast> getCityWeather(String city);

}
