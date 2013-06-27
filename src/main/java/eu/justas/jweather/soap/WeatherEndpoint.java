package eu.justas.jweather.soap;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.justas.jweather.domain.Weather;
import eu.justas.jweather.service.WeatherService;

@Component
public class WeatherEndpoint implements IWeatherEndpoint {

	private static final Logger log = LoggerFactory.getLogger(WeatherEndpoint.class);

	@Autowired
	private WeatherService weatherService;

	@Override
	public List<Weather> getWeather(List<String> cities) {

		List<Weather> weathers = new ArrayList<Weather>();

		if (cities != null) {
			log.debug("Soap request for (" + cities.size() + ") cities " + cities);

			for (String city : cities) {
				weathers.addAll(weatherService.returnWeather(city));
			}
		}
		else {
			weathers = weatherService.returnWeather(null);
		}

		return weathers;
	}
}
