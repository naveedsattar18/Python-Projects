import java.util.ArrayList;
import java.util.List;

public class Board {

    private int n;
    private int row = -1;
    private int col = -1;
    private int[][] board;
    private int hamming;
    private int manhattan;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        n = tiles[0].length;
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = tiles[i][j];
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                }
            }
        }
        // Calculates the Hamming distance
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0 && board[i][j] != (n * i + j + 1)) {
                    count++;
                }
            }
        }
        hamming = count;


        // Calculates the Manhattan Distance
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0 && board[i][j] != (n * i + j + 1)) {
                    int diff = Math.abs(((tileAt(i, j) - 1) / n) - i) + Math.abs(((tileAt(i, j) - 1) % n) - j);
                    sum += diff;
                }
            }
        }
        manhattan = sum;

    }

    // string representation of this board
    public String toString() {
        StringBuilder output = new StringBuilder(4 * n * n);
        output.append(n).append("\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                output.append(String.format("%2d ", tileAt(i, j)));
            }
            output.append("\n");
        }
        return output.toString();
    }

    // tile at (row, col) or 0 if blank
    public int tileAt(int row, int col) {
        if (row > n - 1 || row < 0 || col > n - 1 || col < 0) {
            throw new IllegalArgumentException("Row or Col Value Out of Bounds.");
        }
        return board[row][col];
    }

    // board size n
    public int size() {
        return n;
    }

    // number of tiles out of place
    public int hamming() {
        if (isGoal()) {
            return 0;
        } else {
            return hamming;
        }
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        return manhattan;
    }

    // is this board the goal board?
    public boolean isGoal() {
        if (isSolvable()) {
            return manhattan() == 0;
        } else return false;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == null || y.getClass() != this.getClass()) {
            return false;
        }
        if (y == this) {
            return true;
        }

        Board work = (Board) y;
        if (work.size() == this.size()) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (work.board[i][j] != this.board[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    // all neighboring boards
    // row < n && row >= 0 && column >= 0 && column < n;
    public Iterable<Board> neighbors() {
        List<Board> neighb = new ArrayList<>();

        // Initially we must store the values in the input board onto a temporary board
        int[][] temp1 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp1[i][j] = board[i][j];
            }
        }
        // Now we begin adding the neighbors to the List.
        if (row + 1 < n && row + 1 >= 0 && col >= 0 && col < n) {
            neighb.add(swap(temp1, row, col, row + 1, col));
        }
        if (row - 1 < n && row - 1 >= 0 && col >= 0 && col < n) {
            neighb.add(swap(temp1, row - 1, col, row, col));
        }
        if (row < n && row >= 0 && col + 1 >= 0 && col + 1 < n) {
            neighb.add(swap(temp1, row, col + 1, row, col));
        }
        if (row < n && row >= 0 && col - 1 >= 0 && col - 1 < n) {
            neighb.add(swap(temp1, row, col - 1, row, col));
        }
        return neighb;
    }

    // is this board solvable?
    public boolean isSolvable() {
        int inversions = 0;

        for (int i = 0; i < n * n; i++) {
            int currow = i / this.size();
            int curcol = i % this.size();
            if (tileAt(currow, curcol) == 0) {
                this.row = currow;
                this.col = curcol;
            }

            for (int k = i; k < n * n; k++) {
                int currow2 = k / this.size();
                int curcol2 = k % this.size();

                if (tileAt(currow2, curcol2) != 0 && tileAt(currow2, curcol2) < tileAt(currow, curcol)) {
                    inversions += 1;
                }
            }
        }
        // If the size of the board is odd and number of inversions is odd, not solvable.
        if (board.length % 2 != 0 && inversions % 2 != 0) {
            return false;
        }
        // If the size of the board is even and inversions + row of blank tile is even, not solvable.
        if (board.length % 2 == 0 && (inversions + this.row) % 2 == 0) {
            return false;
        }
        return true;
    }

    private Board swap(int[][] temp1, int input1row, int input1col, int input2row, int input2col) {

        // now we use the temporary board to swap elements
        int temp2 = temp1[input1row][input1col];
        temp1[input1row][input1col] = temp1[input2row][input2col];
        temp1[input2row][input2col] = temp2;
        Board output = new Board(temp1);
        temp1[input2row][input2col] = temp1[input1row][input1col];
        temp1[input1row][input1col] = temp2;
        return output;
    }


    // unit testing (required)
    public static void main(String[] args) {
        int[][] test = {{0, 1, 3}, {4, 2, 5}, {7, 8, 6}};
        Board Bo = new Board(test);
        String teststr = Bo.toString();
        System.out.println("Hamming Distance " + Bo.hamming());
        System.out.println("Manhattan Distance " + Bo.manhattan());
        System.out.println(teststr);
        System.out.println(Bo);
        for (Board b1 : Bo.neighbors()) {
            System.out.println(b1);
        }
        // Write tests for every method
        //
    }
}
