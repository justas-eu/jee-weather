package eu.justas.jweather.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.justas.jweather.domain.Weather;
import eu.justas.jweather.service.WeatherService;

@Component
@Path("/weather")
public class WeatherResource {

	@Autowired
	private WeatherService weatherService;

	@GET
	@Path("/{city}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Weather> getWeatherForCity(@PathParam("city") String city) {
		return weatherService.returnWeather(city);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<Weather> getWeather() {
		return weatherService.returnWeather(null);
	}

}