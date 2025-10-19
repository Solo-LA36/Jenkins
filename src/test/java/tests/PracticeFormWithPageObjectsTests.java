package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.PracticeFormPages;
import tests.pageobjectmodel.TestBase;
import tests.pageobjectmodel.TestData;

@Tag("demoqa")
public class PracticeFormWithPageObjectsTests extends TestBase {
    PracticeFormPages practiceFormPages = new PracticeFormPages();
    TestData testData = new TestData();

    @Test
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