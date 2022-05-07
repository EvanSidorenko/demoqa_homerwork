package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPageObjects;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTestsWithFaker {
    RegistrationPageObjects registrationPageObjects = new RegistrationPageObjects();

    Faker faker = new Faker(new Locale("en"));

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1280x609";

    }

    @Test
    void fillFormTest() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String userNumber = "9998887766";
        String address = faker.address().fullAddress();

        registrationPageObjects.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender()
                .setUserNumber(userNumber)
                .setDateofBirth()
                .setSubject()
                .setHobby()
                .uploadPicture()
                .setAddress(address)
                .selectState()
                .selectCity()
                .clickSubmit()

                .checkResult(firstName + " " + lastName)
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

