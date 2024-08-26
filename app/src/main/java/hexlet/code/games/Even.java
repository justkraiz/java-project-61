package hexlet.code.games;

import hexlet.code.Engine;

public final class Even {

    private String question = "";

    private boolean isLose = false; // stop while cycle when lose

    public Even() {
        String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
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
        question = String.valueOf(Engine.generateNumber());
        System.out.println("Question: " + question);
    }
    public String setRightAnswer() {
        return Integer.parseInt(question) % 2 == 0 ? "yes" : "no";
    }

}
