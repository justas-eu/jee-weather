package eu.justas.jweather.xprovider;

import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;

import eu.justas.jweather.data.IWeatherConverter;
import eu.justas.jweather.domain.Weather;


@Component("xProviderWeatherConverter")
public class XProviderWeatherConverter implements IWeatherConverter {
	
	public Weather parseResultToWeather(JSONObject xproviderJSON) throws JSONException {

		Weather weather = new Weather();

		weather.setCity(xproviderJSON.getString("city"));
		weather.setTemperature(xproviderJSON.getInt("temp"));
		weather.setObservationFetchTime(new Date());

		
		return weather;

	}

}
