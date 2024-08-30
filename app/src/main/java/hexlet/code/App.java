package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    private static String userMenuChoice = "";

    public static void main(String[] args) {
        startApp();
    }

    public static void startApp() {
        showMenu();
        pickGame();
    }
    public static void showMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        userMenuChoice = new Scanner(System.in).nextLine();
        System.out.println();
    }
    public static void pickGame() {
        switch (userMenuChoice) {
            case "1" -> Engine.welcome();
            case "2" -> Even.play();
            case "3" -> Calc.play();
            case "4" -> Gcd.play();
            case "5" -> Progression.play();
            case "6" -> Prime.play();
            case "0" -> System.exit(0);
            default -> System.out.println("Invalid choice");
        }
    }
}
