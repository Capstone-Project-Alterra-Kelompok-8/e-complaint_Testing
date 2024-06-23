package starter.user.news;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllNews {

    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set valid API endpoint and method")
    public String setValidApiEndpointAndMethod() {
        return url + "/news";
    }

    @Step("I send a request to get all news data")
    public void sendARequestToGetAllNewsData() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setValidApiEndpointAndMethod());
    }

    @Step("I receive the status code 200 OK")
    public void receiveTheStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get all news data with valid")
    public void getAllNewsDataWithValid() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_NEWS_SCHEMA);

        restAssuredThat(response -> response.body("status", notNullValue()));
        restAssuredThat(response -> response.body("message", notNullValue()));
        restAssuredThat(response -> response.body("metadata", notNullValue()));
        restAssuredThat(response -> response.body("data", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //NEGATIVE

    @Step("I set valid API endpoint and wrong method")
    public String setValidApiEndpointAndWrongMethod() {
        return url + "/news";
    }

    @Step("I send request to get all news data with invalid method")
    public void sendRequestToGetAllNewsDataWithInvalidMethod() {String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .patch(setValidApiEndpointAndWrongMethod());
    }

    @Step("I receive the status code 404 not found")
    public void receiveTheStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    // NEGATIVE

    @Step("I set valid method and wrong API endpoint")
    public String setValidMethodAndWrongApiEndpoint() {
        return url + "/new";
    }

    @Step("I send request to get all news data with invalid endpoint")
    public void sendRequestToGetAllNewsDataWithInvalidEndpoint() {String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setValidMethodAndWrongApiEndpoint());
    }
    @Step("I receive in status code 404 not found")
    public void receiveInStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }
}
