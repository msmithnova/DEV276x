import java.util.*;

public class MazeRunner {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Maze myMap = new Maze();
        intro(myMap);
        int numMoves = 0;
        while (!myMap.didIWin() && numMoves < 100) {
            myMap.printMap();
            printSeparator();
            String direction = userMove(input);
            numMoves += 1;
            boolean validMove = checkMove(input, myMap, direction);
            if (validMove) moveUser(myMap, direction);
            movesMessage(input, numMoves);
        }
        if (numMoves == 100) {
            System.out.println("Sorry, but you didn't escape in time - you lose!");
        } else {
            System.out.println("Congratulations, you made it out alive!");
            System.out.println("and you did it in " + numMoves + " moves");
        }
        input.close();
    }

    private static void intro(Maze myMap) {
        System.out.println("Welcome toMaze Runner!");
        System.out.println("Here is your current position:");
    }

    private static String userMove(Scanner input) {
        String result = "";
        String[] options = {"R", "L", "U", "D"};
        while (!Arrays.asList(options).contains(result)) {
            System.out.print("Where would you like to move? (R, L, U, D): ");
            result = input.next().toUpperCase();
        }
        return result;
    }

    private static boolean checkMove(Scanner input, Maze myMap, String direction) {
        boolean validMove;
        if (direction.equals("R")) validMove = myMap.canIMoveRight();
        else if (direction.equals("L")) validMove = myMap.canIMoveLeft();
        else if (direction.equals("U")) validMove = myMap.canIMoveUp();
        else validMove = myMap.canIMoveDown();
        if (!validMove && myMap.isThereAPit(direction)) {
            navigatePit(input, myMap, direction);
        } else if (!validMove) {
            System.out.println("Sorry, you've hit a wall.");
        }
        return validMove;
    }

    private static void moveUser(Maze myMap, String direction) {
        if (direction.equals("R")) myMap.moveRight();
        else if (direction.equals("L")) myMap.moveLeft();
        else if (direction.equals("U")) myMap.moveUp();
        else myMap.moveDown();
    }

    private static void movesMessage(Scanner input, int numMoves) {
         if (numMoves == 50) {
             System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
         } else if (numMoves == 75) {
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
         } else if (numMoves == 90) {
             System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
         } else if (numMoves == 100) {
             System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
         }
    }

    private static void navigatePit(Scanner input, Maze myMap, String direction) {
        System.out.print("Watch out! There's a pit ahead, jump it? (y/n): ");
        String result = input.next().toUpperCase();
        if (result.startsWith("Y")) myMap.jumpOverPit(direction);
    }

    private static void printSeparator() {
        System.out.println("----------------------------------");
    }

}
