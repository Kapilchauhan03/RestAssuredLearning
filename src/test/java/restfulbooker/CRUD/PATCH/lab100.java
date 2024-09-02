package restfulbooker.CRUD.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class lab100 {


    RequestSpecification r = RestAssured.given();

    Response response;
    ValidatableResponse vr;
    String token="460a07946cd1c45";
    String bookingid="1941";
    String BASE_URL = "https://restful-booker.herokuapp.com";
    String BASE_PATH = "/booking";

    @Test
    public void testPatchRequestNonBDD(){
        String BASE_PATH_UPDTATED = BASE_PATH +"/" +bookingid;
        System.out.println(BASE_PATH_UPDTATED);

        String payload = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH_UPDTATED);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(payload).log().all();

        response = r.when().log().all().patch();

        vr = response.then().log().all();
        vr.statusCode(200);
        vr.body("firstname", Matchers.equalTo("James"));
        vr.body("lastname", Matchers.equalTo("Brown"));



    }
}
