package net.restassured.demo.engine;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * The test context that will be used for the different tests.
 * It holds the test state: a test data {@link Map}.
 *
 * A new instance should be initialised per test flow, and should be destroyed at the end of its lifecycle via the teardown method.
 */
public class TestContext {
    private final Map<String, Object> testData = new HashMap<>();
    private Scenario scenario;

    public Map<String, Object> getTestData() {
        return testData;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public Scenario getScenario() {
        return scenario;
    }
}
