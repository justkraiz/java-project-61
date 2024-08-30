package hexlet.code.games;

import hexlet.code.Engine;

public final class Gcd {
    private static final String RULES = "Find the greatest common divisor of given numbers.";
    private static final int NUM_GENERATING_RANGE = 20;

    private static final int LENGTH = Engine.getMaxWins();
    private static final String[] QUESTIONS = new String[LENGTH];
    private static final String[] ANSWERS = new String[LENGTH];

    public static void play() {
        preparation(LENGTH);
        Engine.start(RULES, QUESTIONS, ANSWERS);
    }

    public static void preparation(int length) {
        for (int i = 0; i < length; i++) {
            int firstNumber = Engine.generateNumber(NUM_GENERATING_RANGE);
            int secondNumber = Engine.generateNumber(NUM_GENERATING_RANGE);
            QUESTIONS[i] = fillQuestion(firstNumber, secondNumber);
            ANSWERS[i] = fillAnswer(firstNumber, secondNumber);
        }
    }

    public static String fillQuestion(int firstNumber, int secondNumber) {
        return firstNumber + " " + secondNumber;
    }

    public static String fillAnswer(int firstNumber, int secondNumber) {
        return String.valueOf(gameLogic(firstNumber, secondNumber));
    }

    public static int gameLogic(int x, int y) {
        while (x != y) {
            if (x > y) {
                x = x - y;
            } else {
                y = y - x;
            }
        }
        return x;
    }
}
