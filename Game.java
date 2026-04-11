import java.util.ArrayList;

public class Game {
    SudokuGenerator gen;
    int[][] board;
    ArrayList<Masked> masked;


    public Game(SudokuGenerator gen, int difficulty) {
        gen = this.gen;
        board = gen.getBoard();
        mask(difficulty);
    }

    public void mask(int difficulty) {
        int replaced = 0;

        while (replaced < difficulty) {
            int i = (int)(Math.random() * 9) + 1, j = (int)(Math.random() * 9) + 1;

            if (board[i][j] != 0) {
                masked.add(new Masked(i, j, board[i][j]));
                board[i][j] = 0;
                replaced++;
            }
        }
    }

    public void input(int n, int row, int col) {
        Masked ref = new Masked(row, col, n);
        if (masked.contains(ref)) {
            if (masked.get(masked.indexOf(ref)).getVal() == n) {
                board[row][col] = n;
                masked.remove(ref);
            } else System.out.println("Incorrect value! Try again");
        } else System.out.println("You cannot change already correct values");
    }

    public boolean check() {
        if (masked.isEmpty()) {
            return false;
        }
        return true;
    }

    public String toString() {
        return gen.toString();
    }
}

