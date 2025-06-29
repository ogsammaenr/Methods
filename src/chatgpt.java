public class chatgpt {
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

        solveSudoku(sudoku);

        // Zaman ölçümü sonu
        long endTime = System.nanoTime();

        // Geçen süreyi yazdır
        long duration = endTime - startTime;
        System.out.println("Çözüm süresi: " + duration + " nanosecond.");
    }
    public static boolean solveSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Boş bir hücre bul
                if (board[row][col] == '.') {
                    // 1-9 arası sayıları dene
                    for (char num = '1'; num <= '9'; num++) {
                        // Geçerli mi diye kontrol et
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;  // Sayıyı yerleştir

                            // Sudoku'yu çözmeye devam et
                            if (solveSudoku(board)) {
                                return true;  // Çözüm bulundu
                            }

                            // Çözüm bulunamadıysa geri adım at
                            board[row][col] = '.';  // Boşalt
                        }
                    }
                    return false;  // Eğer bu hücreye yerleştirilebilecek geçerli bir sayı yoksa
                }
            }
        }
        return true;  // Tüm hücreler doldurulmuşsa çözüm bulundu
    }

    public static boolean isValid(char[][] board, int row, int col, char num) {
        // Aynı satırda num var mı?
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Aynı sütunda num var mı?
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Aynı 3x3 kutuda num var mı?
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
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
            if ((i+1) % 3 == 0 && i != 0)
                System.out.println();
            System.out.println();
        }
    }
}