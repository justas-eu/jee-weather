package eu.justas.jweather.soap;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import eu.justas.jweather.domain.Weather;

public class WeatherEndpointTest extends AbstractApiTest {

	//TODO: more tests
	
	@Test
    public void testWeatherVilnius() throws InterruptedException {

		Thread.sleep(3500);

		List<String> cities = new ArrayList<String>();
		cities.add("vilnius");		
		
        List<Weather> resp = weatherEndpoint.getWeather(cities);
        Assert.assertTrue(resp.size() >  0);
        Assert.assertTrue(resp.get(0).getCity().equalsIgnoreCase("vilnius"));
    }	


}
