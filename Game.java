import java.util.ArrayList;

public class Game {
    private final SudokuGenerator gen;
    private final int[][] board;
    private final ArrayList<Masked> masked = new ArrayList<>();


    public Game(SudokuGenerator gen, int difficulty) {
        this.gen = gen;
        board = gen.getBoard();
        mask(difficulty);
    }

    // masking
    public void mask(int difficulty) {
        int replaced = 0;

        while (replaced < difficulty) {
            int i = (int)(Math.random() * 9), j = (int)(Math.random() * 9);

            if (board[i][j] != 0) {
                masked.add(new Masked(i, j, board[i][j]));
                board[i][j] = 0;
                replaced++;
            }
        }
    }

    // input check
    public boolean input(int n, int row, int col) {
        Masked ref = new Masked(row-1, col-1, n);

        if (masked.contains(ref)) {
            if (masked.get(masked.indexOf(ref)).getVal() == n) {
                board[row-1][col-1] = n;
                masked.remove(ref);
                return true;
            } else System.out.println("Incorrect value! Try again");
            return false;
        } else System.out.println("You cannot change already correct values");
        return false;
    }

    // win condition
    public boolean check() {
        if (masked.isEmpty()) {
            System.out.println("You win!!!");
            System.out.println(toString());
            return false;
        }
        return true;
    }

    public String toString() {
        return gen.toString();
    }
}

