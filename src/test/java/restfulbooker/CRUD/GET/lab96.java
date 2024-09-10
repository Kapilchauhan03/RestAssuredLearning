package restfulbooker.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class lab96 {

    @Test
    public void getRequestPositive(){

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/2002").log().all();
        r.when().get();
        r.then().statusCode(200).log().all();
    }

    @Test
    public void getRequestnegative(){

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/-1").log().all();
        r.when().get();
        r.then().statusCode(404).log().all();
    }
}

