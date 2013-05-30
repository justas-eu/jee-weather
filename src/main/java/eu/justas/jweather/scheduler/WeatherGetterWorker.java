package eu.justas.jweather.scheduler;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import eu.justas.jweather.data.IWeatherConverter;
import eu.justas.jweather.data.IWeatherGetter;
import eu.justas.jweather.data.WeatherKeeper;
import eu.justas.jweather.domain.City;
import eu.justas.jweather.domain.Weather;

@Component("weatherGetterWorker")
public class WeatherGetterWorker implements Worker {

	private static final Logger log = LoggerFactory.getLogger(WeatherGetterWorker.class);
	
	@Autowired
	private IWeatherConverter weatherConverter;

	@Autowired
	private IWeatherGetter weatherGetter;	
	
	@Value("${api.getter.delay}")
	int delaySec;		
	
	@Override
	public void work() {
		for (City cityEnum: City.values()) {
			Weather weather = null;
			try {
				
				//respect the api limit
				if (allowUpdate(cityEnum)) {
					JSONObject wundergroundJSON = weatherGetter.get3rdPartyData(cityEnum);
					weather = weatherConverter.parseResultToWeather(wundergroundJSON);
				}

				 Thread.sleep(delaySec * 1000);				
				
			} catch (IOException e) {
				log.error("3rd part service exception.", e);
			} catch (JSONException e) {
				log.error("API format exception.", e);
			} catch (InterruptedException e) {
				log.error("InterruptedException" , e);
			}
			if (weather != null) WeatherKeeper.getInstance().updateDB(weather, cityEnum);
		}
	}
	
	private boolean allowUpdate(City city) {
		Weather weather = WeatherKeeper.getInstance().getWeatherForCity(city);
		if (weather == null) return true;
		long observationAge = (((new Date()).getTime()) - weather.getObservationFetchTime().getTime()) / (1000*60);
		log.debug(" Observation age: "  + observationAge + " min");
		if (observationAge > 15 ) 
			return true;
		else {
			log.debug("Weather info no older then 5minutes. Will not update. (" + city.getName() + ")");
			return false;
		}
	}
}
