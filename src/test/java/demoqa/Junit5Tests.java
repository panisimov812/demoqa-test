package demoqa;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;

public class Junit5Tests {

    @Test
    void fillFormTest() {
        open("http://demoqa.com/text-box");
    }
}
