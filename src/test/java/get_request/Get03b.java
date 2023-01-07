package get_request;

import base_urls.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get03b extends ReqresBaseUrl {
    /*
   Given
       https://reqres.in/api/users/2
   When
       User send GET Request to the URL
   Then
       HTTP Status Code should be 200
   And
       Response format should be "application/json"
   And
       "email" is "janet.weaver@reqres.in",
   And
       "first_name" is "Janet"
   And
       "last_name" is "Weaver"
   And
       "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
*/

    @Test
    public void get03b() {
        //Set the Url
        spec.pathParams("first", "users", "second", 2);

        //Set The Expected Data

        //Send The Request and Get The Response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        //Do Assertion
        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("data.email", equalTo("janet.weaver@reqres.in"),
                        "data.first_name", equalTo("Janet"),
                        "data.last_name", equalTo("Weaver"),
                        "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }
}