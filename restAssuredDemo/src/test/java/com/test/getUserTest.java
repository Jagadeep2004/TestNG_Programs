package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getUserTest {
	
	@Test
	public void getUserTest() {
		Response response = RestAssured.given().when().get("https://jsonplaceholder.typicode.com/users/1");
		
		System.out.println("Status code : "+response.getStatusCode());
		
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(),200);
		
		String name = response.jsonPath().getString("name");
		
		Assert.assertEquals(name, "Leanne Graham");
	}

}
