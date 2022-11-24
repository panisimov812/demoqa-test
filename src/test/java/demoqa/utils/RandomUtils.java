package demoqa.utils;

import static demoqa.docks.RandomUtilsExamples.getRandomInt;
import static demoqa.docks.RandomUtilsExamples.getRandomString;

public class RandomUtils {
    public static void main(String[] args) {
        System.out.println("Random string 10 " + getRandomString(10));
        System.out.println("Random int 10 " + getRandomInt(122,2133));
    }
}
