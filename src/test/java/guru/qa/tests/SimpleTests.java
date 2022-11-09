package guru.qa.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

public class SimpleTests {

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
    static void cleanDB(){
        System.out.println("###    AfterAll");
    }

    @Test
    void assertTest(){
        System.out.println("###         Test 0");
    }

    @Test
    void assertTest1(){
        System.out.println("###         Test 1");
    }
    @Test
    void assertTest2(){
        System.out.println("###         Test 3");
    }
}
