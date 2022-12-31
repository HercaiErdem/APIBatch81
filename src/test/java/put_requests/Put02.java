package put_requests;

import base_urls.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.*;
import pojos.*;
import utils.*;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Put02 extends DummyRestApiBaseUrl {
    /*
        URL: https://dummy.restapiexample.com/api/v1/update/21
       HTTP Request Method: PUT Request
       Request body: {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }
     */
/*
  Given
       URL: https://dummy.restapiexample.com/api/v1/update/21
       {
                    "employee_name": "Ali Can",
                    "employee_salary": 111111,
                    "employee_age": 23,
                    "profile_image": "Perfect image"
                 }
  When
       PUT Request

Then
    i) Status code is 200
And
    ii) Response body should be like the following
                {
                    "status": "success",
                    "data": {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                    },
                    "message": "Successfully! Record has been updated."
                }
 */

    @Test
    public void put02() {
        spec.pathParams("first", "update", "second", 21);

        DummyRestApiDataPojo innerMap = new DummyRestApiDataPojo("Ali Can", 111111, 23, "Perfect image");

        DummyRestApiResponseBodyPojo expectedData = new DummyRestApiResponseBodyPojo("success", innerMap, "Successfully! Record has been updated.");
        // System.out.println("expectedData = " + expectedData);

        Response response = given().spec(spec).contentType(ContentType.JSON).body(innerMap).when().put("/{first}/{second}");
       // response.prettyPrint();

        DummyRestApiResponseBodyPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), DummyRestApiResponseBodyPojo.class);
      //  System.out.println("actualData = " + actualData);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedData.getStatus(), actualData.getStatus());
        assertEquals(innerMap.getEmployee_name(), actualData.getData().getEmployee_name());
        assertEquals(innerMap.getEmployee_salary(), actualData.getData().getEmployee_salary());
        assertEquals(innerMap.getEmployee_age(), actualData.getData().getEmployee_age());
        assertEquals(innerMap.getProfile_image(), actualData.getData().getProfile_image());
        assertEquals(expectedData.getMessage(), actualData.getMessage());


    }
}
