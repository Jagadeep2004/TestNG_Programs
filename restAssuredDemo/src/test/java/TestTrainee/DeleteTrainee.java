package TestTrainee;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
public class DeleteTrainee {
		@Test
		public void deleteTrainee() {
			
			when()
			.delete("http://localhost:3000/trainees/3")
			.then()
			.statusCode(200);
			
			//Assert.assertEquals(res.getStatusCode(), 200);
			
		}
}
