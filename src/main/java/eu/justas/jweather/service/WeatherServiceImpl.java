package eu.justas.jweather.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import eu.justas.jweather.data.WeatherKeeper;
import eu.justas.jweather.domain.City;
import eu.justas.jweather.domain.Weather;
import eu.justas.jweather.exception.CityNotSupportedException;
import eu.justas.jweather.exception.DataNotStoredException;

@Component
public class WeatherServiceImpl implements IWeatherService {

	private static final Logger log = LoggerFactory.getLogger(WeatherServiceImpl.class);

	@Override
	public List<Weather> returnWeather(String city) {
		
		List<Weather> listOfWeather = new ArrayList<Weather>();

		if (city != null) {
			City cityEnum = City.getByName(city);
			if (cityEnum == null) {
				log.error("City not supported: " + city);
				throw new CityNotSupportedException("City not supported: " + city);
			}

			Weather weather = WeatherKeeper.getInstance().getWeatherForCity(cityEnum);

			if (weather == null) {
				log.error("Weather observation for city is not available: " + city);
				throw new DataNotStoredException("Weather observation for city is not available. Please try later.");
			}

			listOfWeather.add(weather);
			
		} else {

			for (City cityEnum : City.values()) {
				Weather weather = WeatherKeeper.getInstance().getWeatherForCity(cityEnum);
				if (weather != null) listOfWeather.add(weather);
			}

			if (listOfWeather.size() < 1) {
				throw new DataNotStoredException("Weather observation for cities not available. Please try later.");
			}

		}
		return listOfWeather;

	}

}
