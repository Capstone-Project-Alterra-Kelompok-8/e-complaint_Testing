package starter.user.Users;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class VerifyOTP {

    private static String url = "https://qe-capstone.mdrizki.my.id/api/v1";
    @Step("I set API endpoint for verify otp")
    public String setApiVerifyOTPUser() {
        return url + "/users/verify-otp";
    }

    @Step("I send request endpoint for verify otp")
    public void sendVerifySuccessdOTPUser() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", "mannperii16@gmail.com");
        requestBody.put("token", "12807");

//        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlN1cGVyIEFkbWluIiwicm9sZSI6InN1cGVyX2FkbWluIiwiZXhwIjoxNzE3NjM4ODAxfQ._9zLuCrTyIzNnstjdIFKlJm7IisnPArGQFW3KQb9wXw";
        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setApiVerifyOTPUser());
    }

    @Step("I receive response body for Success Verify OTP")
    public void receiveValidDataForVerifyOTPUser() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.STATUS_MESSAGE_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Verify OTP")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
