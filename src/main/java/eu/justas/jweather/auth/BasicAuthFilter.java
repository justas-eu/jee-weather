package eu.justas.jweather.auth;

import java.io.IOException;
import eu.justas.jweather.auth.BasicAuth;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BasicAuthFilter implements Filter {

	private static final Logger log = LoggerFactory.getLogger(BasicAuthFilter.class);
	
	@Value("${api.username}")
	String apiUsername;	

	@Value("${api.password}")
	String apiPassword;	

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
			ServletException {

		HttpServletRequest request = (HttpServletRequest) req;

		((HttpServletResponse) res).addHeader("Access-Control-Allow-Origin", "*");
		((HttpServletResponse) res).addHeader("Access-Control-Allow-Headers", "Authorization");
		
		log.debug(request.getMethod() + " " + request.getPathInfo());

		if ((request.getMethod().equals("GET")
				&& ((request.getPathInfo().startsWith("/application.wadl")) || (request.getPathInfo()
						.equalsIgnoreCase("/WeatherSOAP") && request.getParameter("wsdl") !=null)
						|| (request.getPathInfo()
								.equalsIgnoreCase("/")))) ||
								(request.getMethod().equals("OPTIONS"))){
			log.debug("Public access allowed.");
			chain.doFilter(req, res);
			return;
		}

		// Field names are case-insensitive.
		log.debug("authorization: " + request.getHeader("authorization"));
		String auth = request.getHeader("authorization");

		if (auth == null) {
			((HttpServletResponse) res).sendError(401);
			return;
		}

		String[] credentials = BasicAuth.decode(auth);

		if (credentials == null || credentials.length != 2) {
			((HttpServletResponse) res).sendError(401);
			return;
		}

		if (!credentials[0].equals(apiUsername) || !credentials[1].equals(apiPassword)) {
			((HttpServletResponse) res).sendError(401);
			return;
		}
		
		log.debug("Credentials OK");

		chain.doFilter(req, res);
	}

	public void init(FilterConfig config) throws ServletException {
	}

	public void destroy() {
	}
}