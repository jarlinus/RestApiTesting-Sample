package net.restassured.demo.steps;

import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.restassured.demo.Constants;
import net.restassured.demo.engine.TestContext;
import net.restassured.demo.google.place.details.Place;
import net.restassured.demo.reusable.Resource;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;

public class GoogleMapsResponseSteps {

    TestContext testContext;

    public GoogleMapsResponseSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("the place is {string} {string} the google maps")
    public void thePlaceIsAddedInTheGoogleMaps(String userAction, String reference) {

        switch (userAction) {
            case "added":
                Response addResponse = (Response) testContext.getTestData().get(Constants.LAST_ADD_RESPONSE);
                Assert.assertThat(addResponse.getStatusCode(), is(200));
                Assert.assertThat(new JsonPath(addResponse.asString()).get("status").toString(), is("OK"));
                break;
            case "deleted":
                Response deleteResponse = (Response) testContext.getTestData().get(Constants.LAST_DELETE_RESPONSE);
                Assert.assertThat(deleteResponse.getStatusCode(), is(200));
                Assert.assertThat(new JsonPath(deleteResponse.asString()).get("status").toString(), is("OK"));
                break;
            case "fetched":
                Response getCallResponse = (Response) testContext.getTestData().get(Constants.LAST_GET_RESPONSE);
                Place place = (Place) testContext.getTestData().get(Constants.LAST_PLACE );
                Assert.assertThat(getCallResponse.getStatusCode(), is(200));
                Assert.assertThat(new JsonPath(getCallResponse.asString()).get("name").toString(), is(place.getName()));
                break;
            default:
                throw new IllegalStateException("Check user action");
        }


    }
}
