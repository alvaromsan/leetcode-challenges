package org.maven;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "()[]{)";
        String t = "{[]}";
        String r = "{dd}";

        System.out.println("The string valid ?: " + (isValid(r)? "Yes":"No"));
    }

    public static boolean isValid(String s) {
        Stack<Character> values = new Stack<>();

        if(s.length()%2 != 0){
            return false;
        }

        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c=='['){
                values.push(complementaryValue(c));
            }
            else if (values.isEmpty() || values.pop() != c) {
                return false;
            }
        }
        return values.isEmpty();
    }

    public static char complementaryValue(char i) {

        return switch (i) {
            case '(' -> ')';
            case '{' -> '}';
            case '[' -> ']';
            default -> 'n';
        };
    }
}