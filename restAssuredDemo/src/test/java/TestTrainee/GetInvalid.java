package TestTrainee;
import static io.restassured.RestAssured.*;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.http.ContentType;

public class GetInvalid {

    @Test
    public void getInvalid() {


        Response response = given().contentType(ContentType.JSON).when().get("http://localhost:3000/trainees/15");
        //response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 404);
    }
}