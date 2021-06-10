package net.restassured.demo.steps;

import io.cucumber.java.en.When;
import net.restassured.demo.Implementations.RequestSpecificationType;
import net.restassured.demo.engine.TestContext;
import net.restassured.demo.request.factory.RequestSpecificationFactory;

public class GoogleMapsRequestSteps {

    TestContext testContext;
    RequestSpecificationType requestSpecificationType;

    public GoogleMapsRequestSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("user {string} the place")
    public void userAddsThePlaceToGoogleMaps(String userAction) {
        setRequestSpecificationAbility(userAction);
        prepareRequestSpecification(testContext);
    }

    private void prepareRequestSpecification(TestContext testContext) {
        requestSpecificationType.httpMethodRequestSpecificationImplementation(testContext);
    }

    public void setRequestSpecificationAbility(String abilityType) {
        requestSpecificationType = new RequestSpecificationFactory().chooseRequestSpecification(abilityType);
    }
}
