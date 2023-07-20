package org.exampleapitest;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
//import Json.simple.JesonObject.*;
import org.asynchttpclient.Request;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Firstapitests {

    @Test
    public void validate_get_request(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=1");
        System.out.println(response.statusCode());
        System.out.println(response.asString());

        int statuscode = response.getStatusCode();
        Assert.assertEquals(statuscode, 200);
    }

    @Test
    public void bdd_validate_api(){
        given().get("https://reqres.in/api/users?page=1").then()
                .statusCode(200).body("data[0].id", equalTo(1));
    }

    @Test
    public void post_create_users(){
        JSONObject request= new JSONObject();
        request.put("Name","Kunti");
        request.put("job","Student");

        System.out.println(request);

        given().header("Content-Type","application/json")
                .body(request)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .body("job", equalTo("Student"));
    }
    @Test
    public void test_auth() {
        given().auth().basic("admin","admin").get("https://the-internet.herokuapp.com/basic_auth").then().statusCode(200);

    }
    @Test
    public void test_query_param(){
        given()
                .queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().statusCode(200);
    }
    @Test
    public void test_android(){
        given().get("https://generator.swagger.io/api/gen/clients").then().statusCode(200).body(containsString("android"));

    }
    @Test
    public void test_csharp(){
        given().get("https://generator.swagger.io/api/gen/clients").then().statusCode(200).body(containsString("csharp"));
    }
    @Test
    public void test_boolean(){
        given().get("https://generator.swagger.io/api/gen/clients/clojure").then().statusCode(200).body(containsString("boolean"));
    }



    @Test
    public void code_test(){
        String test = "Banana";
        int totalLower = test.replaceAll("[A-Z]","").length();
        System.out.println(totalLower);


    }
}