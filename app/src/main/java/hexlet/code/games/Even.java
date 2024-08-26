package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    String userAnswer = "";
    String rightAnswer = "";
    String question = "";
    boolean isLose = false; // stop while cycle when lose

    public Even() {
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
        question = String.valueOf(Engine.generateNumber());
        System.out.println("Question: " + question);
    }
    public String setRightAnswer() {
        return Integer.parseInt(question) % 2 == 0 ? "yes" : "no";
    }

}
