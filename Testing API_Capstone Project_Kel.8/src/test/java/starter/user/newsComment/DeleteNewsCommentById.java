package starter.user.newsComment;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteNewsCommentById {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set with valid endpoint and method")
    public String setWithValidEndpointAndMethod() {
        return url + "/news/29/comments/28";
    }

    @Step("I send a request to delete news comment by ID")
    public void sendARequestToDeleteNewsCommentById() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .delete(setWithValidEndpointAndMethod());
    }

    @Step("I received status code 200 OK")
    public void receivedStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I see news comment has been delete with valid")
    public void seeNewsCommentHasBeenDeleteWithValid() {
    }

    //NEGATIVE

    @Step("I set with valid API endpoint with wrong method")
    public String setWithValidApiEndpointWithWrongMethod() {
        return url + "/news/2/comments/11";
    }

    @Step("I send a request to delete news comment by ID with invalid method")
    public void sendARequestToDeleteNewsCommentByIdWithInvalidMethod() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .patch(setWithValidApiEndpointWithWrongMethod());
    }
    @Step("I get in status code 404 not found")
    public void getInStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    //NEGATIVE

    @Step("I set with valid method and wrong endpoint")
    public String setWithValidMethodAndWrongEndpoint() {
        return url + "/news/2/comment/11";
    }

    @Step("I send request to delete news comment by ID with invalid endpoint")
    public void sendRequestToDeleteNewsCommentByIdWithInvalidEndpoint() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .delete(setWithValidMethodAndWrongEndpoint());
    }
    @Step("I received on status code 404 not found")
    public void receivedOnStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    //NEGATIVE

    @Step("I set with valid method and invalid endpoint ID")
    public String setWithValidMethodAndInvalidEndpointId() {
        return url + "/news/200/comments/111";
    }
    @Step("I send a request to delete news comment by ID with invalid ID")
    public void sendARequestToDeleteNewsCommentByIdWithInvalidId() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .delete(setWithValidMethodAndInvalidEndpointId());
    }
    @Step("I received a status code 400 bad request")
    public void receivedAStatusCode400(){
        restAssuredThat(response -> response.statusCode(400));
    }
}
