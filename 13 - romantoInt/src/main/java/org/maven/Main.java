package org.maven;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String s = "MCMXCIV";

        System.out.println("The year of '" + s + "' is --> " + romanToInt(s));

    }

    public static int romanToInt(String s) {
        HashMap<String, Integer> romanValues = new HashMap<>();
        romanValues.put("I",1);
        romanValues.put("V", 5);
        romanValues.put("X", 10);
        romanValues.put("L", 50);
        romanValues.put("C", 100);
        romanValues.put("D", 500);
        romanValues.put("M", 1000);

        int result = 0;

        for(int i=0; i < s.length(); i++) {
            char currentValue = s.charAt(i);
            boolean sum = true;

            if (i != s.length()-1) {
                char nextValue = s.charAt(i+1);
                switch (currentValue) {
                    case 'I':
                        if (nextValue == 'V' || nextValue == 'X') sum = false;
                        break;
                    case 'X':
                        if (nextValue == 'L' || nextValue == 'C') sum = false;
                        break;
                    case 'C':
                        if (nextValue == 'D' || nextValue == 'M') sum = false;
                        break;
                }
            }
            int value = romanValues.get(String.valueOf(currentValue));
            result = result + (sum? +value: -value);
        }
        return result;
    }
}