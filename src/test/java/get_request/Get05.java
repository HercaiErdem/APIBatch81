package get_request;

import base_urls.*;
import io.restassured.response.*;
import org.junit.*;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get05 extends RestfulBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends get request to the URL
    Then
        Status code is 200
    And
        Among the data there should be someone whose firstname is "Ali" and lastname is "Cengiz"
    */

    @Test
    public void get01() {
        // https://restful-booker.herokuapp.com/booking?firstname=Ali&lastname=Cengiz
        // 1. Set the URL
        spec.pathParam("first", "booking").queryParams("firstname", "Kimie", "lastname", "Jackie");

        // 2. Set the expected data
        // Bu casede olmadığı için geçiyoruz

        // 3. Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        // 4. Do Assertion
        assertEquals(200, response.getStatusCode());
        assertTrue(response.asString().contains("bookingid"));
    }
}