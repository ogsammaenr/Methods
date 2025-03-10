import java.util.Arrays;

public class Sudoku_Solver {
    public static void main(String[] args) {

        char[][] sudoku =
                {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        sudokuSolver(sudoku);
    }

    public static void sudokuSolver(char[][] board) {
        //int[][][] probabilities = new int[9][9][9];

        boolean[][][] probabilities = new boolean[9][9][9];

        int row = 0;
        int col = 0;

        int first_row = 0;
        int first_col = 0;
        int first_block_control = 0;

        for (int repeat = 0 ; ; repeat++) {
            int control = repeat;

            char[][] sudoku = new char[9][];

            for (int n = 0; n < 9; n++) {
                sudoku[n] = new char[9];
                System.arraycopy(board[n], 0, sudoku[n], 0, 9);
            }

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {

                    if (sudoku[i][j] != '.') {
                        continue;
                    }
                    else if (first_block_control == 0){
                        first_col = i;
                        first_row = j;
                        first_block_control = 1;
                    }

                    for (int k = 0; k < 9; k++) {
                        if (sudoku[i][k] != '.') {
                            probabilities[i][j][sudoku[i][k] - '0' - 1] = true;

                        }
                        if (sudoku[k][j] != '.') {
                            probabilities[i][j][sudoku[k][j] - '0' - 1] = true;
                        }
                    }

                    if (j % 3 == 0)
                        row = j;
                    if (i % 3 == 0)
                        col = i;

                    for (int k = col; k < col + 3; k++) {
                        for (int l = row; l < row + 3; l++) {
                            if (sudoku[k][l] != '.')
                                probabilities[i][j][sudoku[k][l] - '0' - 1] = true;

                        }
                    }

                    for (int k = 0; k < 9; k++) {
                        if (!probabilities[i][j][k]) {
                            if (control > 0) {
                                System.out.println(control--);
                                continue;
                            }

                            sudoku[i][j] = (char) (k + 1 + '0');
                            break;
                        }
                    }

                }
                row = 0;
                col = 0;
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            if (isValidSudoku(sudoku)) {
                System.out.println("Valid Sudoku");
                break;
            }
        }




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
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    return false;
                }
            }
        }



        return true;
    }


}
