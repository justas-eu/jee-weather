package eu.justas.jweather.xprovider;

import java.io.IOException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import eu.justas.jweather.data.IWeatherGetter;
import eu.justas.jweather.domain.City;

@Component("xProviderWeatherGetter")
public class XProviderWeatherGetter implements IWeatherGetter {

	private static final Logger log = LoggerFactory.getLogger(XProviderWeatherGetter.class);
	
	public JSONObject get3rdPartyData(City city) throws IOException, JSONException {

		JSONObject weatherJSONObject = new JSONObject();
		log.debug("Getting info from xprovider, city: " + city);
		
		weatherJSONObject.put("city", city);
		weatherJSONObject.put("temp", 0);

		return weatherJSONObject;
	}

	public String convertStreamToString(java.io.InputStream is) {
		java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
		return s.hasNext() ? s.next() : "";
	}

}
