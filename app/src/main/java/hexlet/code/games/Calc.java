package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public final class Calc {
    private static final String RULES = "What is the result of the expression?";
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
            int firstNum = Engine.generateNumber(NUM_GENERATING_RANGE);
            String operator = generateOperator();
            int secondNum = Engine.generateNumber(NUM_GENERATING_RANGE);
            QUESTIONS[i] = fillQuestion(firstNum, operator, secondNum);
            ANSWERS[i] = fillAnswer(firstNum, operator, secondNum);
        }
    }

    public static String fillQuestion(int firstNum, String operator, int secondNum) {
        return firstNum + " " + operator + " " + secondNum;
    }

    public static String fillAnswer(int firstNumber, String operator, int secondNumber) {
        return String.valueOf(gameLogic(firstNumber, operator, secondNumber));
    }

    public static int gameLogic(int firstNum, String operator, int secondNum) {
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
