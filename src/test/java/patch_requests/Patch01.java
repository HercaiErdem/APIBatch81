package patch_requests;

import base_urls.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.*;
import test_data.*;
import java.util.*;
import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.*;

public class Patch01 extends JsonplaceholderBaseUrl {

     /*
    Given
     1) https://jsonplaceholder.typicode.com/todos/198
     2) {
             "title": "Wash the dishes"
           }
    When
         I send PATCH Request to the Url
    Then
      Status code is 200
      And response body is like   {
                   "userId": 10,
                   "title": "Wash the dishes",
                   "completed": true,
                   "id": 198
                   }
       */

    JsonPlaceHolderTestData obje = new JsonPlaceHolderTestData();

    @Test
    public void patch01() {

        // Set the URL
        spec.pathParams("first", "todos", "second", 198);

        // Set the expected data
        Map<String, Object> expectedDataMap = obje.exDataMethod(null, "Wash teh dishes", null);
        System.out.println("expectedDataMap = " + expectedDataMap);

        // Set the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).patch("{first}/{second}");
        response.prettyPrint();

        // Do Assertion
        Map<String, Object> actualData = response.as(HashMap.class);

        assertEquals(200, response.statusCode());
        assertEquals(expectedDataMap.get("title"), actualData.get("title"));
    }
}