package tamnt.com.microservice.springboot.example;

import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

	@Named
	static class JerseyConfig extends ResourceConfig {
		public JerseyConfig() {
			this.packages("tamnt.com.microservice.springboot.example.rest");
		}
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();

		return restTemplate;
	}

}