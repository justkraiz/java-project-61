package hexlet.code.games;

import hexlet.code.Engine;

public final class Prime {
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
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
            int number = Engine.generateNumber(NUM_GENERATING_RANGE);
            QUESTIONS[i] = fillQuestion(number);
            ANSWERS[i] = fillAnswer(number);
        }
    }

    public static String fillQuestion(int number) {
        return String.valueOf(number);
    }


    public static String fillAnswer(int number) {
        return gameLogic(number) ? "yes" : "no";
    }

    public static boolean gameLogic(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
