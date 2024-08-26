package hexlet.code.games;

import hexlet.code.Engine;

public final class Progression {

    private static final int RANGE_MIN = 5;
    private static final int RANGE_MAX = 10;
    private int firstNum = 0;
    private int valueBetweenNextNum = 0;
    private int numberOfTerms = 0;
    private int hiddenIndexInArray = 0;

    private int[] question;

    private boolean isLose = false; // stop while cycle when lose

    public Progression() {
        String rules = "What number is missing in the progression?";
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
        return String.valueOf(question[hiddenIndexInArray]);
    }

    public void askQuestion() {
        firstNum = Engine.generateNumber();
        valueBetweenNextNum = Engine.generateNumber();
        numberOfTerms = Engine.generateNumberInRange(RANGE_MIN, RANGE_MAX);
        hiddenIndexInArray = Engine.generateNumberInRange(0, numberOfTerms - 1);
        question = generateProgression();
        System.out.print("Question: ");
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
