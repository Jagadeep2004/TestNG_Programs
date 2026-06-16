package TestTrainee;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
public class Head {
		@Test
		public void head() {
			
			Response res = when().head("http://localhost:3000/trainees");
			
			Assert.assertEquals(res.getStatusCode(), 200);
			
		}
}
