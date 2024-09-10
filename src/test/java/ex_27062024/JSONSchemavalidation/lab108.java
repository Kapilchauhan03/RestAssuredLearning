package ex_27062024.JSONSchemavalidation;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

public class lab108 {

    @Test
    public void JSvalidation (){
        RestAssured.given()
                .baseUri("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
                .when().get().then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema())
    }
}
