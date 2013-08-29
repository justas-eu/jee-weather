LIVE
===========
This is [live demo](http://tomcat.justas.eu:888/ "JWeather").


jee-weather
===========

Java Spring, JSF web application (Rest, Soap showcase).
This application is downloading current weather data from wunderground api and storing it for presenting to users over nice web frontend.

Technologies
===========
- Spring
- JSF
- Jersey
- PrimeFaces

Prerequisites
===========
- I do not share api key to wunderground api (as limits do apply), so you should get one yourself
- Java 6 or 7
- Maven 3
- Tomcat 7 or other compatible servlet container

Install
===========
<pre>
mvn install
or 
mvn install -Dmaven.test.skip=true
</pre>

About the App
===========

Requirements:
- Service provides response times of less than 100ms.
- Service returns recent observation weather data for supported locations. Data should be updated every 0,5 hour, unless 3rd party weather service is down.
- Service provide SOAP and REST endpoints.
- Clients must authenticate using HTTP Basic authentication. Allowed clients with credentials weather/w34th3r

SOAP API:
- Service accepts list of city names as parameter and returns list of weather condition for given cities.
- If no city name provided service returns list of weather conditions for all supported locations.
- Application provides WSDL for SOAP service (/soap/WeatherSOAP?wsdl).

REST API:
- GET /weather/{city} - returns weather data for a given city.
- GET /weather - return list of weather conditions for supported locations.
- REST service response format is JSON. 
- API wadl /rest/application.wadl





