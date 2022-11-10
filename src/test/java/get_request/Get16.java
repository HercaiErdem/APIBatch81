package get_request;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.*;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class Get16 extends DummyRestApiBaseUrl {
/*
           URL: https://dummy.restapiexample.com/api/v1/employees
           HTTP Request Method: GET Request
           Test Case: Type by using Gherkin Language
           Assert:  i) Status code is 200
                   ii) There are 24 employees
                  iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                   iv) The greatest age is 66
                    v) The name of the lowest age is "Tatyana Fitzpatrick"
                   vi) Total salary of all employees is 6,644,770
    */
    /*
    Given
         https://dummy.restapiexample.com/api/v1/employees
    When
        User sends get request
    Then
        i) Status code is 200
     And
             ii) There are 24 employees
     And
            iii) "Tiger Nixon" and "Garrett Winters" are among the employees
     And
             iv) The greatest age is 66
     And
              v) The name of the lowest age is "Tatyana Fitzpatrick"
    And
             vi) Total salary of all employees is 6,644,770
     */

    @Test
    public void get16() {
        spec.pathParam("first", "employees");

        Response response = given().spec(spec).when().get("/{first}");
        //  response.prettyPrint();

        response.then().assertThat().statusCode(200).body("data.id", hasSize(24),
                "data.employee_name", hasItems("Tiger Nixon", "Garrett Winters"));

        List<Integer> ages = response.jsonPath().getList("data.employee_age");
        System.out.println(ages);
        Collections.sort(ages);
        System.out.println("Sorted ages = " + ages);
        // List leri yazdirirsak kalici olarak degisir, List Mutiple dir,
        // uzerine yapilan degisiklik kalici olarak degisir
        System.out.println(ages.get(ages.size() - 1));
        assertEquals(66, ages.get(ages.size()) - 1);

        String lowestAgeEmployee = response.jsonPath().getString("data.findAll{it.employee_age==" + ages.get(0) + "}.employee_name");


        // Bir body icinde assert yapinca o soft assert olur


    }
}
