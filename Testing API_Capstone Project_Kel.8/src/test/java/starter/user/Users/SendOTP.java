package starter.user.Users;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class SendOTP {

    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";
    @Step("I set users API endpoint for send otp")
    public String setApiOTPUser() {
        return url + "/users/register/send-otp";
    }

    @Step("I send request endpoint for send otp with valid email")
    public void sendValidOTPUser() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", "skaha578562@gmail.com");

//        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwicm9sZSI6InN1cGVyX2FkbWluIiwiZXhwIjoxNzE3NjM4ODAxfQ._9zLuCrTyIzNnstjdIFKlJm7IisnPArGQFW3KQb9wXw";
        SerenityRest.given()
                .header("Content-Type","application/json")
//                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setApiOTPUser());
    }

    @Step("I receive response body for receive otp success")
    public void receiveValidDataForOTPUser() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.STATUS_MESSAGE_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Send OTP")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
