package post_requests;

import base_urls.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.*;
import test_data.*;
import java.util.*;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Post01 extends JsonplaceholderBaseUrl {

     /*
         Given
           1)  https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
                }
        When
         I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post01() {
        //Set the Url
        spec.pathParam("first", "todos");

        //Set the expected Data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        Map<String, Object> expectedData = obj.exDataMethod(55, "Tidy your room", false);

        //Send the Request and Get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        // Do Assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
    }
}