package starter.user.complaintDiscussion;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteComplaintDiscussionById {
    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";

    @Step("I set a valid API endpoint and method")
    public String setAValidApiEndpointAndMethod() {
        return url + "/complaints/C-eac9990da3/discussions/38";
    }

    @Step("I send a request to delete complaint discussion by ID")
    public void sendARequestToDeleteComplaintDiscussionById() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .delete(setAValidApiEndpointAndMethod());
    }

    @Step("I receive a status code 200 OK")
    public void receiveAStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I see complaint discussion has been delete with valid")
    public void seeComplaintDiscussionHasBeenDeleteWithValid() {
    }

    //NEGATIVE

    @Step("I set a valid API endpoint with the wrong method")
    public String setAValidApiEndpointWithTheWrongMethod() {
        return url + "/complaints/C-81jas92581/discussions/20";
    }

    @Step("I send a request to delete complaint discussion by ID with invalid method")
    public void sendARequestToDeleteComplaintDiscussionByIdWithInvalidMethod() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .patch(setAValidApiEndpointWithTheWrongMethod());
    }
    @Step("I receive on status code 404 not found")
    public void receiveOnStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    //NEGATIVE

    @Step("I set a valid method and an incorrect endpoint")
    public String setAValidMethodAndAnIncorrectEndpoint() {
        return url + "/complaints/C-81jas92581/discussion/20";
    }

    @Step("I send request to delete complaint discussion by ID with invalid endpoint")
    public void sendRequestToDeleteComplaintDiscussionByIdWithInvalidEndpoint() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .delete(setAValidMethodAndAnIncorrectEndpoint());
    }
    @Step("I received a status code 404 not found")
    public void receivedAStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    //NEGATIVE

    @Step("I set a valid method and an invalid API endpoint ID")
    public String setAValidMethodAndAnInvalidApiEndpointId() {
        return url + "/complaints/CC-81jas92581/discussions/200";
    }
    @Step("I send a request to delete complaint discussion by ID with invalid ID")
    public void sendARequestToDeleteComplaintDiscussionByIdWithInvalidId() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwiZW1haWwiOiJzdXBlcl9hZG1pbkBnbWFpbC5jb20iLCJyb2xlIjoic3VwZXJfYWRtaW4ifQ.2wN36slPPgg24CE6Tl1o0q-Fy_Yyy-FWKhfc-UxzC18";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .delete(setAValidMethodAndAnInvalidApiEndpointId());
    }
    @Step("I received status code 404 not found")
    public void receivedStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }
}
