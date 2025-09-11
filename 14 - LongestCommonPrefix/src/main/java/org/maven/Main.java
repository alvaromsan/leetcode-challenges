package org.maven;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] strs = {"a","a","aabc","aa","acc"};

        System.out.println("The longest common prefix for the given Strings is: " + longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs) {

        // Take first sample
        int min_value_index = 0;
        int size = strs[0].length();
        StringBuilder result = new StringBuilder();

        for (int i=1; i < strs.length; i++) {
            if (strs[i].length() < size){
                min_value_index = i;
                size = strs[i].length();
            }
        }

        String sample = strs[min_value_index];

        if (size == 0) {
            return "";
        }

        for (int i=0; i < size; i++) {
            for(int j=0; j < strs.length; j++) {
                if (strs[j].charAt(i) != sample.charAt(i)) {
                    return result.toString();
                }
            }
            result.append(sample.charAt(i));
        }
        return result.toString();
    }

    public static String longestCommonPrefixSorted(String[] strs) {

        // We sort the arrays alphabetically
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length-1];
        StringBuilder result = new StringBuilder();

        for(int i=0; i < first.length(); i++) {
            if(first.charAt(i) != last.charAt(i)){
                break;
            }
            else {
                result.append(first.charAt(i));
            }
        }
        return result.toString();
    }
}