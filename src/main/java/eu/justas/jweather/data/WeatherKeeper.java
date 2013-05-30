package eu.justas.jweather.data;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.justas.jweather.domain.City;
import eu.justas.jweather.domain.Weather;

public class WeatherKeeper {
	
	private static final Logger log = LoggerFactory.getLogger(WeatherKeeper.class);
	
	private static WeatherKeeper instance = null;
	
	Map<City, Weather> weatherMap = new HashMap<City, Weather>();
	
	protected WeatherKeeper() {
	}

	public static WeatherKeeper getInstance() {
		if (instance == null) {
			instance = new WeatherKeeper();
		}
		return instance;
	}

	public void updateDB(Weather weather, City cityEnum) {
		log.debug("Updating weather information for city: " + cityEnum.getName());
		log.debug(weather.toString());
		weatherMap.put(cityEnum, weather);
		log.debug("WeatherMap contains info for number " + weatherMap.size() + " of cities");
	}
	
	public Weather getWeatherForCity(City city) {
		Weather weather = weatherMap.get(city);
		log.debug("Search for weather city: " + city.getName() + ((weather == null) ? " NOT FOUND." : " STORED."));

		return weather;
	}
	
}