package eu.justas.jweather.soap;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import eu.justas.jweather.domain.Weather;

@WebService
public interface IWeatherEndpoint {

	@WebResult(name = "response")
	List<Weather> getWeather(@WebParam(name = "listOfCities") List<String> cities);

}