public class SudokuGenerator {
    protected static int[][] board = new int[9][9];

    public SudokuGenerator() {
        generate(0, 0);
    }

    // generates the board
    public static boolean generate(int i, int j) {
        if (i == 9) return true;

        int nextRow = i;
        int nextCol = j+1;

        if (j == 8) {
            nextRow = i+1;
            nextCol = 0;
        }

        int n = (int)(Math.random()*9);

        for (int k = 0; k < 9; k++) {
            board[i][j] = (n + k) % 9 + 1;
            if (!check(board[i][j], i, j)) {
                if (generate(nextRow, nextCol)) return true;
            }
        }

        board[i][j] = 0;
        return false;
    }

    // checks for validity
    public static boolean check(int n, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (i != col && board[row][i] == n) return true;
            if (i != row && board[i][col] == n) return true;
        }
        return checkBox(n, row, col);
    }

    public static boolean checkBox(int n, int row, int col) {
        int sectionRow = row/3 * 3, sectionCol = col/3 * 3;
        
        for (int i = sectionRow; i < sectionRow + 3; i++) {
            for (int j = sectionCol; j < sectionCol + 3; j++) {
                if (i == row && j == col) continue;
                if (board[i][j] == n) return true;
            }
        }

        return false;
    }

    public int[][] getBoard() {
        return board;
    }

    public String toString() {
        String result = "";

        for (int i = 0; i < 9; i++) {
            if (i%3 == 0) result += "+-------+-------+-------+\n";
            for (int j = 0; j < 9; j++) {
                if (j%3 == 0) result += "| ";
                result += board[i][j] + " ";
            }
            result += "|\n";
        }


        return result + "+-------+-------+-------+";
    }
}