package ex_27062024.gson.Serialization;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class lab107 {


    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;


        @Description("TC#1 -Verify that create booking is working with valid payload")
    @Test
    public void testnonBDDStylePOSTPositive() {

        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";

        Booking booking = new Booking();
        booking.setFirstname("kapil");
        booking.setLastname("Chouhan");
        booking.setTotalprice(100);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-05");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking.toString());

        // Serilization -- now will convert object to JSON String

            Gson gson = new Gson();
            String jsonStringPayload = gson.toJson(booking);
            System.out.println(jsonStringPayload);

//        r.baseUri(BASE_URL);
//        r.basePath(BASE_PATH);
//        r.contentType(ContentType.JSON).log().all();
//        r.body(booking);
//
//        response = r.when().log().all().post();
//        String responseString = response.asString();
//        System.out.println(responseString);
//
//
//        validatableResponse = response.then();
//        validatableResponse.statusCode(200);

    }
}




