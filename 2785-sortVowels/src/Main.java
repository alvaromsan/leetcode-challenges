import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        String  s = "lEetcOde";

        String sortedS = sortVowels2(s);

        System.out.println("Sorted string is: " + sortedS);
    }

    // PriorityQueue
    // x2 Lists is faster (runtime) than x1 List + x1 PriorityQueue
    public static String sortVowels(String s) {
        List<Integer> vowel_pos = new ArrayList<>();
        // Sorted by ascending order with ASCII values
        PriorityQueue<Character> vowels = new PriorityQueue<>();

        for(int i=0; i<s.length();i++) {
            if(isVowel(s.charAt(i))) {
                char vowel_i = s.charAt(i);
                vowel_pos.add(i);
                vowels.add(vowel_i);
            }
        }

        StringBuilder sortedS = new StringBuilder(s);

        for(int j=0; j<vowel_pos.size();j++) {
            sortedS.setCharAt(vowel_pos.get(j),vowels.poll());
        }

        return sortedS.toString();
    }

    // List + sort
    // x2 Lists is faster (runtime) than x1 List + x1 PriorityQueue
    public static String sortVowels2(String s) {
        // Stores the vowels positions from the String
        List<Integer> vowel_pos = new ArrayList<>();
        // Stores the actual vowels from the String
        List<Character> vowels = new ArrayList<>();

        for(int i=0; i<s.length();i++) {
            if(isVowel(s.charAt(i))) {
                char vowel_i = s.charAt(i);
                vowel_pos.add(i);
                vowels.add(vowel_i);
            }
        }

        // Sort the list on ASCII values
        Collections.sort(vowels);

        StringBuilder sortedS = new StringBuilder(s);

        for(int j=0; j<vowel_pos.size();j++) {
            sortedS.setCharAt(vowel_pos.get(j),vowels.get(j));
        }

        return sortedS.toString();
    }

    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c); // Convert to lowercase
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}