package hexlet.code.games;

import hexlet.code.Engine;

public final class Gcd {
    private int firstNum = 0;
    private int secondNum = 0;
    private boolean isLose = false;

    public Gcd() {
        String rules = "Find the greatest common divisor of given numbers.";
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
