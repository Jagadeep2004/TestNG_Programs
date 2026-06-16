package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetPostTest {
	@Test
	public void getPost(){
		int id = 1;
		Response res = RestAssured.given()
				.when()
				.get("https://jsonplaceholder.typicode.com/posts/"+id);
		
		System.out.println("Status code: "+res.statusCode());
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(), 200);
	}
}
