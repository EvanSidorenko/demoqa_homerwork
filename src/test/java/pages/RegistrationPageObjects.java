package pages;

import com.demoqa.RegistrationFormTestsWithFaker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPageObjects {
    //  locators

    // actions
    public RegistrationPageObjects openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationPageObjects setFirstName(String value) {
        $("#firstName").setValue(value);
        return this;
    }

    public RegistrationPageObjects setLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }

    public RegistrationPageObjects setEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    public RegistrationPageObjects setGender() {
        $("#genterWrapper").$(byText("Male")).click();
    return this;
    }

    public RegistrationPageObjects setUserNumber(String value) {
        $("#userNumber").setValue(value);
    return this;
    }

    public RegistrationPageObjects setDateofBirth() {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("0");
        $(".react-datepicker__year-select").selectOptionByValue("1992");
        $(".react-datepicker__day.react-datepicker__day--013").click();
        return this;
    }

    public RegistrationPageObjects setSubject() {
        $("#subjectsInput").setValue("English").pressEnter();
        return this;
    }
    public RegistrationPageObjects setHobby() {
        $("#hobbiesWrapper").$(byText("Reading")).click();
        return this;
    }
    public RegistrationPageObjects uploadPicture() {
        $("#uploadPicture").uploadFromClasspath("download.jpg");
        return this;
    }
    public RegistrationPageObjects setAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }
    public RegistrationPageObjects selectState() {
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        return this;
    }
    public RegistrationPageObjects selectCity() {
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        return this;
    }
    public RegistrationPageObjects clickSubmit() {
        $("#submit").click();
        return this;
    }
    public RegistrationPageObjects checkResult(String value) {
        $("#example-modal-sizes-title-lg").shouldHave(
                text(value));
        $(".table-responsive").shouldHave(text(value));
        return this;
    }

}