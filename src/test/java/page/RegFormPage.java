package page;

import com.codeborne.selenide.SelenideElement;
import components.Calendar;
import components.StateAndCity;

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
    SelenideElement genderEnter = $("#genterWrapper").$(byText("Male"));
    SelenideElement phoneNumberEnter = $("#userNumber");
    SelenideElement dateOfBirth = $("#dateOfBirthInput");
    SelenideElement subjectEnter = $("#subjectsInput");
    SelenideElement hobbyEnter =   $("#hobbiesWrapper").$(byText("Reading"));
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
    public RegFormPage setGender() {
     genderEnter.click();
        return this;
    }
    public RegFormPage setUserNumber(String value) {
      phoneNumberEnter.setValue(value);
        return this;
    }
    public RegFormPage setDateOfBirth() {
        dateOfBirth.click();
        calendar.setDate();
        return this;
    }
    public RegFormPage setSubject() {
        subjectEnter.setValue("English").pressEnter();
        return this;
    }
    public RegFormPage setHobby() {
        hobbyEnter.click();
        return this;
    }
    public RegFormPage uploadPicture() {
        pictureUpload.uploadFromClasspath("download.jpg");
        return this;
    }
    public RegFormPage setAddress(String value) {
        addressEnter.setValue(value);
        return this;
    }
    public RegFormPage selectState() {
        StateAndCity.setState();
        return this;
    }
    public RegFormPage selectCity() {
        StateAndCity.setCity();
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
