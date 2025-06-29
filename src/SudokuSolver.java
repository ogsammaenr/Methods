public class SudokuSolver {
    public static void main(String[] args) {

        char[][] sudoku =
                {{'5','3','.', '.','7','.' ,'.','.','.'},
                        {'6','.','.', '1','9','5', '.','.','.'},
                        {'.','9','8', '.','.','.', '.','6','.'},

                        {'8','.','.', '.','6','.', '.','.','3'},
                        {'4','.','.', '8','.','3', '.','.','1'},
                        {'7','.','.', '.','2','.', '.','.','6'},

                        {'.','6','.', '.','.','.', '2','8','.'},
                        {'.','.','.', '4','1','9', '.','.','5'},
                        {'.','.','.', '.','8','.', '.','7','9'}};
        solveSudoku(sudoku);
        System.out.println("cozuldu");
        printBoard(sudoku);

    }

    public static boolean solveSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    continue;
                }
                for (char i = '1'; i <= '9'; i++) {
                    if (isvalid(board, row, col, i)) {
                        board[row][col] = i;
                        printBoard(board);
                        System.out.println("**********************");
                        if (solveSudoku(board))
                            return true;

                        board[row][col] = '.';
                    }
                }
                return false;
            }
        }

        return true;
    }
    /**************************************************************************************************************/
    public static boolean isvalid(char[][] board, int row, int col, char num){
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num)
                return false;
            if (board[i][col] == num)
                return false;
        }
        int rowi = 3*(row / 3);
        int coli = 3*(col / 3);

        for (int i = rowi; i < rowi + 3; i++) {
            for (int j = coli; j < coli +3; j++) {
                if(board[i][j] == num)
                    return false;
            }
        }
        return true;
    }
    /**************************************************************************************************************/
    public static boolean isSolved(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.')
                    return false;
            }
        }
        return true;
    }
    /**************************************************************************************************************/
    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
                if((j + 1) % 3 == 0)
                    System.out.print(" ");
            }
            if ((i+1) % 3 == 0 && i != 0)
                System.out.println();
            System.out.println();
        }
    }
}