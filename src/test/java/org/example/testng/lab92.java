package org.example.testng;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

public class lab92 {

    @Test
    public void getRequest() {

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")

                .when().get()

                .then().statusCode(201);
    }

    @Test
    public void getRequest2() {

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")

                .when().get()

                .then().statusCode(201);

    }
}

