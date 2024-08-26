package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public final class Calc {

    private int firstNum = 0;
    private int secondNum = 0;
    private String operator = "";

    private boolean isLose = false;

    public Calc() {
        String rules = "What is the result of the expression?";
        Engine.start(rules);
        startGame();
    }

    public void startGame() {
        while (!isLose) {
            askQuestion();
            String rightAnswer = setRightAnswer();
            String userAnswer = Engine.getUserAnswer();
            isLose = Engine.isLose(userAnswer, rightAnswer);
        }
    }

    public String setRightAnswer() {
        return String.valueOf(calculate());
    }

    public void askQuestion() {
        firstNum = Engine.generateNumber();
        secondNum = Engine.generateNumber();
        operator = generateOperator();
        System.out.printf("Question: %d %s %d%n", firstNum, operator, secondNum);
    }

    public String generateOperator() {
        final String[] operators = {"+", "-", "*"};
        int index = new Random().nextInt(operators.length);
        return operators[index];
    }

    public int calculate() {
        return switch (operator) {
            case "+" -> firstNum + secondNum;
            case "-" -> firstNum - secondNum;
            case "*" -> firstNum * secondNum;
            case "/" -> {
                if (secondNum == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                    throw new ArithmeticException("Division by zero");
                }
                yield firstNum / secondNum;
            }
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }
}
