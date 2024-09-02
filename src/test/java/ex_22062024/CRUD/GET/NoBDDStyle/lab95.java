package ex_22062024.CRUD.GET.NoBDDStyle;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class lab95 {

    RequestSpecification rs = RestAssured.given();
    // Request Specification is a Interface -

    @Test
    public void getRequestNotBDDStyle(){


        rs.baseUri("https://api.zippopotam.us");
        rs.basePath("/IN/302017");


        rs.when().log().all().get();
        rs.then().log().all().statusCode(200);
    }

    @Test
    public void getRequestNotBDDStyle2(){

     //   RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://api.zippopotam.us");
        rs.basePath("/IN/122016");


        rs.when().log().all().get();
        rs.then().log().all().statusCode(200);
    }

}
