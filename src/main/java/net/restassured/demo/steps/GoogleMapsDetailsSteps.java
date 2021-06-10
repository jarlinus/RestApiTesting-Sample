package net.restassured.demo.steps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.restassured.specification.RequestSpecification;
import net.restassured.demo.Constants;
import net.restassured.demo.engine.TestContext;
import net.restassured.demo.google.place.details.Place;
import net.restassured.demo.reusable.Components;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class GoogleMapsDetailsSteps {

    TestContext testContext;

    public GoogleMapsDetailsSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @DataTableType(replaceWithEmptyString = "[blank]")
    public Place placeDetailsEntry(Map<String, String> entry) {
        return Place.createPlaceDetails(entry);
    }

    @Given("user has the details of new place to be added in google maps")
    public void userHasTheDetailsOfNewPlaceToBeAddedInGoogleMaps(Place place) {
        testContext.getTestData().put(Constants.LAST_PLACE,place);
    }

}
