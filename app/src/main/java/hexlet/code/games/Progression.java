package hexlet.code.games;

import hexlet.code.Engine;

public final class Progression {


    private static final String RULES = "What number is missing in the progression?";
    private static final int NUM_GENERATING_RANGE = 20;
    private static final int PROGRESSION_SIZE_MAX = 10;
    private static final int PROGRESSION_SIZE_MIN = 5;

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
            int valBetweenNext = Engine.generateNumber(NUM_GENERATING_RANGE);
            int size = Engine.generateNumber(PROGRESSION_SIZE_MIN, PROGRESSION_SIZE_MAX);
            int hiddenIndexInArray = Engine.generateNumber(0, size - 1);
            int[] progression = gameLogic(firstNumber, valBetweenNext, size);
            QUESTIONS[i] = fillQuestion(progression, hiddenIndexInArray);
            ANSWERS[i] = fillAnswer(progression, hiddenIndexInArray);
        }
    }

    public static int[] generateProgression(int firstNumber, int valBetweenNext, int size) {
        int[] progression = new int[size];
        progression[0] = firstNumber;
        for (int i = 1; i < size; i++) {
            progression[i] = progression[i - 1] + valBetweenNext;
        }
        return progression;
    }

    public static String fillQuestion(int[] progression, int hiddenIndex) {
        StringBuilder sb = new StringBuilder();
        for (var num: progression) {
            if (num == progression[hiddenIndex]) {
                sb.append(".. ");
            } else {
                sb.append(num).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static String fillAnswer(int[] progression, int hiddenIndex) {
        return String.valueOf(progression[hiddenIndex]);
    }

    public static int[] gameLogic(int firstNumber, int valBetweenNext, int size) {
        return generateProgression(firstNumber, valBetweenNext, size);
    }
}
