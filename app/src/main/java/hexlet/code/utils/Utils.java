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

    //generate operator
    public static String generateOperator() {
        final String[] operators = {"+", "-", "*"};
        int index = new Random().nextInt(operators.length);
        return operators[index];
    }

    //generate progression
    public static int[] generateProgression(int firstNumber, int valBetweenNext, int size) {
        int[] progression = new int[size];
        progression[0] = firstNumber;
        for (int i = 1; i < size; i++) {
            progression[i] = progression[i - 1] + valBetweenNext;
        }
        return progression;
    }
}
