import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Iterator;


public class Board {

    private int[][] blocks;
    private int size;

    public Board(int[][] b) {
        this.size = b.length;
        blocks = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                blocks[i][j] = b[i][j];
            }
        }
    }

    public int dimension() {
        return blocks.length;
    }

    public int hamming() {
        int hamming = 0;
        int value = 1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == size - 1 && j == size - 1)
                    continue;
                if (blocks[i][j] != value++)
                    hamming = hamming + 1;
            }
        }
        return hamming;
    }

    public int manhattan() {
        int manhattan = 0;
        int value = 1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (blocks[i][j] != value++)
                    manhattan = manhattan + manhattanDiff(blocks[i][j], i, j);
            }
        }
        return manhattan;

    }

    private int manhattanDiff(int n, int i, int j) {
        // Which row and column the number should appear at
        if (n == 0)
            return 0;

        // Figure out what is the correct row and column for n
        int row = n / size;
        int column = (n % size);

        if (row == 0) {
            column = n - 1;
        } else if (column == 0) {
            row = row - 1;
            column = size - 1;
        } else {
            column = column - 1;
        }

        return Math.abs(row - i) + Math.abs(column - j);
    }

    public boolean isGoal() {
        int value = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == size - 1 && j == size - 1)
                    continue;
                if (blocks[i][j] != value++)
                    return false;
            }
        }
        return true;
    }

    public Board twin() {
        Board board = new Board(blocks);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (blocks[i][j] != 0 && blocks[i][j + 1] != 0) {
                    board.swap(board, i, j, i, j + 1);
                    return board;
                }
            }
        }
        return board;
    }

    public boolean equals(Object y) {
        if (y == this)
            return true;
        if (y == null)
            return false;
        if (y.getClass() != this.getClass())
            return false;
        Board that = (Board) y;
        if (that.size != this.size)
            return false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (this.blocks[i][j] != that.blocks[i][j])
                    return false;
            }
        }
        return true;
    }

    public Iterable<Board> neighbors() {
        int blankRow = -1, blankColumn = -1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (blocks[i][j] == 0) {
                    blankRow = i;
                    blankColumn = j;
                }
            }
        }
        ArrayList<Board> nextBoards = new ArrayList<>();
        if (blankRow == 0 && blankColumn == 0) {
            // If top left corner, 2 moves
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow, blankColumn + 1));
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow + 1, blankColumn));
        } else if (blankRow == 0 && blankColumn == size - 1) {
            // If top right corner, 2moves
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow, blankColumn - 1));
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow + 1, blankColumn));
        } else if (blankRow == size - 1 && blankColumn == size - 1) {
            // Bottom right corner, return 2 possibilities
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow, blankColumn - 1));
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow - 1, blankColumn));

        } else if (blankRow == size - 1 && blankColumn == 0) {
            // Bottom left corner, return 2 possibilities
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow, blankColumn + 1));
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow - 1, blankColumn));

        } else if (blankRow == 0) {
            // Top row but not corner, 3 moves
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow, blankColumn + 1));
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow, blankColumn - 1));
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow + 1, blankColumn));
        } else if (blankRow == size - 1) {
            // Bottom row, but not corner, 3 moves
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow, blankColumn + 1));
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow, blankColumn - 1));
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow - 1, blankColumn));
        } else if (blankColumn == 0) {
            // left column, but not corner, 3 moves
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow + 1, blankColumn));
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow - 1, blankColumn));
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow, blankColumn + 1));

        } else if (blankColumn == size - 1) {
            // right column, but not corner, 3 moves
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow + 1, blankColumn));
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow - 1, blankColumn));
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow, blankColumn - 1));
        } else {
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow + 1, blankColumn));
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow - 1, blankColumn));
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow, blankColumn - 1));
            nextBoards.add(swap(createCopyBoard(), blankRow,
                    blankColumn, blankRow, blankColumn + 1));
        }
        return nextBoards;
    }

    private Board swap(Board b, int row, int column, int newRow, int newColumn) {
        int tempValue = b.blocks[row][column];
        b.blocks[row][column] = b.blocks[newRow][newColumn];
        b.blocks[newRow][newColumn] = tempValue;
        return b;
    }

    private Board createCopyBoard() {
        int[][] clonedBlocks = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                clonedBlocks[i][j] = this.blocks[i][j];
            }
        }
        return new Board(clonedBlocks);
    }


    public String toString() {
        StringBuffer blocksStr = new StringBuffer();
        blocksStr.append(size + "\n");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (blocks[i][j] < 10)
                    blocksStr.append(" ");
                blocksStr.append(blocks[i][j]);
                if (j != blocks.length - 1)
                    blocksStr.append(" ");
            }
            blocksStr.append("\n");
        }
        return blocksStr.toString();
    }

    public static void main(String[] args) {

        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        int[][] blocks2 = new int[][]{
                {1, 0},
                {3, 2}
        };

        Board board = new Board(blocks);
        System.out.println(board);

        Iterator<Board> neighborsIt = board.neighbors().iterator();

        System.out.println("Neighbors");
        while (neighborsIt.hasNext()) {
            System.out.println(neighborsIt.next());
        }

    }

}
