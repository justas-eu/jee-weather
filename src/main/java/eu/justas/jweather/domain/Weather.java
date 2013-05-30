package eu.justas.jweather.domain;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import eu.justas.jweather.domain.gen.WeatherObj;

@XmlRootElement(name="result")
public class Weather implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String city;
	private String humidity;
	private String iconUrl;
	private Date observationFetchTime;
	private Date observationTime;
	private int temperature;
	private String weatherDescription;
	private String windDescription;	
	private String windDirection;
	private String windSpeed;
	private String windDirDegrees;
	private String uv;
	private String latitude;
	private String longitude;

	
	private transient WeatherObj weatherObj;
	
	@XmlElement(name="location")
	public String getCity() {
		return city;
	}
	@XmlElement(name="relative_humidity")
	public String getHumidity() {
		return humidity;
	}
	
	@XmlElement(name="icon_url")
	public String getIconUrl() {
		return iconUrl;
	}
	@XmlTransient
	public Date getObservationFetchTime() {
		return observationFetchTime;
	}
	
	@XmlTransient
	public Date getObservationTime() {
		return observationTime;
	}
	@XmlElement(name="temp_c")
	public int getTemperature() {
		return temperature;
	}

	@XmlElement(name="weather")
	public String getWeatherDescription() {
		return weatherDescription;
	}
	@XmlTransient
	public  WeatherObj getWeatherObj() {
		return weatherObj;
	}
	
	@XmlElement(name="wind_string")
	public String getWindDescription() {
		return windDescription;
	}
	@XmlElement(name="wind_dir")
	public String getWindDirection() {
		return windDirection;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	public void setObservationFetchTime(Date observationFetchTime) {
		this.observationFetchTime = observationFetchTime;
	}
	
	public void setObservationTime(Date observationTime) {
		this.observationTime = observationTime;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}
	
	public void setWeatherObj(WeatherObj weatherObj) {
		this.weatherObj = weatherObj;
	}
	public void setWindDescription(String windDescription) {
		this.windDescription = windDescription;
	}
	
	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}
	@Override
	public String toString() {
		return "Weather [city=" + city + ", temp=" + temperature + ", humidity=" + humidity + ", windDirection="
				+ windDirection + ", description=" + weatherDescription + ", windDescription=" + windDescription
				+ "]";
	}
	
	@XmlElement(name="wind_speed")
	public String getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}
	
	@XmlElement(name="wind_degrees")
	public String getWindDirDegrees() {
		return windDirDegrees;
	}
	public void setWindDirDegrees(String windDirDegrees) {
		this.windDirDegrees = windDirDegrees;
	}
	public String getUv() {
		return uv;
	}
	public void setUv(String uv) {
		this.uv = uv;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
