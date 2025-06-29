import java.util.*;

class Sudoku_Solver {
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
// Zaman ölçümü başlangıcı
        long startTime = System.nanoTime();

        SudokuSolver(sudoku);

        // Zaman ölçümü sonu
        long endTime = System.nanoTime();

        // Geçen süreyi yazdır
        long duration = endTime - startTime;
        System.out.println("Çözüm süresi: " + duration + " nanosecond.");
    }

    public static void SudokuSolver(char[][] board){
        List<int[]> emptyCells = new ArrayList<>();

        // Boş hücreleri topla
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    emptyCells.add(new int[]{i, j});
                }
            }
        }

        // Backtracking çözüm
        if (solve(board, emptyCells, 0)) {
            System.out.println("Çözüm bulundu:");
            printBoard(board);
        } else {
            System.out.println("Hiçbir çözüm bulunamadı.");
        }
    }

    public static boolean solve(char[][] board, List<int[]> emptyCells, int index) {
        if (index == emptyCells.size()) {
            return true; // Tüm boş hücreler dolduysa çözüm bulundu
        }

        int row = emptyCells.get(index)[0];
        int col = emptyCells.get(index)[1];

        for (char num = '1'; num <= '9'; num++) {
            if (isvalid(board, row, col, num)) {
                board[row][col] = num;
                if (solve(board, emptyCells, index + 1)) {
                    return true;
                }
                board[row][col] = '.'; // Geri al (backtrack)
            }
        }

        return false;
    }

    public static boolean isvalid(char[][] board, int row, int col, char num){
        for (int i = 0; i < 9; i++){
            if (board[row][i] == num || board[i][col] == num){
                return false;
            }
        }

        int rowi = 3*(row / 3);
        int coli = 3*(col / 3);

        for (int i = rowi; i < rowi + 3; i++){
            for (int j = coli; j < coli + 3; j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }

        return true;
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
                if((j + 1) % 3 == 0)
                    System.out.print(" ");
            }
            System.out.println();
            if ((i+1) % 3 == 0 && i != 0)
                System.out.println();
        }
    }
}
