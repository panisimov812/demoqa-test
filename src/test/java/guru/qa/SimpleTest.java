package guru.qa;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

public class SimpleTest {

    @BeforeAll
    static void initDB(){
        System.out.println("333 @BeforeAll");
    }

    @BeforeEach
    void openYaPage() {
        System.out.println("333 @BeforeEach");
        Selenide.open("http://ya.ru");
    }

    @AfterEach
    void close(){
        WebDriverRunner.closeWindow();
    }

    @AfterAll

    @Test
    void assertTest(){
    }

    @Test
    void assertTest2(){
        Assertions.assertTrue(2<3);
    }
}
