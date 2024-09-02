package ex_22062024.CRUD.GET.BDDStyle;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class lab94 {

    @Test
    public void getRequestBDDStyle (){

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/302017")

                .when().log().all().get()

                .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void getRequestBDDStyle2(){

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/122016")

                .when().log().all().get()

                .then()
                .log().all()
                .statusCode(200);

    }


}
