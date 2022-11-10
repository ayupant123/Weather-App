package com.sapient.weatherapp;

/**
 *
 * Test class for Weather service
 *
 * @author ayupant
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sapient.weatherapp.model.WeatherForecast;
import com.sapient.weatherapp.service.WeatherServiceImpl;

@SpringBootTest
public class WeatherServiceTests {

	@Mock
	WeatherServiceImpl weatherService;

	@Before
	public void init() {
		weatherService = Mockito.mock(WeatherServiceImpl.class);
	}

	@Test
	public void getCityWeatherTest() throws JsonProcessingException {
		List<WeatherForecast> expWeather = new ArrayList<>();
		WeatherForecast weatherForecast = new WeatherForecast();

		weatherForecast.setDate("2022-11-11 00:00:00");
		weatherForecast.setMessage("carry umbrella");
		weatherForecast.setTemprature(24.630005f);
		weatherForecast.setRain(true);
		expWeather.add(weatherForecast);
		weatherForecast.setDate("2022-11-12 00:00:00");
		weatherForecast.setMessage("carry umbrella");
		weatherForecast.setTemprature(25.720001f);
		weatherForecast.setRain(true);
		expWeather.add(weatherForecast);
		weatherForecast.setDate("2022-11-13 00:00:00");
		weatherForecast.setMessage("carry umbrella");
		weatherForecast.setTemprature(25.880005f);
		weatherForecast.setRain(true);
		expWeather.add(weatherForecast);

		Mockito.when(weatherService.getCityWeather("Singapore")).thenReturn(expWeather);
		List<WeatherForecast> expWeatherTest = weatherService.getCityWeather("Singapore");
		Assertions.assertEquals(expWeather, expWeatherTest);

	}

}
