package hexlet.code.games;

import hexlet.code.Engine;

public class Gcd {
    String rules = "Find the greatest common divisor of given numbers.";
    String userAnswer = "";
    String rightAnswer = "";
    int firstNum = 0;
    int secondNum = 0;
    boolean isLose = false;

    public Gcd() {
        Engine.start(rules);
        startGame();
    }

    public void startGame() {
        while (!isLose) {
            askQuestion();
            rightAnswer = setRightAnswer();
            userAnswer = Engine.getUserAnswer();
            isLose = Engine.isLose(userAnswer, rightAnswer);
        }
    }

    public void askQuestion() {
        firstNum = Engine.generateNumber();
        secondNum = Engine.generateNumber();
        System.out.println("Question: " + firstNum + " " + secondNum);
    }

    public String setRightAnswer() {
        return String.valueOf(getNodOf(firstNum, secondNum));
    }

    public int getNodOf(int x, int y) {
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
