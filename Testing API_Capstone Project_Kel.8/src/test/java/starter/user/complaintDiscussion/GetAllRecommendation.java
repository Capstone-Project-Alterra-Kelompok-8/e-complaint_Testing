package starter.user.complaintDiscussion;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllRecommendation {

    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set the API endpoint and method with valid")
    public String setTheApiEndpointAndMethodWithValid() {
        return url + "/complaints/C-81jas92581/discussions/get-recommendation";
    }

    @Step("I send a request to get all recommendation")
    public void sendARequestToGetAllRecommendation() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setTheApiEndpointAndMethodWithValid());
    }

    @Step("I get a status code 200 OK")
    public void getAStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get all recommendation with valid")
    public void getAllRecommendationWithValid() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_RECOMMENDATION_SCHEMA);

        restAssuredThat(response -> response.body("status", notNullValue()));
        restAssuredThat(response -> response.body("message", notNullValue()));
        restAssuredThat(response -> response.body("data", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //NEGATIVE

    @Step("I set with valid API endpoint and incorrect method")
    public String setWithValidApiEndpointAndIncorrectMethod() {
        return url + "/complaints/C-81jas92581/discussions/get-recommendation";
    }

    @Step("I send request to get all recommendation with invalid method")
    public void sendRequestToGetAllRecommendationWithInvalidMethod() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .patch(setWithValidApiEndpointAndIncorrectMethod());
    }

    @Step("I get 404 not found status code")
    public void get404StatusCode(){
        restAssuredThat(response -> response.statusCode(404));
    }

    // NEGATIVE

    @Step("I set with valid method and an incorrect API endpoint")
    public String setWithValidMethodAndAnIncorrectApiEndpoint() {
        return url + "/complaints/C-81jas92581/discussion/get-recommendation";
    }

    @Step("I send request to get all recommendation with invalid endpoint")
    public void sendRequestToGetAllRecommendationWithInvalidEndpoint() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setWithValidMethodAndAnIncorrectApiEndpoint());
    }
    @Step("I get the status code 404 not found")
    public void getTheStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }
}
