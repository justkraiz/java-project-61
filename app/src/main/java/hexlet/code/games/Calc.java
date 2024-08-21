package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calc {
    String rules = "What is the result of the expression?";
    String userAnswer = "";
    String rightAnswer = "";
    int firstNum = 0;
    int secondNum = 0;
    String operator = "";
    boolean isLose = false;

    public Calc() {
        Engine.start(rules);
        startGame();
    }

    public void startGame() {
        while(!isLose) {
            askQuestion();
            rightAnswer = setRightAnswer(firstNum, secondNum, operator);
            userAnswer = Engine.getUserAnswer();
            isLose = Engine.isLose(userAnswer, rightAnswer);
        }
    }

    public String setRightAnswer(int firstNum, int secondNum, String operator) {
        return String.valueOf(calculate(firstNum, secondNum, operator));
    }

    public void askQuestion() {
        firstNum = Engine.generateNumber();
        secondNum = Engine.generateNumber();
        operator = generateOperator();
        System.out.println("Question: " + firstNum + " " + operator + " " + secondNum);
    }

    public String generateOperator() {
        final String[] operators = {"+", "-", "*", "/"};
        int index = new Random().nextInt(operators.length);
        return operators[index];
    }

    public static int calculate(int firstNum, int secondNum, String operator) {
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
