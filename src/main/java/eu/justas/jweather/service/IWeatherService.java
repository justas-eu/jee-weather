package eu.justas.jweather.service;

import java.util.List;

import eu.justas.jweather.domain.Weather;

public interface IWeatherService {

	public abstract List<Weather> returnWeather(String city);

}