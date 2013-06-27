package eu.justas.jweather.data;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import eu.justas.jweather.domain.City;
import eu.justas.jweather.domain.Weather;

@Repository
public class WeatherKeeper {
	
	private static final Logger log = LoggerFactory.getLogger(WeatherKeeper.class);
	
	Map<City, Weather> weatherMap = new HashMap<City, Weather>();

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