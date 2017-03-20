package tamnt.com.microservice.springboot.example.rest;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.web.client.RestTemplate;

@Named
@Path("/")
public class OrderRest {

	private static long id = 1;

	@Inject
	private RestTemplate restTemplate;

	@GET
	@Path("order")
	@Produces(MediaType.APPLICATION_JSON)
	public Order submitOrder(@QueryParam("idCustomer") long idCustomer,
			@QueryParam("idMenu") long idMenu,
			@QueryParam("amount") long amount) {

		Order order = new Order();

		Customer customer = restTemplate.getForObject(
				"http://localhost:8081/customer?id={id}", Customer.class,
				idCustomer);

		Menu menu = restTemplate.getForObject(
				"http://localhost:8082/menu?id={id}", Menu.class,
				idMenu);

		order.setCustomer(customer);
		order.setMenu(menu);
		order.setId(id);
		order.setAmount(amount);
		order.setOrderDate(new Date());

		id++;

		return order;
	}
}
