package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Utils;

import java.util.HashMap;
import java.util.Map;

public final class Gcd {
    private static final String RULES = "Find the greatest common divisor of given numbers.";
    private static final int NUM_GENERATING_RANGE = 20;
    private static final int LENGTH = Engine.MAX_WINS;

    public static void play() {
        Engine.start(RULES, preparation(LENGTH));
    }

    public static Map<String, String> preparation(int length) {
        var questionsAndAnswers = new HashMap<String, String>();

        while (questionsAndAnswers.size() < length) {
            int firstNumber = Utils.generateNumber(NUM_GENERATING_RANGE);
            int secondNumber = Utils.generateNumber(NUM_GENERATING_RANGE);
            String question = firstNumber + " " + secondNumber;
            String answer = String.valueOf(gameLogic(firstNumber, secondNumber));
            questionsAndAnswers.put(question, answer);
        }
        return questionsAndAnswers;
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
