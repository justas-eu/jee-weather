
package eu.justas.jweather.domain.gen;


public class WeatherObj{
   	private Current_observation current_observation;
   	private Response response;

 	public Current_observation getCurrent_observation(){
		return this.current_observation;
	}
	public void setCurrent_observation(Current_observation current_observation){
		this.current_observation = current_observation;
	}
 	public Response getResponse(){
		return this.response;
	}
	public void setResponse(Response response){
		this.response = response;
	}
}
