public class Masked {
    private int row, col, val;

    public Masked(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }

// getters
    public int getRow() {return row;}
    public int getCol() {return col;}
    public int getVal() {return val;}

// @Override
    public boolean equals(Masked other) {
        if (other.getRow() == row && other.getCol() == col) return true;
        return false;
    }
}
