package pageobject;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationPage {
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.number().digits(10),
            subjectsInput = "Maths",
            currentAddress = faker.address().streetAddress(),
            state = "NCR",
            city = "Delhi";

    public void configurationMaximum() {
        Configuration.startMaximized = true;
    }

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");

    }

    public void fillForm() {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText("Male")).click();
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1994");
        $(".react-datepicker__month-select").selectOptionByValue("3");
        $(".react-datepicker__day.react-datepicker__day--022").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("avatar.jpg");
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();
    }

    public void checkData() {
        $(".modal-content").shouldHave
                (text(firstName),
                        text(lastName),
                        text(userNumber),
                        text(subjectsInput),
                        text(subjectsInput),
                        text(userEmail),
                        text(currentAddress),
                        text(state),
                        text(city),
                        text("avatar.jpg"),
                        text("Female"),
                        text("22 April,1994"));

    }
}
