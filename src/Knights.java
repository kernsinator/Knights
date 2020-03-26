import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Knights {

    private int[][] board;
    private int[][] accessibility;

    final int NUM_ROWS = 8, NUM_COLS = 8;
    private int moveCounter = 1;
    private int locRow, locCol;

    private int maxTourLength;
    private int minTourLength;
    private int totalTours;
    private int completedTours;

    private final int[] H_SHIFT = {2, 1, -1, -2, -2, -1, 1, 2};
    private final int[] V_SHIFT = {-1, -2, -2, -1, 1, 2, 2, 1};

    public Knights(int startRow, int startCol) {
        locCol = startCol;
        locRow = startRow;

        board = new int[NUM_ROWS][NUM_COLS];
        accessibility = new int[NUM_ROWS][NUM_COLS];

        placePiece(locRow, locCol);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many tours would you like to run?");
        int numberOfTours = scanner.nextInt();

        for (int i = 0; i < numberOfTours; i++) {
            tour();
        }
        System.out.println("Tour # " + totalTours);
    }

    public void tour() {

        while (true) {
            if(!makeMove()) {
                break;
            }
            printBoard();
        }
        totalTours++;

    }

    public boolean makeMove() {
        boolean moveMade = false;
        //get all available moves
        ArrayList<Integer> moves = getAvailableMoves(locRow, locCol);

        //pick a move - first available
        if (moves.size() > 0) {
            int move = moves.get(0);

            //place piece
            moveMade = placePiece(locRow + V_SHIFT[move], locCol + H_SHIFT[move]);

            // update current position
            locRow = locRow + V_SHIFT[move];
            locCol = locCol + H_SHIFT[move];

        } else {

            if (moveCounter == 64) {
                incrementCompletedTours();
            }

            if (moveCounter > maxTourLength) {
                maxTourLength = moveCounter;
            }

            if (moveCounter < minTourLength) {
                minTourLength = moveCounter;
            }
        }

        //update board
        //printBoard();

        //if moves is empty return false
        return moveMade;
    }

    public ArrayList<Integer> getAvailableMoves(int row, int col) {
        ArrayList<Integer> moves = new ArrayList<>();

        for (int i = 0; i < H_SHIFT.length; i++) {
            int rowOffset = V_SHIFT[i] + row;
            int colOffset = H_SHIFT[i] + col;
            if (validMove(rowOffset, colOffset)) {
                moves.add(i);
            }
        }
        return moves;
    }

    public void setAccessibility() {

        fillArray(accessibility);

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {

                int counter = 0;
                for (int move: getAvailableMoves(row, col)) {
                    counter++;
                }
                accessibility[row][col] = counter;
            }
        }
    }

    public void printAccessibility() {
        for (int[] row : accessibility) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    public boolean placePiece(int row, int col) {
        boolean piecePlaced = false;
        if (validMove(row, col)) {
            board[row][col] = moveCounter;
            moveCounter++;
            piecePlaced = true;
        }
        return piecePlaced;
    }

    public boolean validMove(int row, int col) {
        boolean validTop = row >= 0;
        boolean validBottom = row < board.length;
        boolean validLeft = col >= 0;

        return validTop && validBottom && validLeft && col < board[row].length && board[row][col] < 1;
    }

    public void printBoard() {
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    public void resetTour(int row, int col) {
        moveCounter = 1;
        fillArray(board);
        placePiece(row, col);
        locRow = row;
        locCol = col;
    }

    public void fillArray(int[][] array) {

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                array[row][col] = 0;
            }
        }
    }

    public void incrementCompletedTours() {
        completedTours++;
    }

    public int getMoveCounter() {
        return moveCounter;
    }

    public void setMoveCounter(int moveCounter) {
        this.moveCounter = moveCounter;
    }

    public int getLocRow() {
        return locRow;
    }

    public void setLocRow(int locRow) {
        this.locRow = locRow;
    }

    public int getLocCol() {
        return locCol;
    }

    public void setLocCol(int locCol) {
        this.locCol = locCol;
    }

    public int getMaxTourLength() {
        return maxTourLength;
    }

    public void setMaxTourLength(int maxTourLength) {
        this.maxTourLength = maxTourLength;
    }

    public int getMinTourLength() {
        return minTourLength;
    }

    public void setMinTourLength(int minTourLength) {
        this.minTourLength = minTourLength;
    }

    public int getCompletedTours() {
        return completedTours;
    }

    public void setCompletedTours(int completedTours) {
        this.completedTours = completedTours;
    }
}
