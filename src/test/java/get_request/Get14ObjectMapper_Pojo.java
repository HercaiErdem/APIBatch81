package get_request;

import base_urls.*;
import io.restassured.response.*;
import org.junit.*;
import pojos.*;
import utils.*;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get14ObjectMapper_Pojo extends JsonplaceholderBaseUrl {

    /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */

    // ObjectMapper + Pojo = Best practice
    @Test
    public void get14Pojo() {

        // Set the URL
        spec.pathParams("first", "todos", "second", 198);

        // Set the expected data
        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(10, "quis eius est sint explicabo", true);

        // Set the request and get the response
        Response response = given().spec(spec).get("{first}/{second}");

        // Do Assertion
        JsonPlaceHolderPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), JsonPlaceHolderPojo.class);

        assertEquals(200, response.getStatusCode());

        assertEquals(expectedData.getUserId(), actualData.getUserId());
        assertEquals(expectedData.getTitle(), actualData.getTitle());
        assertEquals(expectedData.getCompleted(), actualData.getCompleted());
    }
}