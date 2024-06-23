package starter.user.news;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class UpdateNewsById {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set valid endpoint and method with validly")
    public String setValidEndpointAndMethodWithValidly() {
        return url + "/news/7";
    }

    @Step("I send a request to update news data by ID")
    public void sendARequestToUpdateNewsDataById() {
        File sampleFile = new File("src/test/resources/tanahlongsor.jpeg");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .contentType(ContentType.MULTIPART)
                .multiPart("title","AREA TANAH MERAH")
                .multiPart("content","AWAS SEDANG LONGSOR")
                .multiPart("category_id","6")
                .multiPart("files", sampleFile)
                .put(setValidEndpointAndMethodWithValidly());
    }

    @Step("I see status 200 OK")
    public void seeStatus200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I see news data has been update with valid")
    public void seeNewsDataHasBeenUpdateWithValid() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_NEWS_BY_ID_SCHEMA);

        restAssuredThat(response -> response.body("status", notNullValue()));
        restAssuredThat(response -> response.body("message", notNullValue()));
        restAssuredThat(response -> response.body("data", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //NEGATIVE

    @Step("I set with valid endpoint and wrong method")
    public String setWithValidEndpointAndWrongMethod() {
        return url + "/news/9";
    }

    @Step("I send a request to update news data by ID with invalid method")
    public void sendARequestToUpdateNewsDataByIdWithInvalidMethod() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .patch(setWithValidEndpointAndWrongMethod());
    }

    @Step("I see status 404 not found")
    public void seeStatus404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    // NEGATIVE

    @Step("I set with valid method and incorrect endpoint")
    public String setWithValidMethodAndIncorrectEndpoint() {
        return url + "/new/9";
    }

    @Step("I send request to update news data by ID with invalid endpoint")
    public void sendRequestToUpdateNewsDataByIdWithInvalidEndpoint() {
        File sampleFile = new File("src/test/resources/tanahlongsor.jpeg");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .contentType(ContentType.MULTIPART)
                .multiPart("title","AREA TANAH")
                .multiPart("content","SEDANG LONGSOR")
                .multiPart("category_id","6")
                .multiPart("files", sampleFile)
                .post(setWithValidMethodAndIncorrectEndpoint());
    }
    @Step("I see status in 404 not found")
    public void seeStatusIn404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    // NEGATIVE

    @Step("I set valid method with invalid API endpoint ID")
    public String setValidMethodWithInvalidApiEndpointId() {
        return url + "/news/90";
    }

    @Step("I send a request to update news data by ID with invalid ID")
    public void sendARequestToUpdateNewsDataByIdWithInvalidId() {
        File sampleFile = new File("src/test/resources/tanahlongsor.jpeg");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .contentType(ContentType.MULTIPART)
                .multiPart("title","AREA TANAH")
                .multiPart("content","SEDANG LONGSOR")
                .multiPart("category_id","6")
                .multiPart("files", sampleFile)
                .post(setValidMethodWithInvalidApiEndpointId());
    }
    @Step("I see 404 not found")
    public void see404(){
        restAssuredThat(response -> response.statusCode(404));
    }
}
