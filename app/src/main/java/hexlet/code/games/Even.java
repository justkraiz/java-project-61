package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Utils;

import java.util.HashMap;
import java.util.Map;

public final class Even {
    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int NUM_GENERATING_RANGE = 20;
    private static final int LENGTH = Engine.MAX_WINS;

    public static void play() {
        Engine.start(RULES, preparation(LENGTH));
    }

    public static Map<String, String> preparation(int length) {
        var questionsAndAnswers = new HashMap<String, String>();

        while (questionsAndAnswers.size() < length) {
            int number = Utils.generateNumber(NUM_GENERATING_RANGE);
            String question = String.valueOf(number);
            String answer = gameLogic(number);
            questionsAndAnswers.put(question, answer);
        }
        return questionsAndAnswers;
    }

    public static String gameLogic(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}

