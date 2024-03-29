package delete_requests;

import base_urls.*;
import io.restassured.response.*;
import org.junit.*;
import pojos.*;
import utils.*;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Delete02 extends DummyRestApiBaseUrl {

    /*
     URL: https://dummy.restapiexample.com/api/v1/delete/2
     HTTP Request Method: DELETE Request
     Test Case: Type by using Gherkin Language
     Assert:     i) Status code is 200
                 ii) "status" is "success"
                 iii) "data" is "2"
                 iv) "message" is "Successfully! Record has been deleted"
       */
    /*
    Given
            URL: https://dummy.restapiexample.com/api/v1/delete/2
    When
          HTTP Request Method: DELETE Request and get the response
        Test Case: Type by using Gherkin Language
    Then
         Assert:     i) Status code is 200
    And
        ii) "status" is "success"
    And
        iii) "data" is "2"
    And
        iv) "message" is "Successfully! Record has been deleted"
     */

    @Test
    public void delete02() {
        spec.pathParams("first", "delete", "second", 2);

        DummyRestApiDeletePojo expectedData = new DummyRestApiDeletePojo("success", "2", "Successfully! Record has been deleted");
         System.out.println("expectedData = " + expectedData);

        Response response = given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        DummyRestApiDeletePojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),DummyRestApiDeletePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.getStatus(), actualData.getStatus());
        assertEquals(expectedData.getData(), actualData.getData());
        assertEquals(expectedData.getMessage(), actualData.getMessage());


    }
}
