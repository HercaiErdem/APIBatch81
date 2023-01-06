package post_requests;

import base_urls.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.codehaus.jackson.map.*;
import org.junit.*;
import test_data.*;
import java.io.*;
import java.util.*;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Post05ObjectMapper_Map extends JsonplaceholderBaseUrl {

    /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
               }
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
    public void post05ObjectMapper() throws IOException {

        // Set the URL
        spec.pathParam("first", "todos");

        // Set the expected data

        //String jsonInString = "{\n" +
        //        "                                    \"userId\": 55,\n" +
        //        "                                    \"title\": \"Tidy your room\",\n" +
        //        "                                    \"completed\": false,\n" +
        //        "                                    \"id\": 201\n" +
        //        "                                    }";

        JsonPlaceHolderTestData obje = new JsonPlaceHolderTestData();
        String jsonInString = obje.expectedDataInString(55, "Tidy your room", false);

        HashMap expectedData = new ObjectMapper().readValue(jsonInString, HashMap.class);
        System.out.println("expectedData = " + expectedData);

        // Send the request and get the response

        Response response = given().spec(spec).body(expectedData).contentType(ContentType.JSON).post("{first}");
        response.prettyPrint();

        // Do Assertion
        HashMap actualData = new ObjectMapper().readValue(response.asString(), HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201, response.getStatusCode());

        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
    }
}