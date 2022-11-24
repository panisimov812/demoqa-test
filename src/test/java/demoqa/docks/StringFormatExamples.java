package demoqa.docks;

import static demoqa.docks.RandomUtilsExamples.getRandomEmail;
import static java.lang.String.format;


public class StringFormatExamples {
    public static void main(String[] args) {
        String name = "testName";
        //вместо % подставятся сущности
        System.out.println(format("Hello, %s! How are %s?", name, "you"));
        System.out.println("Random email: " + getRandomEmail());
    }
}
