package TestTrainee;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
public class Head {
		@Test
		public void head() {
			
			 when()
			.head("http://localhost:3000/trainees")
			.then()
			.statusCode(200);
			
			//Assert.assertEquals(res.getStatusCode(), 200);
			
		}
}
