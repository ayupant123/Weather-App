package com.sapient.weatherapp.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sapient.weatherapp.exceptions.BadWeatherDataException;
import com.sapient.weatherapp.model.Weather;
import com.sapient.weatherapp.model.WeatherForecast;
import com.sapient.weatherapp.model.WeatherObjectList;
import com.sapient.weatherapp.util.WeatherUtil;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Override
	public List<WeatherForecast> getCityWeather(String city) {
		RestTemplate restTemplate = new RestTemplate();

		String api = "http://api.openweathermap.org/data/2.5/forecast?q=" + city
				+ "&appid=518d82833e287e14f99a144a1edeb62a";
		Weather weather = restTemplate.getForObject(api, Weather.class);

		List<WeatherForecast> weatherList = new ArrayList<>();

		List<WeatherObjectList> list = weather.getList();

		List<WeatherObjectList> nextThreeDaysWeather = new ArrayList<>();

		int count = 1;

		for (WeatherObjectList li : list) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDate now = LocalDate.now().plusDays(count);
			if (li.getDt_txt().contains(now.toString())) {
				nextThreeDaysWeather.add(li);
				count++;
			}
		}

		for (WeatherObjectList weatherObjectList : nextThreeDaysWeather.subList(0, 3)) {

			WeatherForecast weatherForecast = new WeatherForecast();

			if (weatherObjectList.getMain() == null) {
				throw new BadWeatherDataException("external API is incorrect");
			}

			weatherForecast.setDate(weatherObjectList.getDt_txt());

			float temperatureInCelsius = WeatherUtil.convertTempToCelcius(weatherObjectList.getMain().getTemp());

			if (temperatureInCelsius > 40.0) {
				weatherForecast.setMessage("use sunscreen lotion");
			} else if (weatherObjectList.getWeather().get(0).getMain().equalsIgnoreCase("rain")) {
				weatherForecast.setMessage("carry umbrella");
				weatherForecast.setRain(true);
			} else {
				weatherForecast.setMessage(weatherObjectList.getWeather().get(0).getMain());
			}

			weatherForecast.setTemprature(temperatureInCelsius);

			weatherList.add(weatherForecast);
		}

		return weatherList;

	}

}
