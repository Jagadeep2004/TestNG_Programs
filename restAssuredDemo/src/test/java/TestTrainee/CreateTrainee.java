package TestTrainee;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.http.ContentType;

public class CreateTrainee {

    @Test
    public void createTrainee() {

        HashMap<String, Object> payload = new HashMap<>();
        payload.put("name", "Jagadeep K C");
        payload.put("email", "jckjck@gmail.com");
        payload.put("company", "Expleo");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("http://localhost:3000/trainees");

        response.then().statusCode(201);

    }
}