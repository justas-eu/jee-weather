package eu.justas.jweather.wunderground;

import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import eu.justas.jweather.data.IWeatherConverter;
import eu.justas.jweather.domain.Weather;
import eu.justas.jweather.domain.gen.WeatherObj;


@Component("wundergroundWeatherConverter")
public class WundergroundWeatherConverter implements IWeatherConverter {
	
	public Weather parseResultToWeather(JSONObject wundergroundJSON) throws JSONException {

		Weather weather = new Weather();
		
		weather.setCity(wundergroundJSON.getJSONObject("current_observation").getJSONObject("display_location")
				.getString("city"));
		
		weather.setHumidity(wundergroundJSON.getJSONObject("current_observation")
				.getString("relative_humidity"));
		
		weather.setObservationFetchTime(new Date());
		
		weather.setObservationTime(new Date(Long.valueOf(wundergroundJSON.getJSONObject("current_observation")
				.getString("observation_epoch")) * 1000));
		
		weather.setTemperature(wundergroundJSON.getJSONObject("current_observation").getInt("temp_c"));
		
		weather.setWeatherDescription(wundergroundJSON.getJSONObject("current_observation").getString("weather"));
		
		weather.setWindDescription(wundergroundJSON.getJSONObject("current_observation").getString("wind_string"));
		
		weather.setWindDirection(wundergroundJSON.getJSONObject("current_observation").getString("wind_dir"));

		weather.setWindSpeed(wundergroundJSON.getJSONObject("current_observation").getString("wind_kph"));
		
		weather.setWindDirDegrees(wundergroundJSON.getJSONObject("current_observation").getString("wind_degrees"));

		weather.setUv(wundergroundJSON.getJSONObject("current_observation").getString("UV"));
		
		weather.setLatitude(wundergroundJSON.getJSONObject("current_observation").getJSONObject("display_location")
				.getString("latitude"));
		weather.setLongitude(wundergroundJSON.getJSONObject("current_observation").getJSONObject("display_location")
				.getString("longitude"));
		
		weather.setIconUrl(wundergroundJSON.getJSONObject("current_observation").getString("icon_url"));

		Gson gson = new Gson();
		
		weather.setWeatherObj(gson.fromJson(wundergroundJSON.toString(), WeatherObj.class));
		
		return weather;

	}

}
