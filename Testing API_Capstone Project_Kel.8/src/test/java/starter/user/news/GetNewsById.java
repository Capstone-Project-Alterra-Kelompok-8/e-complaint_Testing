package starter.user.news;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetNewsById {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set API endpoint and method with valid")
    public String setApiEndpointAndMethodWithValid() {
        return url + "/news/1";
    }

    @Step("I send a request to get post data by ID")
    public void sendARequestToGetNewsById() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setApiEndpointAndMethodWithValid());
    }

    @Step("I get status code 200 OK")
    public void getStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get news data by ID with valid")
    public void getNewsDataByIdWithValid() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_NEWS_BY_ID_SCHEMA);

        restAssuredThat(response -> response.body("status", notNullValue()));
        restAssuredThat(response -> response.body("message", notNullValue()));
        restAssuredThat(response -> response.body("data", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //NEGATIVE

    @Step("I set with valid API endpoint and wrong method")
    public String setWithValidApiEndpointAndWrongMethod() {
        return url + "/news/1";
    }

    @Step("I send request to get news data by ID with invalid method")
    public void sendRequestToGetNewsDataByIdWithInvalidMethod() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .patch(setWithValidApiEndpointAndWrongMethod());
    }
    @Step("I received the status code 404 not found")
    public void receivedTheStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    //NEGATIVE

    @Step("I set with valid method and wrong API endpoint")
    public String setWithValidMethodAndWrongApiEndpoint() {
        return url + "/new/1";
    }

    @Step("I send request to get news data by ID with invalid endpoint")
    public void sendRequestToGetNewsDataByIdWithInvalidEndpoint() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setWithValidMethodAndWrongApiEndpoint());
    }
    @Step("I get status code 404 not found")
    public void getStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    //NEGATIVE

    @Step("I set with valid method and invalid ID API endpoint")
    public String setWithValidMethodAndInvalidIdApiEndpoint() {
        return url + "/news/100";
    }
    @Step("I set API endpoint and method with valid but ID was wrong")
    public void sendRequestToGetNewsDataByIdWithInvalidId() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setWithValidMethodAndInvalidIdApiEndpoint());
    }
    @Step("I see status code 404 not found")
    public void seeStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }
}
