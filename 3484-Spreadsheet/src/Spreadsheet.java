import java.util.*;


// Slower runtime: 116 ms
// We are using a map for all columns-row
// But what if we added just the column-row set?
// - If the column-row doesn't exist, it means that it's 0
public class Spreadsheet {
    Map<String, int[]> spreadSheetMap = new HashMap<>();

    public Spreadsheet(int rows) {
        // 26 letters from 'A' to 'Z'
        for (int i=0; i<26; i++) {
            spreadSheetMap.put(String.valueOf((char)('A' + i)), new int[rows]);
        }
    }

    public void setCell(String cell, int value) {
        String letter = String.valueOf(cell.charAt(0));
        int rowN = Integer.parseInt(cell.substring(1));

        int[] rows = spreadSheetMap.get(letter);
        rows[rowN-1] = value;
        spreadSheetMap.put(letter, rows);
    }

    public void resetCell(String cell) {
        String letter = String.valueOf(cell.charAt(0));
        int rowN = Integer.parseInt(cell.substring(1));

        int[] rows = spreadSheetMap.get(letter);
        rows[rowN-1] = 0;
        spreadSheetMap.put(letter, rows);
    }

    public int getValue(String formula) {
        int index = formula.indexOf('+');
        String left = formula.substring(1, index);
        String right = formula.substring(index + 1);
        int result = 0;


        if(left.charAt(0) > '9') {
            String letter = String.valueOf(left.charAt(0));
            int rowN = Integer.parseInt(left.substring(1));

            int[] rows = spreadSheetMap.get(letter);
            result += rows[rowN-1];
        }
        else {
            // Number
            result += Integer.parseInt(left);
        }

        if(right.charAt(0) > '9') {
            String letter = String.valueOf(right.charAt(0));
            int rowN = Integer.parseInt(right.substring(1));

            int[] rows = spreadSheetMap.get(letter);
            result += rows[rowN-1];
        }
        else {
            // Number
            result += Integer.parseInt(right);
        }
        return result;
    }
}