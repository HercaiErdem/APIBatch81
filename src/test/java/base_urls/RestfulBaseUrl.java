package base_urls;

import io.restassured.builder.*;
import io.restassured.specification.*;
import org.junit.*;

public class RestfulBaseUrl {
    protected RequestSpecification spec;

    @Before
    public void setUp() {
        spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }
}