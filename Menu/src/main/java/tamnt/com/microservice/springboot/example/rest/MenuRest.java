package tamnt.com.microservice.springboot.example.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Named
@Path("/")
public class MenuRest {

	private static List<Menu> menus = new ArrayList<Menu>();

	static {

		Menu menu1 = new Menu();
		menu1.setId(1);
		menu1.setSku("abcd1");
		menu1.setDescription("Menu1");

		Menu menu2 = new Menu();
		menu2.setId(2);
		menu2.setSku("abcd2");
		menu2.setDescription("Menu2");

		Menu menu3 = new Menu();
		menu3.setId(3);
		menu3.setSku("abcd3");
		menu3.setDescription("Menu3");

		Menu menu4 = new Menu();
		menu4.setId(4);
		menu4.setSku("abcd4");
		menu4.setDescription("Menu4");

		menus.add(menu1);
		menus.add(menu2);
		menus.add(menu3);
		menus.add(menu4);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Menu> getMenus() {
		return menus;
	}

	@GET
	@Path("menu")
	@Produces(MediaType.APPLICATION_JSON)
	public Menu getMenu(@QueryParam("id") long id) {

		Menu prod = null;

		for (Menu p : menus) {

			if (p.getId() == id)
				prod = p;

		}

		return prod;
	}

}
