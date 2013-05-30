package eu.justas.jweather.data;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import eu.justas.jweather.domain.Weather;

public interface IWeatherConverter {
	
	public Weather parseResultToWeather(JSONObject wundergroundJSON) throws JSONException;

}
