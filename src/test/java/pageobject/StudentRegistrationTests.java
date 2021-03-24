package pageobject;

import org.junit.jupiter.api.Test;

public class StudentRegistrationTests {
    StudentRegistrationPage StudentRegistrationPage = new StudentRegistrationPage();

    @Test
    void successfulFillTest() {
        StudentRegistrationPage.openPage();
        StudentRegistrationPage.fillForm();
        StudentRegistrationPage.checkData();

    }
}
