package com.test;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdatePostPartialTest {
	@Test
	public void updatePostPartially(){
		int id = 1;
		
		Map<String, Object> payload = new HashMap<>(); 
			
		payload.put("title", "Changing title");
		
		Response res = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(payload)
				.when()
				.patch("https://jsonplaceholder.typicode.com/posts/"+id);
		
		System.out.println("Status code: "+res.statusCode());
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(), 200);
	}
}
