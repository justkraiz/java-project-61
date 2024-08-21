package hexlet.code;

import java.util.Random;

public class Even {
    String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    String userAnswer = "";
    String rightAnswer = "";
    String question = "";
    boolean isLose = false;

    public Even() {
    Engine.printRules(rules);
    startGame();
    }

    private void startGame() {
        while(!isLose) {
            askQuestion();
            rightAnswer = setRightAnswer();
            userAnswer = Engine.getUserAnswer();
            isLose = Engine.isLose(userAnswer, rightAnswer);
        }


    }
    private void askQuestion() {
        question = generateNumber();
        System.out.println("Question: " + question);
    }
    private String setRightAnswer() {
        return Integer.parseInt(question) % 2 == 0 ? "yes" : "no";
    }

    private String generateNumber() {
        Random random = new Random();

        int randomNumber = random.nextInt(20) + 1; // Generate random num 1-20;
        return String.valueOf(randomNumber);
    }
}
