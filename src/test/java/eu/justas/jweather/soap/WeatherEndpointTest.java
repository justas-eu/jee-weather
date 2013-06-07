package eu.justas.jweather.soap;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import eu.justas.jweather.domain.Weather;
import eu.justas.jweather.scheduler.SchedulerService;

public class WeatherEndpointTest extends AbstractApiTest {

	//TODO: more tests

	@Autowired
	private SchedulerService schedulerService;	
	
	@Test
    public void testWeatherVilnius() throws InterruptedException {

		schedulerService.doSchedule();
		
		List<String> cities = new ArrayList<String>();
		cities.add("vilnius");		
		
        List<Weather> resp = weatherEndpoint.getWeather(cities);
        Assert.assertTrue(resp.size() >  0);
        Assert.assertTrue(resp.get(0).getCity().equalsIgnoreCase("vilnius"));
    }	


}
