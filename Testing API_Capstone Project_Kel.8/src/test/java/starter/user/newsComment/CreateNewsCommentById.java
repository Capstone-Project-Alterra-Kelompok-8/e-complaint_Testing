package starter.user.newsComment;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class CreateNewsCommentById {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set a valid endpoint and method")
    public String setAValidEndpointAndMethod() {
        return url + "/news/2/comments";
    }

    @Step("I send a request to create news comment by ID")
    public void sendARequestToCreateNewsCommentById() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("comment", "BENCANA");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setAValidEndpointAndMethod());
    }

    @Step("I received on status code 201 created")
    public void receivedOnStatusCode201() {
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("I create news comment with valid")
    public void createNewsCommentWithValid() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_NEWS_COMMENT_BY_ID_SCHEMA);

        restAssuredThat(response -> response.body("status", notNullValue()));
        restAssuredThat(response -> response.body("message", notNullValue()));
        restAssuredThat(response -> response.body("data", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //NEGATIVE

    @Step("I set a valid API endpoint and incorrect method")
    public String setAValidApiEndpointAndIncorrectMethod() {
        return url + "/news/2/comments";
    }

    @Step("I send request to create news comment by ID with invalid method")
    public void sendRequestToCreateNewsCommentByIdWithInvalidMethod() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("comment", "BENCANA");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .patch(setAValidApiEndpointAndIncorrectMethod());
    }

    @Step("I received on 404 not found status code")
    public void receivedOn404StatusCode(){
        restAssuredThat(response -> response.statusCode(404));
    }

    // NEGATIVE

    @Step("I set the valid method and an incorrect API endpoint")
    public String setTheValidMethodAndAnIncorrectApiEndpoint() {
        return url + "/news/2/comment";
    }

    @Step("I send request to create news comment by ID with invalid endpoint")
    public void sendRequestToCreateNewsCommentByIdWithInvalidEndpoint() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("comment", "BENCANA");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setTheValidMethodAndAnIncorrectApiEndpoint());
    }
    @Step("I received code 404 not found")
    public void receivedCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    // NEGATIVE

    @Step("I set valid method and an invalid API endpoint ID")
    public String setValidMethodAndAnInvalidApiEndpointId() {
        return url + "/news/200/comments";
    }

    @Step("I send a request to create news comment by ID with invalid ID")
    public void sendARequestToCreateNewsCommentByIdWithInvalidId() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("comment", "BENCANA");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setValidMethodAndAnInvalidApiEndpointId());
    }
    @Step("I received code 400 bad request")
    public void receivedCode400(){
        restAssuredThat(response -> response.statusCode(400));
    }
}
