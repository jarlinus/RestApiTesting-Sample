package net.restassured.demo.request.factory;

import net.restassured.demo.requests.AddRequest;
import net.restassured.demo.requests.DeleteRequest;
import net.restassured.demo.requests.GetRequest;
import net.restassured.demo.Implementations.RequestSpecificationType;

public class RequestSpecificationFactory {

    public RequestSpecificationType chooseRequestSpecification(String ability){
        if(ability.equalsIgnoreCase("adds")){
            return new AddRequest();
        }
        if(ability.equalsIgnoreCase("gets")){
            return new GetRequest();
        }
        if(ability.equalsIgnoreCase("deletes")){
            return new DeleteRequest();
        }
        return null;
    }
}
