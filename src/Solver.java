import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;


/**
 * Created by sunilpatil on 9/30/16.
 */
public class Solver {

    private int moves;
    private boolean isSolvable;
    private final Stack<Board> boards;

    public Solver(Board initial) {
        if (initial == null)
            throw new NullPointerException();
        boards = new Stack<Board>();
        if (initial.isGoal()) {
            isSolvable = true;
            this.boards.push(initial);
            return;
        }
        if (initial.twin().isGoal()) {
            isSolvable = false;
            return;
        }
        MinPQ<BoardComparator> minPQ = new MinPQ<BoardComparator>();
        MinPQ<BoardComparator> minPQTwin = new MinPQ<BoardComparator>();
        moves = 0;
        Board board = initial;
        Board boardTwin = initial.twin();
        BoardComparator node = new BoardComparator(board, 0, null);
        BoardComparator nodeTwin = new BoardComparator(boardTwin, 0, null);
        minPQ.insert(node);
        minPQTwin.insert(nodeTwin);
        while (moves < 100) {
            node = minPQ.delMin();
            nodeTwin = minPQTwin.delMin();
            board = node.board;
            boardTwin = nodeTwin.board;
            if (boardTwin.isGoal()) {
                isSolvable = false;
                return;
            }
            if (board.isGoal()) {
                isSolvable = true;
                this.boards.push(board);
                while (node.previous != null) {
                    node = node.previous;
                    this.boards.push(node.board);
                }
                return;
            }
            node.moves++;
            nodeTwin.moves++;
            Iterable<Board> neighbors = board.neighbors();
            for (Board neighbor : neighbors) {
                if (node.previous != null
                        && neighbor.equals(node.previous.board)) {
                    continue;
                }
                BoardComparator newNode = new BoardComparator(neighbor, node.moves, node);
                minPQ.insert(newNode);
            }
            Iterable<Board> neighborsTwin = boardTwin.neighbors();
            for (Board neighbor : neighborsTwin) {
                if (nodeTwin.previous != null
                        && neighbor.equals(nodeTwin.previous.board)) {
                    continue;
                }
                BoardComparator newNode = new BoardComparator(neighbor, nodeTwin.moves,
                        nodeTwin);
                minPQTwin.insert(newNode);
            }
        }

    }

    public boolean isSolvable() {
        return isSolvable;
    }

    public int moves() {
        if (isSolvable)
            return boards.size() - 1;
        else
            return -1;
    }

    public Iterable<Board> solution() {
        if (isSolvable) {
            return boards;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

    private class BoardComparator implements Comparable<BoardComparator> {
        private Board board;
        private BoardComparator previous;
        private int moves;
        private int cachedPriority = -1;


         BoardComparator(Board board, int moves, BoardComparator previous) {
            this.board = board;
            this.moves = moves;
            this.previous = previous;
        }

        private int priority() {
            if (cachedPriority == -1) {
                cachedPriority = moves + board.manhattan();
            }
            return cachedPriority;
        }


        @Override
        public int compareTo(BoardComparator that) {
            if (this.priority() < that.priority()) {
                return -1;
            }
            if (this.priority() > that.priority()) {
                return +1;
            }
            return 0;

        }
    }
}
