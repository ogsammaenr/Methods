public class Valid_Sudoku {
    public static void main(String[] args) {
        char[][] sudoku =
                {{'1','.','.','.','.','.','.','.','.'},
                        {'.','2','.','.','.','.','.','.','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'.','5','.','.','.','.','.','.','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'.','.','.','.','.','.','.','.','.'}};

        System.out.println(isValidSudoku(sudoku));
    }

    public static boolean isValidSudoku(char[][] board) {
        //satırlar kontrol edilir
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //eğer boş kare ise diğer kareye atlanır
                if (board[i][j] == '.') {
                    continue;
                }
                //seçilen kare ile satırdaki diğer kareler karşılaştırılır
                for (int k = 0; k < 9; k++) {
                    if (board[i][j] == board[i][k] && j != k) {
                        return false;
                    }
                }
            }
        }
        //sütünlar kontrol edilir
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //eğer boş kare ise diğer kareye atlanır
                if (board[j][i] == '.') {
                    continue;
                }
                //şeçilen kare ile sütündaki diğer kareler karşılaştırılır
                for (int k = 0; k < 9; k++) {
                    if(board[j][i] == board[k][i] && k != j ) {
                        return false;
                    }
                }
            }
        }
        char[][] piece;
        //kareler kontrol edilir
        for (int i = 0; i <= 6; i+= 3) {
            for (int j = 0; j <= 6; j+= 3) {

                piece = new char[3][3];
                for (int k = i; k < i+3; k ++) {
                    for (int l = j; l < j+3; l ++) {
                        piece[k-i][l-j] = board[k][l];
                    }
                }

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (piece[k][l] == '.') {
                            continue;
                        }

                        for (int m = 0; m < 3; m++) {
                            for (int n = 0; n < 3; n++) {
                                if (piece[k][l] == piece[m][n] && k != m && l != n ) {
                                    return false;
                                }
                            }
                        }

                    }
                }

            }
        }



        return true;
    }
}
