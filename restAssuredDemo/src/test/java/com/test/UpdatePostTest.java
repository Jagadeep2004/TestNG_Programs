package com.test;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdatePostTest {
	@Test
	public void updatePost(){
		int id = 1;
		
		Map<String, Object> payload = new HashMap<>(); 
			
		payload.put("userId", 1);
		payload.put("id", 1);
		payload.put("title", "Changing title");
		payload.put("body", "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");
		
		Response res = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(payload)
				.when()
				.put("https://jsonplaceholder.typicode.com/posts/"+id);
		
		System.out.println("Status code: "+res.statusCode());
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(), 200);
	}
}
