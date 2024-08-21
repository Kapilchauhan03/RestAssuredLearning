package org.example.ex_ra01;

import io.restassured.RestAssured;

public class lab90 {
    public static void main(String[] args) {



        // Rest assured Hello word Programme
        // Given When Than Structure is followed gg

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")

                .when().get()

                .then().statusCode(200);
    }



}
