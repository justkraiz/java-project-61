package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {
    int firstNum = 0;
    int valueBetweenNextNum = 0;
    int numberOfTerms = 0;
    int hiddenIndexInArray = 0;

    int[] question;
    String rightAnswer = "";
    String userAnswer = "";

    boolean isLose = false; // stop while cycle when lose

    String rules = "What number is missing in the progression?";

    public Progression() {
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
        return String.valueOf(question[hiddenIndexInArray]);
    }

    public void askQuestion() {
        firstNum = Engine.generateNumber();
        valueBetweenNextNum = Engine.generateNumber();
        numberOfTerms = Engine.generateNumberInRange(5, 10);
        hiddenIndexInArray = Engine.generateNumberInRange(0, numberOfTerms - 1);
        question = generateProgression();
        System.out.println("Question: ");
        questionArrPrinter();
    }

    public void questionArrPrinter() {
        for (int i = 0; i < question.length; i++) {
            System.out.print(i == hiddenIndexInArray ? ".. " : question[i] + " ");
        }
        System.out.println();
    }


    public int[] generateProgression() {
        var array = new int[numberOfTerms];
        var temp = firstNum;
        array[0] = firstNum;
        for (int i = 1; i < numberOfTerms; i++) {
            array[i] = temp + valueBetweenNextNum;
            temp = array[i];
        }
        return array;
    }
}
