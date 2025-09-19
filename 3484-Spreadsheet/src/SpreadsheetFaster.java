import java.util.*;


// Faster runtime: 100 ms
// What if we added just the column-row set?
// - If the column-row doesn't exist, it means that it's 0
public class SpreadsheetFaster {
    Map<String, Integer> spreadSheetMap = new HashMap<>();

    public SpreadsheetFaster(int rows) {
    }

    public void setCell(String cell, int value) {
        spreadSheetMap.put(cell, value);
    }

    public void resetCell(String cell) {
        spreadSheetMap.remove(cell);
    }

    public int getValue(String formula) {
        int index = formula.indexOf('+');
        String left = formula.substring(1, index);
        String right = formula.substring(index + 1);
        int result = 0;


        if(left.charAt(0) > '9') {
            int val = spreadSheetMap.getOrDefault(left, 0);
            result += val;
        }
        else {
            // Number
            result += Integer.parseInt(left);
        }

        if(right.charAt(0) > '9') {
            int val = spreadSheetMap.getOrDefault(right, 0);
            result += val;
        }
        else {
            // Number
            result += Integer.parseInt(right);
        }
        return result;
    }
}