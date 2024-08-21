package hexlet.code;

import java.util.Scanner;

public class Cli {
    static void welcome() {
        Scanner scanner = new Scanner(System.in);
        String userName = "";
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
    }
}
