package test;

import com.codeborne.selenide.Configuration;
import data.Faker;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.RegFormPage;

import java.time.LocalDate;

import static java.lang.String.format;

public class RegistrationFormTestsWithFaker {
    RegFormPage regFormPage = new RegFormPage();
    Faker faker = new Faker();

    //FakerData
    String firstName = faker.getFirstName();
    String lastName = faker.getLastName();
    String userEmail = faker.getUserEmail();
    String userGender = faker.getGender();
    String userNumber = faker.getUserNumber();
    String userAddress = faker.getAddress();
    String userSubject = faker.getSubject();
    LocalDate birthDate = faker.getDate();
    String hobby = faker.getHobby();
    String imagePath = "download.jpg";
    String state = faker.getState();
    String city = faker.getCity(state);


    //expected results
    String expectedFirstNameLastName = format("%s %s", firstName, lastName);
    String expectedMonth = StringUtils.capitalize(birthDate.getMonth().toString().toLowerCase());
    String expectedDate = format("%s %s,%s", birthDate.getDayOfMonth(), expectedMonth, birthDate.getYear());
    String expectedStateAndCity = format("%s %s", state, city);

    String expectedFileName = imagePath.substring(8);
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
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth(birthDate)
                .setSubject(userSubject)
                .setHobby(hobby)
                .uploadPicture(imagePath)
                .setAddress(userAddress)
                .setStateAndCity(state,city)
                .clickSubmit()

                .checkTitle("Thanks for submitting the form")
                .checkResult(expectedFirstNameLastName)
                .checkResult(userEmail)
                .checkResult(userGender)
                .checkResult(userNumber)
                .checkResult(expectedDate)
                .checkResult(userSubject)
                .checkResult(expectedFileName)
                .checkResult(userAddress)
                .checkResult(expectedStateAndCity);

    }
}

