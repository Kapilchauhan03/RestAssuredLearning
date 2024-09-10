package ex_25062024;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class lab103 {

    @Test
    public void testfaker(){

        Faker faker = new Faker();
        String username = faker.name().username();
        String phonenumber = faker.phoneNumber().cellPhone();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String address = faker.address().fullAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String country = faker.address().country();

        System.out.println(username);
        System.out.println(phonenumber);
        System.out.println(email);
        System.out.println(password);
        System.out.println(address);
        System.out.println(city);
        System.out.println(state);
        System.out.println(country);
    }
}
