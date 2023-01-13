package put_requests;

import base_urls.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.*;
import test_data.*;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Put01 extends JsonplaceholderBaseUrl {

    /*
    Given
     1) https://jsonplaceholder.typicode.com/todos/198
     2) {
             "userId": 21,
             "title": "Wash the dishes",
             "completed": false
           }
    When
        I send PUT Request to the Url
 Then
      Status code is 200
      And response body is like   {
                   "userId": 21,
                   "title": "Wash the dishes",
                   "completed": false
                  }
  */

    @Test
    public void put01() {
        //Set the Url
        spec.pathParams("first", "todos", "second", 198);

        //Set the expected Data
        JsonPlaceHolderTestData obje = new JsonPlaceHolderTestData();
        Map<String, Object> expectedData = obje.exDataMethod(21, "Wash the dishes", false);
        System.out.println(expectedData);

        //Send the Request and Get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().put("{first}/{second}");
        response.prettyPrint();

        // Do Assertion
        Map<String, Object> actualData = response.as(HashMap.class);

        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
    }
}