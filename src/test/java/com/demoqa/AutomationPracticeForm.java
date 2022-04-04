package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeForm {
    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        String firstName = "Thomas";
        String lastName = "Anderson";
        String userEmail = "neo@matrix.com";
        String userNumber = "9998887766";
        String adress = "Liberty st, room 101";

        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText("Male")).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("0");
        $(".react-datepicker__year-select").selectOptionByValue("1992");
        $(".react-datepicker__day.react-datepicker__day--013").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/download.jpg"));
        $("#currentAddress").setValue(adress);
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

      $("#example-modal-sizes-title-lg").shouldHave(
              text("Thanks for submitting the form"),
              text(firstName + " " + lastName),
              text(userEmail),
              text("Male"),
              text("13 January,1992"),
              text("English"),
              text("Reading"),
              text("download.jpg"),
              text(adress),
              text("Haryana Karnal"));
      $("#closeLargeModal").click();

    }
}
