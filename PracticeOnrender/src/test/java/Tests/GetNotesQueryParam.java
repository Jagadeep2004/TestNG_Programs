package Tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import routes.ApiRoutes;

public class GetNotesQueryParam {

    @Test(priority = 1)
    public void getAllNotes_Default() {

        given()
            .header("Authorization", "Bearer " + ApiRoutes.TOKEN)
        .when()
            .get(ApiRoutes.GETALL_NOTES)
        .then()
            .statusCode(200)
            .body("success", equalTo(true))
            .body("data", notNullValue());
    }

    @Test(priority = 2)
    public void getNotes_PageAndLimit() {

        given()
            .header("Authorization", "Bearer " + ApiRoutes.TOKEN)
            .queryParam("page", 1)
            .queryParam("limit", 2)
        .when()
            .get(ApiRoutes.GETALL_NOTES)
        .then()
            .statusCode(200)
            .body("success", equalTo(true))
            .body("pagination.currentPage", equalTo(1));
    }

    @Test(priority = 3)
    public void getNotes_Search() {

        given()
            .header("Authorization", "Bearer " + ApiRoutes.TOKEN)
            .queryParam("search", "API")
        .when()
            .get(ApiRoutes.GETALL_NOTES)
        .then()
            .statusCode(200)
            .body("success", equalTo(true));
    }

    @Test(priority = 4)
    public void getNotes_ByTag() {

        given()
            .header("Authorization", "Bearer " + ApiRoutes.TOKEN)
            .queryParam("tags", "qa")
        .when()
            .get(ApiRoutes.GETALL_NOTES)
        .then()
            .statusCode(200)
            .body("success", equalTo(true));
    }

    @Test(priority = 5)
    public void getNotes_PinnedTrue() {

        given()
            .header("Authorization", "Bearer " + ApiRoutes.TOKEN)
            .queryParam("isPinned", true)
        .when()
            .get(ApiRoutes.GETALL_NOTES)
        .then()
            .statusCode(200)
            .body("success", equalTo(true));
    }

    @Test(priority = 6)
    public void getNotes_SortByTitleAsc() {

        given()
            .header("Authorization", "Bearer " + ApiRoutes.TOKEN)
            .queryParam("sortBy", "title")
            .queryParam("sortOrder", "asc")
        .when()
            .get(ApiRoutes.GETALL_NOTES)
        .then()
            .statusCode(200)
            .body("success", equalTo(true));
    }

    @Test(priority = 7)
    public void getNotes_SortByLastEditedDesc() {

        given()
            .header("Authorization", "Bearer " + ApiRoutes.TOKEN)
            .queryParam("sortBy", "lastEdited")
            .queryParam("sortOrder", "desc")
        .when()
            .get(ApiRoutes.GETALL_NOTES)
        .then()
            .statusCode(200)
            .body("success", equalTo(true));
    }

    @Test(priority = 8)
    public void getNotes_AllQueryParams() {

        given()
            .header("Authorization", "Bearer " + ApiRoutes.TOKEN)
            .queryParam("page", 1)
            .queryParam("limit", 5)
            .queryParam("search", "API")
            .queryParam("tags", "qa")
            .queryParam("isPinned", false)
            .queryParam("sortBy", "title")
            .queryParam("sortOrder", "asc")
        .when()
            .get(ApiRoutes.GETALL_NOTES)
        .then()
            .statusCode(200)
            .body("success", equalTo(true));
    }

    // INVALID TEST CASES

    @Test(priority = 9)
    public void getNotes_NoToken() {

        given()
        .when()
            .get(ApiRoutes.GETALL_NOTES)
        .then()
            .statusCode(401);
    }

    @Test(priority = 10)
    public void getNotes_InvalidToken() {

        given()
            .header("Authorization", "Bearer InvalidToken123")
        .when()
            .get(ApiRoutes.GETALL_NOTES)
        .then()
            .statusCode(401);
    }

    @Test(priority = 11)
    public void getNotes_NegativePage() {

        Response res = given()
                .header("Authorization", "Bearer " + ApiRoutes.TOKEN)
                .queryParam("page", -1)
        .when()
                .get(ApiRoutes.GETALL_NOTES);

        res.prettyPrint();
    }

    @Test(priority = 12)
    public void getNotes_ZeroPage() {

        Response res = given()
                .header("Authorization", "Bearer " + ApiRoutes.TOKEN)
                .queryParam("page", 0)
        .when()
                .get(ApiRoutes.GETALL_NOTES);

        res.prettyPrint();
    }

    @Test(priority = 13)
    public void getNotes_NegativeLimit() {

        Response res = given()
                .header("Authorization", "Bearer " + ApiRoutes.TOKEN)
                .queryParam("limit", -5)
        .when()
                .get(ApiRoutes.GETALL_NOTES);

        res.prettyPrint();
    }

    @Test(priority = 14)
    public void getNotes_InvalidSortBy() {

        Response res = given()
                .header("Authorization", "Bearer " + ApiRoutes.TOKEN)
                .queryParam("sortBy", "name")
        .when()
                .get(ApiRoutes.GETALL_NOTES);

        res.prettyPrint();
    }

    @Test(priority = 15)
    public void getNotes_InvalidSortOrder() {

        Response res = given()
                .header("Authorization", "Bearer " + ApiRoutes.TOKEN)
                .queryParam("sortOrder", "abcd")
        .when()
                .get(ApiRoutes.GETALL_NOTES);

        res.prettyPrint();
    }

    @Test(priority = 16)
    public void getNotes_InvalidPinnedValue() {

        Response res = given()
                .header("Authorization", "Bearer " + ApiRoutes.TOKEN)
                .queryParam("isPinned", "abc")
        .when()
                .get(ApiRoutes.GETALL_NOTES);

        res.prettyPrint();
    }
}