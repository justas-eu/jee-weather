package eu.justas.jweather.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class DataNotStoredException extends WebApplicationException {
	
	private static final long serialVersionUID = -1L;

	public DataNotStoredException(String message) {
        super(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(message).type(MediaType.TEXT_PLAIN).build());
    }
	

}
