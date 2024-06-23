package starter.user.newsComment;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetNewsCommentById {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set a API endpoint and method with valid")
    public String setAApiEndpointAndMethodWithValid() {
        return url + "/news/2/comments";
    }

    @Step("I send a request to get news comment by ID")
    public void sendARequestToGetNewsCommentById() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setAApiEndpointAndMethodWithValid());
    }

    @Step("I get the status code 200 OK")
    public void getTheStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get news comment by ID with valid")
    public void getNewsCommentByIdWithValid() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_NEWS_COMMENT_BY_ID_SCHEMA);

        restAssuredThat(response -> response.body("status", notNullValue()));
        restAssuredThat(response -> response.body("message", notNullValue()));
        restAssuredThat(response -> response.body("data", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //NEGATIVE

    @Step("I set with a valid API endpoint and wrong method")
    public String setWithAValidApiEndpointAndWrongMethod() {
        return url + "/news/2/comments";
    }

    @Step("I send request to get news comment by ID with invalid method")
    public void sendRequestToGetNewsCommentByIdWithInvalidMethod() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .patch(setWithAValidApiEndpointAndWrongMethod());
    }
    @Step("I get a status code 404 not found")
    public void getAStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    //NEGATIVE

    @Step("I set with a valid method and wrong API endpoint")
    public String setWithAValidMethodAndWrongApiEndpoint() {
        return url + "/news/2/comment";
    }

    @Step("I send request to get news comment by ID with invalid endpoint")
    public void sendRequestToGetNewsCommentByIdWithInvalidEndpoint() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setWithAValidMethodAndWrongApiEndpoint());
    }
    @Step("I get on status code 404 not found")
    public void getOnStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    //NEGATIVE

    @Step("I set with a valid method and invalid ID API endpoint")
    public String setWithAValidMethodAndInvalidIdApiEndpoint() {
        return url + "/news/200/comments";
    }
    @Step("I send request to get news comment by ID with invalid ID")
    public void sendRequestToGetNewsCommentByIdWithInvalidId() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setWithAValidMethodAndInvalidIdApiEndpoint());
    }
    @Step("I get on status code 400 bad request")
    public void getOnStatusCode400(){
        restAssuredThat(response -> response.statusCode(400));
    }
}
