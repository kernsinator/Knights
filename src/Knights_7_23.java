import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;


public class Knights_7_23 {

    private int[][] board; // 2D array represents chess board

    final int NUM_ROWS = 8, NUM_COLS = 8;
    private int moveCounter = 1;
    private int locRow, locCol;

    private Random random = new Random();
    private int[] tours = new int[65]; // array to keep track of frequency of tour lengths

    private int maxTourLength = 1;
    private int minTourLength = 64;
    private int totalTours = 1;
    private int completedTours;

    // horizontal and vertical shift arrays used to represent possible moves on board
    private final int[] H_SHIFT = {2, 1, -1, -2, -2, -1, 1, 2};
    private final int[] V_SHIFT = {-1, -2, -2, -1, 1, 2, 2, 1};

    public Knights_7_23(int startRow, int startCol) {
        // set current location to starting position
        locCol = startCol;
        locRow = startRow;

        board = new int[NUM_ROWS][NUM_COLS]; // create standard 8x8 board

        placePiece(locRow, locCol); // place starting piece
    }

    public void run() {

        System.out.println("Tour # " + totalTours);
        tour();

    }

    public void tour() {

        // loop executes until move cannot be made (tour ends)
        while (true) {
            if (!makeMove()) {
                break;
            }
        }
        printBoard(); // print final board for individual tour
        totalTours++;

    }

    public boolean makeMove() {
        boolean moveMade = false;
        //get all available moves
        ArrayList<Integer> moves = getAvailableMoves(locRow, locCol);

        //pick a move - random

        if (moves.size() > 0) {

            //choose random move from available moves
            int randomMove = random.nextInt((moves.size()));
            int move = moves.get(randomMove);

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

            tours[moveCounter]++; // add to frequency array
        }

        //if moves is empty return false
        return moveMade;
    }

    public ArrayList<Integer> getAvailableMoves(int row, int col) {
        ArrayList<Integer> moves = new ArrayList<>();

        for (int i = 0; i < H_SHIFT.length; i++) { // check each move out of all possible moves
            int rowOffset = V_SHIFT[i] + row;
            int colOffset = H_SHIFT[i] + col;
            if (validMove(rowOffset, colOffset)) {
                moves.add(i); // if move is valid, add to available moves
            }
        }
        return moves;
    }

    // if move is valid, place piece and increment move counter
    public boolean placePiece(int row, int col) {
        boolean piecePlaced = false;
        if (validMove(row, col)) {
            board[row][col] = moveCounter;
            if (moveCounter < 64) {
                moveCounter++;
            }
            piecePlaced = true;
        }
        return piecePlaced;
    }

    // check if move is within confines of the board and space has not already been used
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

    // reset variables that must be set prior to running tour
    public void resetTour(int row, int col) {
        moveCounter = 1;
        fillArray(board);
        placePiece(row, col);
        locRow = row;
        locCol = col;
    }

    // show frequency of tour lengths
    public void printTourTable() {
        int counter = 0;
        for (int element : tours) {
            System.out.println("Number of tours with " + counter + " moves: " + element);
            counter++;
        }
    }

    // fill array with 0s
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

    public int getTotalTours() {
        return totalTours;
    }
}
