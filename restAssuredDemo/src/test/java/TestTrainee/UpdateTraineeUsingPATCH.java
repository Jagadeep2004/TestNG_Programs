package TestTrainee;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.http.ContentType;

public class UpdateTraineeUsingPATCH {
	
		@Test
		public void updateTrainee() {
			
			HashMap<String,Object> payload = new HashMap<>();
			payload.put("name", "Ajith Kumar");
			
			Response response = given().contentType(ContentType.JSON).body(payload).when().patch("http://localhost:3000/trainees/ToRDWrS");
			
			Assert.assertEquals(response.getStatusCode(), 200);
	}
}
