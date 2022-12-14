package get_request;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.*;
import static io.restassured.RestAssured.*;

public class Get01b {
    /*
   Given
       https://reqres.in/api/users/3
   When
       User sends a GET Request to the url
   Then
       HTTP Status Code should be 200
   And
       Content Type should be JSON
   And
       Status Line should be HTTP/1.1 200 OK
*/

    @Test
    public void get01b() {
        //Set the URL
        String url = "https://reqres.in/api/users/3";
        Response response = given().when().get(url);

        //HTTP Status Code should be 200
        //Content Type should be JSON
        //Status Line should be HTTP/1.1 200 OK
        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");
    }
}