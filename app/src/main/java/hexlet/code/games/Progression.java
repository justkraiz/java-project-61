package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Utils;

import java.util.HashMap;

public final class Progression {


    private static final String RULES = "What number is missing in the progression?";
    private static final int NUM_GENERATING_RANGE = 20;
    private static final int PROGRESSION_SIZE_MAX = 10;
    private static final int PROGRESSION_SIZE_MIN = 5;
    private static final int LENGTH = Engine.MAX_WINS;

    public static void play() {
        Engine.start(RULES, preparation(LENGTH));
    }

    public static HashMap<String, String> preparation(int length) {
        var questionsAndAnswers = new HashMap<String, String>();

        while (questionsAndAnswers.size() < length) {
            int firstNumber = Utils.generateNumber(NUM_GENERATING_RANGE);
            int valBetweenNext = Utils.generateNumber(NUM_GENERATING_RANGE);
            int size = Utils.generateNumber(PROGRESSION_SIZE_MIN, PROGRESSION_SIZE_MAX);
            int hiddenIndexInArray = Utils.generateNumber(0, size - 1);

            int[] progression = Utils.generateProgression(firstNumber, valBetweenNext, size);
            String question = hideIndexInProgression(progression, hiddenIndexInArray);
            String answer = String.valueOf(progression[hiddenIndexInArray]);
            questionsAndAnswers.put(question, answer);
        }
        return questionsAndAnswers;
    }

    public static String hideIndexInProgression(int[] progression, int hiddenIndex) {
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
}
