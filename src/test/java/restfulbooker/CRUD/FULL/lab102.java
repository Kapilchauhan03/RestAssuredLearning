package restfulbooker.CRUD.FULL;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class lab102 {


    String token;
    Integer bookingId;
    RequestSpecification requestSpecification = RestAssured.given();
    ValidatableResponse validatableResponse;
    Response response;

    @BeforeTest
    public void getAToken(){
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        response = requestSpecification.post();

        validatableResponse = response.then();
        validatableResponse.statusCode(200);

        // Extract the token from the response
        token = response.then().log().all().extract().path("token");
        Assert.assertNotNull(token);

    }

    @BeforeTest
    public void getBookingID(){

        String payload = "{\n" +
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

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        response = requestSpecification.when().post();

        ValidatableResponse validatableResponse= response.then();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse.statusCode(200);

        bookingId = response.then().log().all().extract().path("bookingid");
        String firstName = response.then().log().all().extract().path("booking.firstname");
        System.out.println(firstName);
        System.out.println(bookingId);
        Assert.assertNotNull(bookingId);
    }

    @Test
    public void testPUTRequestPositive (){

        System.out.println("- Test case PUT Request ");
        String payload = "{\n" +
                "    \"firstname\" : \"Kapil\",\n" +
                "    \"lastname\" : \"joshh\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-08-15\",\n" +
                "        \"checkout\" : \"2024-08-26\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast,lunch,dinner\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("booking/"+bookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);


        requestSpecification.body(payload).log().all();

        response = requestSpecification.when().put();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        String firstNameResponse = response.then().log().all().extract().path("firstname");
        Assert.assertEquals(firstNameResponse,"Kapil");

        String fullResponseJSONString = response.asString();
        System.out.println(fullResponseJSONString);

        // Verify all the keys and value pairs in the response
        // firstname, lastname, deposit, totla,. checkin


        // 3 Ways You can verify the response

        // 1. RA - Matchers
        validatableResponse.body("firstname", Matchers.equalTo("Kapil"));
        validatableResponse.body("lastname", Matchers.equalTo("joshh"));

        //  2. TestNG Asserts -
        //  Assert.assertEquals(firstNameResponse,"Pramod");
//        String firstNameResponse = response.then().log().all().extract().path("firstname");
//        Assert.assertEquals(firstNameResponse,"Kapil");

        // 3 TestNG Assertion with JSON Path Lib
        JsonPath jsonPath = new JsonPath(fullResponseJSONString);
        String firstNameJSONPathExtracted = jsonPath.getString("firstname");
        String lastNameJSONPathExtracted = jsonPath.getString("lastname");
        Integer totalpriceJSONPathExtracted = jsonPath.getInt("totalprice");
        String checkinDate = jsonPath.getString("bookingdates.checkin");


        Assert.assertEquals(firstNameJSONPathExtracted,"Kapil");
        Assert.assertEquals(lastNameJSONPathExtracted,"joshh");
        Assert.assertEquals(totalpriceJSONPathExtracted,111);
        Assert.assertEquals(checkinDate,"2024-08-15");
        Assert.assertNotNull(totalpriceJSONPathExtracted);

    }

}
