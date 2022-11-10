package com.sapient.weatherapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.weatherapp.exceptions.ResourceNotFoundException;
import com.sapient.weatherapp.model.WeatherForecast;
import com.sapient.weatherapp.service.WeatherService;

/**
 *
 * Controller class for weather-app
 *
 * @author ayupant
 * @version 1.1
 *
 */

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@GetMapping("/{city}")
	public ResponseEntity<List<WeatherForecast>> getWeatherByCity(@PathVariable String city) {

		if (city == null || city.isBlank()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		try {
			return new ResponseEntity<List<WeatherForecast>>(weatherService.getCityWeather(city), HttpStatus.OK);
		} catch (Exception ex) {
			throw new ResourceNotFoundException("city not found");
		}

	}
}
