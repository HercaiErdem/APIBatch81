package odev;

import base_urls.AutomationExerciseBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.List;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
public class Alistirmalar01 extends AutomationExerciseBaseURL {
    //1:
 /*
        Given
            https://automationexercise.com/api/brandsList
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "text/html; charset=utf-8"
        And
            Status Line should be HTTP/1.1 200 OK
        And
             Number of H&M brands must be equal to Polo(H&M marka sayısı Polo marka sayısına eşit olmalı)
  */
    @Test
    public void test01() {
        // Set the URL
        specAuto.pathParam("pp1", "brandsList");
        // Set the expected data
        // Send the request and get the response
        Response response = given().spec(specAuto).get("{pp1}");
        // Do Assertion
        response.then().assertThat().
                statusCode(200).
                contentType("text/html; charset=utf-8").
                statusLine("HTTP/1.1 200 OK");
        JsonPath jsonPath = response.jsonPath();
        List<String> hmList = jsonPath.getList("brands.findAll{it.brand=='H&M'}.brand");
        List<String> poloList = jsonPath.getList("brands.findAll{it.brand=='Polo'}.brand");
        System.out.println("hmList = " + hmList);
        System.out.println("poloList = " + poloList);
        assertNotEquals(hmList.size(), poloList.size());
    }
}