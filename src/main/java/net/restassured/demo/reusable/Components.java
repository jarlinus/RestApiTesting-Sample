package net.restassured.demo.reusable;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.restassured.demo.Configuration;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Components {

    private static final String BASE_URI = Configuration.getInstance().getProperty("base.uri");
    private static final String API_KEY = Configuration.getInstance().getProperty("api.key");
    static PrintStream printStream;

    public RequestSpecification getGeneralRequestSpecification() {
        getPrintStream();
        return new RequestSpecBuilder().setBaseUri(BASE_URI).addQueryParam("key", API_KEY)
                .addFilter(RequestLoggingFilter.logRequestTo(printStream))
                .addFilter(ResponseLoggingFilter.logResponseTo(printStream))
                .setContentType(ContentType.JSON).build();
    }

    private void getPrintStream() {
        if (printStream == null) {
            try {
                printStream = new PrintStream(new FileOutputStream("log.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static String deletePayLoad(String placeId){
        return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
    }
}
