package net.restassured.demo.requests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.restassured.demo.Constants;
import net.restassured.demo.engine.TestContext;
import net.restassured.demo.google.place.details.Place;
import net.restassured.demo.reusable.Components;
import net.restassured.demo.reusable.Resource;
import net.restassured.demo.request.Implementations.RequestType;

import static io.restassured.RestAssured.given;

public class AddRequest implements RequestType {

    @Override
    public void httpMethodRequestSpecificationImplementation(TestContext testContext) {
        Resource resource = Resource.valueOf("adds");
        Place place = (Place) testContext.getTestData().get(Constants.LAST_PLACE);
        RequestSpecification requestSpecification = given().spec(new Components().getGeneralRequestSpecification());
        Response response = requestSpecification.body(place).when().post(resource.getResource());
        testContext.getTestData().put(Constants.LAST_ADD_RESPONSE, response);
    }
}
