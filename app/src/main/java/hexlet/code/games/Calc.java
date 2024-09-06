package hexlet.code.games;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import hexlet.code.Engine;
import hexlet.code.utils.Utils;

public final class Calc {
    private static final String RULES = "What is the result of the expression?";
    private static final int NUM_GENERATING_RANGE = 20;

    public static void play() {
        Engine.start(RULES, generateQuestionsAndAnswers());
    }

    public static Map<String, String> generateQuestionsAndAnswers() {
        var questionsAndAnswers = new HashMap<String, String>();

        while (questionsAndAnswers.size() < Engine.MAX_WINS) {
            int firstNum = Utils.generateNumber(NUM_GENERATING_RANGE);
            String operator = generateOperator();
            int secondNum = Utils.generateNumber(NUM_GENERATING_RANGE);
            String question = firstNum + " " + operator + " " + secondNum;
            String answer = String.valueOf(calculate(firstNum, secondNum, operator));
            questionsAndAnswers.put(question, answer);
        }
        return questionsAndAnswers;
    }

    public static int calculate(int firstNum, int secondNum, String operator) {
        return switch (operator) {
            case "+" -> firstNum + secondNum;
            case "-" -> firstNum - secondNum;
            case "*" -> firstNum * secondNum;
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }

    public static String generateOperator() {
        final String[] operators = {"+", "-", "*"};
        int index = new Random().nextInt(operators.length);
        return operators[index];
    }

}
