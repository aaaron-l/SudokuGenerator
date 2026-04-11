import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Choose a difficulty:\n" +
                            "Easy\n" +
                            "Medium\n" +
                            "Hard\n");

        String choice = sc.nextLine();
        System.out.print(choice);        

        //Game game = new Game(new SudokuGenerator());
    }
}