package ex_27062024;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class lab105 {

    // Payload using map ( Hashmap )
    // Hoe to written Payload using Hashmap


    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;


    @Test
    public void testPOSTReq(){

        Map<String, Object>jsonBodyUsingMap = new LinkedHashMap<>();
        Faker faker = new Faker();
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();

        jsonBodyUsingMap.put("firstname",firstname);
        jsonBodyUsingMap.put("lastname", lastname);
        //jsonBodyUsingMap.put("totalprice", 111);
        jsonBodyUsingMap.put("totalprice",faker.random().nextInt(1000));
        jsonBodyUsingMap.put("depositpaid",faker.random().nextBoolean());

        Map<String, Object>bookingdatesMap = new LinkedHashMap<>();
        bookingdatesMap.put("checkin", "2018-01-01");
        bookingdatesMap.put("checkout", "2019-01-01");

        jsonBodyUsingMap.put("bookingdates", bookingdatesMap);

        jsonBodyUsingMap.put("additionalneeds", "Breakfast");

        System.out.println(jsonBodyUsingMap);

        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";

        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH);
        r.contentType(ContentType.JSON).log().all();
        r.body(jsonBodyUsingMap);

        response =  r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);


        validatableResponse =response.then();
        validatableResponse.statusCode(200);



    }
}
