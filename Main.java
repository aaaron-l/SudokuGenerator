import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String choice = "";
        while (true) {
            System.out.println("Choose a difficulty:\n" +
                                "Easy\n" +
                                "Medium\n" +
                                "Hard\n");

            choice = sc.nextLine().toLowerCase();

            if (choice.equals("easy") || choice.equals("medium") || choice.equals("hard")) break;
            else System.out.println("Choose a valid difficulty!");
            sc.nextLine();
        }

        int difficulty = 0;
        switch (choice) {
            case "easy":
                difficulty = 32;
                break;
            case "medium":
                difficulty = 43;
                break;
            case "hard": 
                difficulty = 52;
                break;
        }

        Game game = new Game(new SudokuGenerator(), difficulty);

        System.out.println("Enter 0 as a value to quit");
        outer: while (game.check()) {
            System.out.println(game);
            while (true) {
                System.out.println("\nEnter a row number");
                int row = sc.nextInt();

                System.out.println("\nEnter a column number");
                int col = sc.nextInt();
                
                
                System.out.println("\nEnter a number");
                int val = sc.nextInt();
                if (val == 0) break outer;

                // check
                if (row < 1 || row > 9 
                    || col < 1 || col > 9
                    || val < 1 || val > 9) {
    
                    System.out.println("\nEnter valid row numbers, column numbers, and values (1-9)");
                    continue;
                }


                if (game.input(val, row, col)) break;
            }
            System.out.println();
        } 
    }
}