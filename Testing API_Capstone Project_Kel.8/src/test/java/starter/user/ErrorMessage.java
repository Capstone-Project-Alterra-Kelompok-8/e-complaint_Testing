package starter.user;

import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class ErrorMessage {
    @Step("I received an error message that all fields must be filled in")
    public void receiveErrorMessageFieldBlank() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.STATUS_MESSAGE_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(false)));
        restAssuredThat(response -> response.body("message",Matchers.equalTo("all fields must be filled")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
