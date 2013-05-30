package eu.justas.jweather.data;

import java.io.IOException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import eu.justas.jweather.domain.City;

public interface IWeatherGetter {

	public JSONObject get3rdPartyData(City city) throws IOException, JSONException ;

}
