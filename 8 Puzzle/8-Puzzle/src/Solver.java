import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class Solver {

    private SearchNode solve;
    private int size;

    private static class SearchNode implements Comparable<SearchNode> {
        Board board;
        int manh, priority;
        int moves = 0;
        SearchNode prevnode;

        public SearchNode(Board input, SearchNode prevnode) {
            if (input == null) {
                throw new IllegalArgumentException("Input is Invalid/Empty.");
            }
            this.board = input;
            this.manh = board.manhattan();
            if (prevnode != null) {
                this.moves = prevnode.moves + 1;
                this.prevnode = prevnode;
            }
            this.priority = this.moves + this.manh;
        }

        public int compareTo(SearchNode input) {
            if (this.priority < input.priority) {
                return -1;
            } else if (this.priority > input.priority) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException("The argument cannot be null.");
        }
        if (!initial.isSolvable()) {
            throw new IllegalArgumentException("The initial board is unsolvable.");
        }
        size = initial.size();
        MinPQ<SearchNode> priorityQ = new MinPQ<>();

        solve = new SearchNode(initial, null);

        priorityQ.insert(solve);

        while (!solve.board.isGoal()) {
            solve = priorityQ.delMin();
            for (Board temp : solve.board.neighbors()) {
                if (solve.prevnode == null || !temp.equals(solve.prevnode.board)) {
                    priorityQ.insert(new SearchNode(temp, solve));
                }
            }
        }
    }

    // min number of moves to solve initial board
    public int moves() {
        return solve.moves;
    }

    // sequence of boards in a shortest solution
    public Iterable<Board> solution() {
        SearchNode temp2 = solve;
        Stack<Board> dq = new Stack<Board>();
        Stack<Board> output = new Stack<Board>();
        while (temp2 != null) {
            dq.push(temp2.board);
            temp2 = temp2.prevnode;
        }
        while (!dq.isEmpty()) {
            Board temp = dq.pop();
            output.push(temp);
        }
        return output;
    }

    // test client (see below)
    public static void main(String[] args) {
        int[][] test = {{5, 1, 8}, {2, 7, 3}, {4, 0, 6}};
        Board Bo = new Board(test);
        Solver solved = new Solver(Bo);
        int moves = solved.moves();
        StdOut.println("Minimum Number of Moves is " + moves);
        for (Board board : solved.solution()) {
            StdOut.println(board);
        }
    }
}
