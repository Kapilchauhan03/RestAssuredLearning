package restfulbooker.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class lab99 {


    RequestSpecification r = RestAssured.given();

    Response response;
    ValidatableResponse vr;
    String token = "57bc2e953bf9650";
    String bookingid = "1639";
    String BASE_URL = "https://restful-booker.herokuapp.com";
    String BASE_PATH = "/booking";

    @Test
    public void testPutRequestNonBDD(){
        String BASE_PATH_UPDTATED = BASE_PATH +"/" +bookingid;
        System.out.println(BASE_PATH_UPDTATED);

        String payload ="{\n" +
                "    \"firstname\" : \"Jimmyy\",\n" +
                "    \"lastname\" : \"joshh\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-08-15\",\n" +
                "        \"checkout\" : \"2024-08-26\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast,lunch,dinner\"\n" +
                "}";

        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH_UPDTATED);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(payload).log().all();

        response = r.when().log().all().put();

        vr = response.then().log().all();
        vr.statusCode(200);
        vr.body("firstname", Matchers.equalTo("Jimmyy"));
        vr.body("lastname", Matchers.equalTo("joshh"));


    }
}
