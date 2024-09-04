package hexlet.code.games;

import java.util.HashMap;
import hexlet.code.Engine;
import hexlet.code.utils.Utils;

public final class Calc {
    private static final String RULES = "What is the result of the expression?";
    private static final int NUM_GENERATING_RANGE = 20;
    private static final int LENGTH = Engine.MAX_WINS;

    public static void play() {
        Engine.start(RULES, preparation(LENGTH));
    }

    public static HashMap<String, String> preparation(int length) {
        var questionsAndAnswers = new HashMap<String, String>();

        while (questionsAndAnswers.size() < length) {
            int firstNum = Utils.generateNumber(NUM_GENERATING_RANGE);
            String operator = Utils.generateOperator();
            int secondNum = Utils.generateNumber(NUM_GENERATING_RANGE);
            String question = firstNum + " " + operator + " " + secondNum;
            String answer = String.valueOf(gameLogic(firstNum, operator, secondNum));
            questionsAndAnswers.put(question, answer);
        }
        return questionsAndAnswers;
    }

    public static int gameLogic(int firstNum, String operator, int secondNum) {
        return switch (operator) {
            case "+" -> firstNum + secondNum;
            case "-" -> firstNum - secondNum;
            case "*" -> firstNum * secondNum;
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }

}
