package TestTrainee;
import static io.restassured.RestAssured.*;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.http.ContentType;

public class GetTrainee {

    @Test
    public void getTrainee() {


        Response response = given().contentType(ContentType.JSON).when().get("http://localhost:3000/trainees/ToRDWrS");
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}