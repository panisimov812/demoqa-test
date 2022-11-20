package demoqa.docks;

import static java.lang.String.format;

public class StringFormatExamples {
    public static void main(String[] args) {
        String name = "testName";
        //вместо % подставятся сущности
        System.out.println(format("Hello, %s! How are %s?", name, "you"));
    }
}
