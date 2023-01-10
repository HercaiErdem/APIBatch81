package delete_requests;

import base_urls.*;
import io.restassured.response.*;
import org.junit.*;
import utils.*;
import java.util.*;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Delete_01 extends JsonplaceholderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

    @Test
    public void delete01() {

        // Set the URL
        spec.pathParams("first", "todos", "second", 198);

        // Set the expected data
        Map<String, Object> expectedData = new HashMap<>();

        // Set the request and get the response
        Response response = given().spec(spec).delete("{first}/{second}");
        response.prettyPrint();

        // Do Assertion
        HashMap actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.getStatusCode());

        // 1. Yol
        assertEquals(expectedData, actualData);

        // 2. Yol
        assertTrue(actualData.isEmpty());

        // 3. Yol
        assertEquals(0, actualData.size());
    }
}