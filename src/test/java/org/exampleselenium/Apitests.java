package org.exampleselenium;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public
class Apitests {
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

}
