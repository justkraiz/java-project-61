package hexlet.code.utils;

import java.util.Random;

public class Utils {

    //generate from 1 -> range
    public static int generateNumber(int range) {
        Random random = new Random();
        return random.nextInt(range) + 1;
    }

    //generate from min -> max values
    public static int generateNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1)  + min;
    }
}
