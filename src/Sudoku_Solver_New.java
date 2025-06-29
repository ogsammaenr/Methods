public class Sudoku_Solver_New {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        if (solveSudoku(board)) {
            System.out.println("Sudoku çözüldü:");
            printBoard(board);
        } else {
            System.out.println("Çözüm bulunamadı.");
        }
    }

    public static boolean solveSudoku(char[][] board) {
        // Herhangi bir boş hücre bulalım
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] != '.') {
                    continue;
                }
                // Bu hücreye bir değer yerleştirmek için deneme yapalım
                for (char num = '1'; num <= '9'; num++) {
                    if (isValid(board, row, col, num)) {
                        board[row][col] = num; // Geçerli numarayı yerleştir

                        if (solveSudoku(board)) {
                            return true; // Çözüm bulunduysa true döndürelim
                        }
                        board[row][col] = '.'; // Geri dön ve farklı bir sayıyı dene
                    }
                }
                return false; // Hiçbir sayı geçerli değilse false döner

            }
        }
        return true; // Tüm hücreler dolmuşsa çözüm bulundu
    }

    public static boolean isValid(char[][] board, int row, int col, char num) {
        // Aynı satırda aynı numara varsa geçerli değil
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
            if (board[i][col] == num) {
                return false;
            }
        }
        // 3x3 kutu kontrolü
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true; // Hiçbir çakışma yoksa geçerli
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
                if ((j + 1) % 3 == 0)
                    System.out.print(" ");
            }
            if ((i + 1) % 3 == 0 && i != 0)
                System.out.println();
            System.out.println();
        }
    }


}
