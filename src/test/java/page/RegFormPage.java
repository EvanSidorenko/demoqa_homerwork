package page;

import com.codeborne.selenide.SelenideElement;
import components.Calendar;
import components.StateAndCity;

import java.time.LocalDate;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegFormPage {
    Calendar calendar = new Calendar();
    StateAndCity stateAndCity = new StateAndCity();

    //  locators
    SelenideElement firstNameEnter = $("#firstName");
    SelenideElement lastNameEnter = $("#lastName");
    SelenideElement emailEnter = $("#userEmail");
    SelenideElement genderEnter = $("#genterWrapper");
    SelenideElement phoneNumberEnter = $("#userNumber");
    SelenideElement dateOfBirth = $("#dateOfBirthInput");
    SelenideElement subjectEnter = $("#subjectsInput");
    SelenideElement hobbyEnter =   $("#hobbiesWrapper");
    SelenideElement pictureUpload = $("#uploadPicture");
    SelenideElement addressEnter = $("#currentAddress");
    //check form
    SelenideElement titleName = $("#example-modal-sizes-title-lg");
    SelenideElement checkForm = $(".table-responsive");



    // actions
    public RegFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegFormPage setFirstName(String value) {
        firstNameEnter.setValue(value);
        return this;
    }
    public RegFormPage setLastName(String value) {
        lastNameEnter.setValue(value);
        return this;
    }
    public RegFormPage setEmail(String value) {
        emailEnter.setValue(value);
        return this;
    }
    public RegFormPage setGender(String gender) {
        genderEnter.$(byText(gender)).click();
        return this;
    }
    public RegFormPage setUserNumber(String value) {
        phoneNumberEnter.setValue(value);
        return this;
    }
    public RegFormPage setDateOfBirth(LocalDate birth) {
        dateOfBirth.click();
        calendar.setDate(birth);
        return this;
    }
    public RegFormPage setSubject(String subject){
        subjectEnter.setValue(subject).pressEnter();
        return this;
    }
    public RegFormPage setHobby(String hobby) {
        hobbyEnter.click();
        return this;
    }
    public RegFormPage uploadPicture(String imagePath) {
        pictureUpload.uploadFromClasspath("download.jpg");
        return this;
    }
    public RegFormPage setAddress(String address) {
        addressEnter.setValue(address);
        return this;
    }
    public RegFormPage setStateAndCity(String state, String city) {
        $("#state").click();
        stateAndCity.setState(state);
        $("#city").click();
        stateAndCity.setCity(city);
        return this;
    }
    public RegFormPage clickSubmit() {
        $("#submit").click();
        return this;
    }

    public RegFormPage checkTitle (String value) {
        titleName.shouldHave(text(value));
        return this;
    }
    public RegFormPage checkResult(String value) {
        checkForm.shouldHave(text(value));
        return this;
    }
}