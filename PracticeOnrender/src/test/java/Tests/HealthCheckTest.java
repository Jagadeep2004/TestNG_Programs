package Tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import routes.ApiRoutes;

public class HealthCheckTest {
	
	@Test
	public void healthCheck() {
		
		Response res = when()
				.get(ApiRoutes.BASE_URL);
		
		res.then()
		.statusCode(200);
		
		res.prettyPrint();
		
	}
}
