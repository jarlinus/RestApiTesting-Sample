package net.restassured.demo.steps;

import io.cucumber.java.en.When;
import net.restassured.demo.engine.TestContext;
import net.restassured.demo.request.Implementations.RequestType;
import net.restassured.demo.request.factory.RequestFactory;

public class GoogleMapsRequestSteps {

    TestContext testContext;
    RequestType requestType;

    public GoogleMapsRequestSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("user {string} the place")
    public void userAddsThePlaceToGoogleMaps(String userAction) {
        setRequestSpecificationAbility(userAction);
        prepareRequestSpecification(testContext);
    }

    private void prepareRequestSpecification(TestContext testContext) {
        requestType.httpMethodRequestSpecificationImplementation(testContext);
    }

    public void setRequestSpecificationAbility(String abilityType) {
        requestType = new RequestFactory().chooseRequestSpecification(abilityType);
    }
}
