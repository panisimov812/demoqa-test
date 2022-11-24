package demoqa.docks;

import java.util.Random;

public class RandomUtilsExamples {

    public static String getRandomString(int lenth) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < lenth) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }
        return result.toString();
    }

    public static int getRandomInt(int min, int max) {
        Random r = new Random();

        return r.nextInt((max - min) + 1) + min;
    }

    public static String getRandomEmail() {
        String emailDomain = "@test.ru";

        return getRandomString(10) + emailDomain;
    }


}

