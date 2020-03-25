public class Knights {

    private int[][] board;
    final int NUM_ROWS = 8, NUM_COLS = 8;
    private int moveCounter = 1;

    private final int[] H_SHIFT = {2, 1, -1, -2, -2, -1, 1, 2};
    private final int[] V_SHIFT = {-1, -2, -2, -1, 1, 2, 2, 1};

    public Knights(int startRow, int startCol) {
        board = new int[NUM_ROWS][NUM_COLS];
        board[startRow][startCol] = moveCounter;
        moveCounter++;
    }

    public void printBoard() {
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                System.out.print("[" + board[row][col] + "] ");
            }
            System.out.println();
        }
    }
}
