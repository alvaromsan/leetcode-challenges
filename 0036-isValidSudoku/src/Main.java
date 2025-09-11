import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Main {
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

        System.out.println("Is the board valid? " + isValidSudoku(board));
    }

    // Determine if a 9 x 9 Sudoku board is valid (as it is, not if it's solvable).
    // Only the filled cells need to be validated according to the following rules:
    // 1) Each row must contain the digits 1-9 without repetition.
    // 2) Each column must contain the digits 1-9 without repetition.
    // 3) Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
    public static boolean isValidSudoku(char[][] board) {
        List<TreeSet<Integer>> grid_3x3 = new ArrayList<>(
                Arrays.asList(new TreeSet<>(), new TreeSet<>(), new TreeSet<>())
        );
        TreeSet<Integer> row = new TreeSet<>();
        TreeSet<Integer> column = new TreeSet<>();
        for(int i=0; i<board.length;i++){
            row.clear();
            column.clear();

            // We will clear the 3x3 grid when the row is over 3, 6, 9, etc.
            if (i%3 == 0 && i != 0) {
                for (int x = 0; x < 3; x++) {
                    grid_3x3.get(x).clear();
                }
            }
            for(int j=0, array_index=0; j<board.length;j++) {
                // Increase the array_index when we get to the next 3x3 grid (in columns)
                if(j % 3 == 0 && j != 0) {
                    array_index++;
                }
                // Check the 3x3 and the row
                if(board[i][j] != '.') {
                    int row_value = Character.getNumericValue(board[i][j]);
                    if (!grid_3x3.get(array_index).add(row_value)) return false;
                    if (!row.add(row_value)) return false;
                }

                // Check the column
                if(board[j][i] != '.') {
                    int column_value = Character.getNumericValue(board[j][i]);
                    if (!column.add(column_value)) return false;
                }
            }
        }
        return true;
    }
}