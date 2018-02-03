import java.util.*;

public class OddsAndEvens {
    private static String name = "";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String playAgain = "y";
        while (playAgain.startsWith("y")) {
            String choice = greetingAndChoice(input);
            playGame(input, choice);
            System.out.print("Play again? (Y/N) ");
            playAgain = input.next().toLowerCase();
            printSeparator();
            System.out.println("");
        }
        input.close();
    }

    private static String greetingAndChoice(Scanner input) {
        System.out.println("Let's play a game called \"Odds and Evens\"");
        if (name.equals("")) {
            System.out.print("What is your name? ");
            name = input.nextLine();
        }
        String choice = "";
        while (!choice.equals("O") && !choice.equals("E")) {
            System.out.print("Hi " + name + ", which do you choose? (O)dds or (E)vens? ");
            choice = input.next().toUpperCase();
            System.out.println("");
        }
        if (choice.equals("O")) {
            System.out.println(name + " has chosen odds! The computer will be evens.");
        } else {
            System.out.println(name + " has chosen evens! The computer will be odds.");
        }
        printSeparator();
        return choice;
    }

    private static void playGame(Scanner input, String oddOrEven) {
        String choice = "";
        while (!choice.matches("[0-5]")) {
            System.out.print("How many \"fingers\" do you put out? (0 to 5) ");
            choice = input.next();
        }
        Random rand = new Random();
        int computerNum = rand.nextInt(6);
        System.out.println("The computer plays " + computerNum + " \"fingers\"");
        printSeparator();
        int sum = Integer.parseInt(choice) + computerNum;
        System.out.println("User: " + choice + " + Computer: " + computerNum + " = " + sum);
        boolean isEven = sum % 2 == 0;
        if (isEven) {
            System.out.println("The result is Even!");
            if (oddOrEven.equals("E")) System.out.println("That means " + name + " wins! :)");
            else System.out.println("That means the computer wins! :(");
        }
        else {
            System.out.println("The result is Odd!");
            if (oddOrEven.equals("O")) System.out.println("That means " + name + " wins! :)");
            else System.out.println("That means the computer wins! :(");
        }
        printSeparator();
    }

    private static void printSeparator() {
        System.out.println("-------------------------------------");
    }

}
