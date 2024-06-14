package starter.user.news;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteNewsById {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set valid endpoint and method")
    public String setValidEndpointAndMethod() {
        return url + "/news/6";
    }

    @Step("I send a request to delete news data by ID")
    public void sendARequestToDeleteNewsDataById() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .delete(setValidEndpointAndMethod());
    }

    @Step("I receive in status code 200 OK")
    public void receiveInStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I see news data has been delete with valid")
    public void seeNewsDataHasBeenDeleteWithValid() {
    }

    //NEGATIVE

    @Step("I set valid API endpoint with wrong method")
    public String setValidApiEndpointWithWrongMethod() {
        return url + "/news/6";
    }

    @Step("I send a request to delete news data by ID with invalid method")
    public void sendARequestToDeleteNewsDataByIdWithInvalidMethod() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .patch(setValidApiEndpointWithWrongMethod());
    }
    @Step("I receive status code 404 not found")
    public void receiveStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    //NEGATIVE

    @Step("I set valid method and wrong endpoint")
    public String setValidMethodAndWrongEndpoint() {
        return url + "/new/6";
    }

    @Step("I send request to delete news data by ID with invalid endpoint")
    public void sendRequestToDeleteNewsDataByIdWithInvalidEndpoint() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .delete(setValidMethodAndWrongEndpoint());
    }
    @Step("I received in status code 404 not found")
    public void receivedInStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    //NEGATIVE

    @Step("I set with valid method and invalid API endpoint ID")
    public String setWithValidMethodAndInvalidApiEndpointId() {
        return url + "/news/10";
    }
    @Step("I send a request to delete news data by ID with invalid ID")
    public void sendARequestToDeleteNewsDataByIdWithInvalidId() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .delete(setWithValidMethodAndInvalidApiEndpointId());
    }
    @Step("I received status code 400 bad request")
    public void receivedStatusCode400(){
        restAssuredThat(response -> response.statusCode(400));
    }
}
