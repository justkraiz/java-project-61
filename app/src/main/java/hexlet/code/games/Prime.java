package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    String rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    int question = 0;
    String userAnswer = "";
    String rightAnswer = "";
    boolean isLose = false;

    public Prime() {
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

    public String setRightAnswer() {
        return isPrime(question) ? "yes" : "no";
    }

    public void askQuestion() {
        question = Engine.generateNumber();
        System.out.println("Question: " + question);
    }


    public boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
