package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Junit5Tests {


    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "http://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        // 1:45:10
        String name = "Test Name";
        String email = "test@email.de";
        String address = "test Address 3";
        open("/text-box");

        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue(email);
        $("[id=currentAddress]").setValue(address);
        $("[id=permanentAddress]").setValue("test Address 33");
        $("[id=submit]").click();

        //Asserts
        $("[id=output] [id=name]").shouldHave(text(name));
        $("[id=permanentAddress]",1).shouldHave(text("test Address 33"));
    }
}
