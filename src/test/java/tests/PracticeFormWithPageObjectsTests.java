package tests;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class PracticeFormWithPageObjectsTests extends TestBase {
    PracticeFormPages practiceFormPages = new PracticeFormPages();
    TestData testData = new TestData();

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Test
    @Tag("demoqa")
    void fillFormTest() {
        practiceFormPages.openPage()
                .removeAds()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setNumber(testData.mobileNumber)
                .setDateOfBirth(testData.birthday[0], testData.birthday[1], testData.birthday[2])
                .setSubjects(testData.subjects)
                .setHobbies(testData.hobbies)
                .uploadPicture(testData.uploadFile)
                .setAddress(testData.address)
                .selectStateAndCity(testData.stateAndCity[0], testData.stateAndCity[1])
                .submitForm();

        practiceFormPages.verifyResultModalAppears()
                .verifyResult("Student Name", testData.expectedFullName)
                .verifyResult("Student Email", testData.email)
                .verifyResult("Gender", testData.gender)
                .verifyResult("Mobile", testData.mobileNumber)
                .verifyResult("Date of Birth", testData.expectedBirthday)
                .verifyResult("Subjects", testData.subjects)
                .verifyResult("Hobbies", testData.hobbies)
                .verifyResult("Picture", testData.uploadFile)
                .verifyResult("Address", testData.address)
                .verifyResult("State and City", testData.expectedStateAndCity);
    }
}