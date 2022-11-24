package demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static demoqa.docks.RandomUtilsExamples.getRandomEmail;
import static demoqa.docks.RandomUtilsExamples.getRandomString;
import static java.lang.String.format;

public class RegistrationFormWithFakerUtilsTests {
    Faker faker = new Faker();

    String name = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phone = faker.phoneNumber().cellPhone();

    String expectedFullName = format("%s $s",name,lastName);


    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "http://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    public void fillRequiredFields() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('fixedban').remove()");

        //name field
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);

        //email field
        $("#userEmail").setValue(email);

        //Gender radioButtons
        $("#gender-radio-3").parent().click(); //поднимится выше к родителю

        //phone
        $("#userNumber").setValue(phone);

        //date Birth field
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("2021");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

        //subjects field
        $("#subjectsInput").setValue("Math").pressEnter();

        //hobbies check-box
        $("#hobbiesWrapper").$(byText("Sports")).click();

        //upload picture
        $("#uploadPicture").uploadFromClasspath("img/1.png");

        //current address
        $("#currentAddress").setValue("street1");

        //state and city
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();

        //submit btn
        $("#submit").click();

        //modal
        $("example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(name + " " + lastName), text(email), text("Other"));
        $(".table-responsive").shouldHave(text(expectedFullName), text(email), text("Other"));

    }
}