package eu.justas.jweather.domain;

public enum City {
	
	Vilnius("LT"),
	Kaunas("LT"),
	Siauliai("LT"),
	Raseiniai("LT"),
	Laukuva("LT"),
	Utena("LT"),
	Lazdijai("LT"),
	Klaipeda("LT");
	
	String countryCode;
	
	City (String countryCode) {
		this.countryCode = countryCode;
	}
	
	public String getName() {
		return this.name();
	}

	public String getCountryCode() {
		return this.countryCode;
	}
	
	// case insensitive
	public static City getByName (String cityName) {
		for (City city : City.values()) {
			if (city.name().equalsIgnoreCase(cityName)) return city;
		}
		return null;
	}
}
