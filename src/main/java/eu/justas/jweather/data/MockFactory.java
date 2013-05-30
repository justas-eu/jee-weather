package eu.justas.jweather.data;

import java.util.Date;

import eu.justas.jweather.domain.Weather;

public class MockFactory {

	public static Weather mockWeather () {
		Weather weather = new Weather();
		weather.setCity("Vilnius");
		weather.setHumidity("51%");
		weather.setObservationTime(new Date());
		weather.setTemperature(25);
		weather.setWeatherDescription("Good");
		weather.setWindDescription("Weak");
		weather.setWindDirection("SW");
		return weather;
	}
	
}
