package hexlet.code.games;

import hexlet.code.Engine;

public final class Even {
    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
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
        return gameLogic(number);
    }

    public static String gameLogic(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}

