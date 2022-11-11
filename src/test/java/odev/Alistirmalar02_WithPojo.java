package odev;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ReqresPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Alistirmalar02_WithPojo extends ReqresBaseUrl {
    /*
    //2:  Map ve Pojo Class ile ayrı ayrı yapınız.
    Given
            1) https://reqres.in/api/users
            2) {
        "name": "morpheus",
                "job": "leader"
    }
    When
    I send POST Request to the Url
            Then
    Status code is 201
    And response body should be like
    {
        "name": "morpheus",
            "job": "leader",
            "id": "496",
            "createdAt": "2022-10-04T15:18:56.372Z"
    }
     */

    @Test
    public void get02Pojo() {

        // Set the Url
        spec.pathParam("pp1", "users");

        // Set the Expected Data
        ReqresPojo expectedData = new ReqresPojo("morpheus", "leader");
        //  System.out.println("expectedData = " + expectedData);

        // Send the Url and Get the Response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData)
                .when().post("/{pp1}");
       // response.prettyPrint();

        //Do Assertion

        ReqresPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), ReqresPojo.class);
        // .out.println("actualData = " + actualData);

        assertEquals(201, response.getStatusCode());
        assertEquals(expectedData.getName(), actualData.getName());
        assertEquals(expectedData.getJob(), actualData.getJob());


    }
}
