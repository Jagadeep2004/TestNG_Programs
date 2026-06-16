package TestTrainee;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
public class DeleteTrainee {
		@Test
		public void deleteTrainee() {
			
			Response res = when().delete("http://localhost:3000/trainees/3");
			
			Assert.assertEquals(res.getStatusCode(), 200);
			
		}
}
