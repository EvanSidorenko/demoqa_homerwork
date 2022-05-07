package test;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import components.Calendar;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.RegFormPage;

import java.util.Locale;
import static java.lang.String.format;

public class RegistrationFormTestsWithFaker {
    RegFormPage regFormPage = new RegFormPage();

    Faker faker = new Faker(new Locale("en"));
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userNumber = faker.numerify("##########");
    String address = faker.address().fullAddress();

    String checkFirstNameLastName = format("%s %s", firstName, lastName);
    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1280x609";
    }

    @Test
    void fillFormTest() {
        regFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender()
                .setUserNumber(userNumber)
                .setDateOfBirth()
                .setSubject()
                .setHobby()
                .uploadPicture()
                .setAddress(address)
                .selectState()
                .selectCity()
                .clickSubmit()

                .checkTitle("Thanks for submitting the form")
                .checkResult(checkFirstNameLastName)
                .checkResult(userEmail)
                .checkResult("Male")
                .checkResult("13 January,1992")
                .checkResult("English")
                .checkResult("Reading")
                .checkResult("download.jpg")
                .checkResult(address)
                .checkResult("Haryana")
                .checkResult("Karnal");

    }
}

