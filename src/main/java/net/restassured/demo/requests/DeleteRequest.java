package net.restassured.demo.requests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.restassured.demo.Constants;
import net.restassured.demo.engine.TestContext;
import net.restassured.demo.reusable.Components;
import net.restassured.demo.reusable.Resource;
import net.restassured.demo.Implementations.RequestSpecificationType;

import static io.restassured.RestAssured.given;

public class DeleteRequest implements RequestSpecificationType {
    @Override
    public void httpMethodRequestSpecificationImplementation(TestContext testContext) {
        Resource resource = Resource.valueOf("deletes");
        RequestSpecification requestSpecification = given().spec(new Components().getGeneralRequestSpecification());
        Response response = requestSpecification.body(Components.deletePayLoad(getPlace_id(testContext))).when().delete(resource.getResource());
        testContext.getTestData().put(Constants.LAST_DELETE_RESPONSE, response);
    }

    private String getPlace_id(TestContext testContext) {
        Response response = (Response) testContext.getTestData().get(Constants.LAST_ADD_RESPONSE);
        return new JsonPath(response.asString()).get("place_id").toString();
    }
}