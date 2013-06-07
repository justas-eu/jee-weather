package eu.justas.jweather.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;

import eu.justas.jweather.scheduler.SchedulerService;

public class WeatherResourceTest extends JerseyTest {

	@Autowired
	private SchedulerService schedulerService;

	@Override
	protected AppDescriptor configure() {
		return new WebAppDescriptor.Builder("eu.justas.jweather")
				.contextParam("contextConfigLocation", "classpath:test-applicationContext.xml").contextPath("/")
				.servletClass(SpringServlet.class).contextListenerClass(ContextLoaderListener.class)
				.requestListenerClass(RequestContextListener.class).build();
	}

	@Test
	public void testVilniusWeather() throws InterruptedException {
		WebResource webResource = resource();

		schedulerService = ContextLoaderListener.getCurrentWebApplicationContext().getBean(SchedulerService.class);
		schedulerService.doSchedule();

		// Actually header is not needed, as filter is not applied for test
		// TODO: make test pass the filter
		String responseMsg = webResource.path("weather/vilnius").header("Authorization", "Basic d2VhdGhlcjp3MzR0aDNy")
				.get(String.class);
		assertEquals("Vilnius", responseMsg.substring(23, 30));
	}

}
