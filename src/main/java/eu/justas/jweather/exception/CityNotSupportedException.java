package eu.justas.jweather.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CityNotSupportedException extends WebApplicationException {
	
	private static final long serialVersionUID = -1L;

	public CityNotSupportedException(String message) {
        super(Response.status(Response.Status.NOT_FOUND)
            .entity(message).type(MediaType.TEXT_PLAIN).build());
    }
	
}
