package tamnt.com.microservice.springboot.example;

import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Named
	static class JerseyConfig extends ResourceConfig {
		public JerseyConfig() {
			this.packages("tamnt.com.microservice.springboot.example.rest");
		}
	}

}