package eu.justas.jweather.wunderground;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import eu.justas.jweather.data.IWeatherGetter;
import eu.justas.jweather.domain.City;

@Component
public class WundergroundWeatherGetter implements IWeatherGetter {

	private static final Logger log = LoggerFactory.getLogger(WundergroundWeatherGetter.class);
	
	@Value("${wunderground.api_key}")
	String apiKey;

	@Value("${wunderground.lang_code}")
	String langCode;
	
	@Value("${use.mock.url}")
	String mockUrl;	
	
	public JSONObject get3rdPartyData(City city) throws IOException, JSONException {
		String urlString = "http://api.wunderground.com/api/" + apiKey + "/conditions/lang:"+ langCode + "/q/"
				+ city.getCountryCode() + "/" + city.getName() + ".json";
		
		if (mockUrl.length()>0) urlString = mockUrl;
		
		log.debug("Requesting data from url: " + urlString);
		URL url = new URL(urlString);
		URLConnection conn = url.openConnection();
		InputStream is = conn.getInputStream();

		JSONObject jSONObject = new JSONObject(convertStreamToString(is));
		is.close();

		return jSONObject;
	}

	public String convertStreamToString(java.io.InputStream is) {
		java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
		return s.hasNext() ? s.next() : "";
	}

}
