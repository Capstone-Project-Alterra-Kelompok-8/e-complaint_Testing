package starter.user.newsComment;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class UpdateNewsCommentById {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set valid endpoint and method with valid")
    public String setValidEndpointAndMethodWithValid() {
        return url + "/news/8/comments/10";
    }

    @Step("I send a request to update news comment by ID")
    public void sendARequestToUpdateNewsCommentById() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("comment", "SEDIH");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .put(setValidEndpointAndMethodWithValid());
    }

    @Step("I received status 200 OK")
    public void receivedStatus200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I see news comment has been update with valid")
    public void seeNewsCommentHasBeenUpdateWithValid() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_NEWS_COMMENT_BY_ID_SCHEMA);

        restAssuredThat(response -> response.body("status", notNullValue()));
        restAssuredThat(response -> response.body("message", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //NEGATIVE

    @Step("I set valid endpoint with the wrong method")
    public String setValidEndpointWithTheWrongMethod() {
        return url + "/news/2/comments/15";
    }

    @Step("I send a request to update news comment by ID with invalid method")
    public void sendARequestToUpdateNewsCommentByIdWithInvalidMethod() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("comment", "SEDIH");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .patch(setValidEndpointWithTheWrongMethod());
    }
    @Step("I get status 404 not found")
    public void getStatus404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    //NEGATIVE

    @Step("I set valid method and an incorrect endpoint")
    public String setValidMethodAndAnIncorrectEndpoint() {
        return url + "/news/2/comment/15";
    }

    @Step("I send request to update news comment by ID with invalid endpoint")
    public void sendRequestToUpdateNewsCommentByIdWithInvalidEndpoint() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("comment", "SEDIH");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .put(setValidMethodAndAnIncorrectEndpoint());
    }
    @Step("I get status in 404 not found")
    public void getStatusIn404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    //NEGATIVE

    @Step("I set valid method and invalid API endpoint ID")
    public String setValidMethodAndInvalidApiEndpointId() {
        return url + "/news/200/comments/150";
    }
    @Step("I send a request to update news comment by ID with invalid ID")
    public void sendARequestToUpdateNewsCommentByIdWithInvalidId() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("comment", "SEDIH");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .put(setValidMethodAndInvalidApiEndpointId());
    }
    @Step("I received 400 bad request")
    public void received400(){
        restAssuredThat(response -> response.statusCode(400));
    }
}
