package pages;

import com.codeborne.selenide.SelenideElement;
import pages.comonents.CalendarComponent;
import pages.comonents.RegistrationResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PracticeFormPages {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();



    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitTab = $("#submit");


    public PracticeFormPages openPage() {
        open("/automation-practice-form");

        return this;
    }


    public PracticeFormPages setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPages setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPages setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public PracticeFormPages setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public PracticeFormPages setNumber(String value) {
        numberInput.setValue(value);

        return this;
    }


    public PracticeFormPages setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);


        return this;
    }

    public PracticeFormPages setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPages setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public PracticeFormPages uploadPicture(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    public PracticeFormPages setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public PracticeFormPages selectStateAndCity(String state, String city) {
        stateInput.click();
        $(byText(state)).click();
        cityInput.click();
        $(byText(city)).click();

        return this;
    }

    public PracticeFormPages submitForm() {
        submitTab.click();

        return this;
    }

    public PracticeFormPages removeAds() {
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        return this;
    }

    public PracticeFormPages verifyResultModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }
    public PracticeFormPages verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }
    public PracticeFormPages verifyResultModalAppearsNeg() {
        registrationResultsModal.verifyModalAppearsNegativ();

        return this;
    }
}