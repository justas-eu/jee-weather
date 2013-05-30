package eu.justas.jweather.soap;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
public abstract class AbstractApiTest {
 
    @Autowired
    @Qualifier("weatherEndpoint")
    protected IWeatherEndpoint weatherEndpoint;		

}