package hexlet.code;

import java.util.Scanner;

public class App {
    public static String userMenuChoice = "";
    public static void main(String[] args) {
        showMenu();
        startGame();

    }
    public static void showMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        userMenuChoice = new Scanner(System.in).nextLine();
        System.out.println();
    }
    public static void startGame() {
        switch (userMenuChoice) {
            case "1" -> Engine.welcome();
            case "2" -> {
                Engine.welcome();
                new Even();
            }
            case "0" -> System.exit(0);
            default -> System.out.println("Invalid choice");
        }
    }

    //Файл App.java предназначен
    // только для отображения игрового меню,
    // выбора и запуска нужной игры
}
