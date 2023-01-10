package base_urls;

import io.restassured.builder.*;
import io.restassured.specification.*;
import org.junit.*;

public class AutomationExerciseBaseURL {

    protected RequestSpecification specAuto;

    @Before
    public void setUp() {
        specAuto = new RequestSpecBuilder().setBaseUri("https://automationexercise.com/api").build();
    }
}