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

public class CreateNews {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set the valid endpoint and method")
    public String setTheValidEndpointAndMethod() {
        return url + "/news";
    }

    @Step("I send a request to create news data")
    public void sendARequestToCreateNewsData() {
        File sampleFile = new File("src/test/resources/melewatijalanberlubang.jpg");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .contentType(ContentType.MULTIPART)
                .multiPart("title","AREA JALAN")
                .multiPart("content","SEDANG BERLUBANG")
                .multiPart("category_id","5")
                .multiPart("files", sampleFile)
                .post(setTheValidEndpointAndMethod());
    }

    @Step("I received a status code 201 created")
    public void receivedAStatusCode201() {
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("I create news data with valid")
    public void createNewsDataWithValid() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_NEWS_SCHEMA);

        restAssuredThat(response -> response.body("status", notNullValue()));
        restAssuredThat(response -> response.body("message", notNullValue()));
        restAssuredThat(response -> response.body("data", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //NEGATIVE

    @Step("I set valid endpoint and incorrect method")
    public String setValidEndpointAndIncorrectMethod() {
        return url + "/news";
    }

    @Step("I send request to create news data with invalid method")
    public void sendRequestToCreateNewsDataWithInvalidMethod() {String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .patch(setValidEndpointAndIncorrectMethod());
    }

    @Step("I received 404 not found status code")
    public void received404StatusCode(){
        restAssuredThat(response -> response.statusCode(404));
    }

    // NEGATIVE

    @Step("I set valid method and an incorrect API endpoint")
    public String setValidMethodAndAnIncorrectApiEndpoint() {
        return url + "/new";
    }

    @Step("I send request to create news data with invalid endpoint")
    public void sendRequestToCreateNewsDataWithInvalidEndpoint() {
        File sampleFile = new File("src/test/resources/melewatijalanberlubang.jpg");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .contentType(ContentType.MULTIPART)
                .multiPart("title","AREA JALAN")
                .multiPart("content","SEDANG BERLUBANG")
                .multiPart("category_id","5")
                .multiPart("files", sampleFile)
                .post(setValidMethodAndAnIncorrectApiEndpoint());
    }
    @Step("I receive in status 404 not found")
    public void receiveInStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }
}
