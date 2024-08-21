package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;

import java.util.Scanner;

public class App {
    public static String userMenuChoice = "";
    public static void main(String[] args) {
        start();

    }
    public static void start() {
        showMenu();
        pickGame();
    }
    public static void showMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        userMenuChoice = new Scanner(System.in).nextLine();
        System.out.println();
    }
    public static void pickGame() {
        switch (userMenuChoice) {
            case "1" -> Engine.welcome();
            case "2" -> new Even();
            case "3" -> new Calc();
            case "0" -> System.exit(0);
            default -> System.out.println("Invalid choice");
        }
    }

    //Файл App.java предназначен
    // только для отображения игрового меню,
    // выбора и запуска нужной игры
}
