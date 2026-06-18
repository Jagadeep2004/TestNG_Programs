package TestTrainee;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
public class AllOptions {
		@Test
		public void allOptions() {
			
			Response res = when().options("http://localhost:3000/trainees");
			
			System.out.println("Allowed Methods: " + res.getHeader("Allow"));
			
			res.then().statusCode(204);
			
			//Assert.assertEquals(res.getStatusCode(), 204);
			
		}
}
