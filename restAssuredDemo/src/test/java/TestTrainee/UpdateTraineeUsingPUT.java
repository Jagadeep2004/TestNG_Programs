package TestTrainee;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.http.ContentType;

public class UpdateTraineeUsingPUT {
	
		@Test
		public void updateTrainee() {
			
			HashMap<String,Object> payload = new HashMap<>();
			payload.put("name", "Ajith");
			payload.put("email", "ak@gmamil.com");
			payload.put("company", "expleo");
			
			Response response = given().contentType(ContentType.JSON).body(payload).when().put("http://localhost:3000/trainees/ToRDWrS");
			
			Assert.assertEquals(response.getStatusCode(), 200);
	}
}
