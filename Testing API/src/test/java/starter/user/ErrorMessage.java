package starter.user;

import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class ErrorMessage {
    @Step("I received an error message that all fields must be filled in")
    public void receiveErrorMessageFieldBlanks() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.STATUS_MESSAGE_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(false)));
        restAssuredThat(response -> response.body("message",Matchers.equalTo("all fields must be filled")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
    @Step("I receive error message that not found")
    public void receiveErrorMessageNotFounds() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.STATUS_MESSAGE_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(false)));
        restAssuredThat(response -> response.body("message",Matchers.equalTo("not found")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
    @Step("I receive response body that complaint not found")
    public void receiveErrorMessageComplaintNotFounds() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.STATUS_MESSAGE_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(false)));
        restAssuredThat(response -> response.body("message",Matchers.equalTo("complaint not found")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
    @Step("I receive error message that category not found")
    public void receiveInValidDataForNewComplaint() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.STATUS_MESSAGE_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(false)));
        restAssuredThat(response -> response.body("message",Matchers.equalTo("category not found")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
