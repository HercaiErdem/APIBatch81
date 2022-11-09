package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class AutomationExerciseBaseURL {

    protected RequestSpecification specAuto;

    @Before
    public void setUp() {
        specAuto = new RequestSpecBuilder().setBaseUri("https://automationexercise.com/api").build();
    }
}