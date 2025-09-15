public class Main {
    public static void main(String[] args) {
        String text = "ahello world";
        String brokenLetters = "ad";

        int result = canBeTypedWords(text, brokenLetters);

        System.out.println(result);
    }


    // Solution using .split() and comparing text with brokenLetters
    public static int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int counter = words.length;

        for(String word_i: words) {
            outer:
            for(int i=0; i < word_i.length();i++) {
                for (int j=0; j<brokenLetters.length() ;j++) {
                    if(word_i.charAt(i) == brokenLetters.charAt(j)) {
                        counter--;
                        break outer;
                    }
                }
            }
        }
        return counter;
    }

    // Solution using boolean[] (for checks) and looping through the text (instead of split())
    public static int canBeTypedWords2(String text, String brokenLetters) {
        boolean[] broken = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            broken[c - 'a'] = true;
        }

        // Starts with 1 since the last "word" won't have a space
        int count = 1;
        boolean valid = true;

        for (char ch : text.toCharArray()) {
            if (ch == ' ') {
                valid = true;
                count++;
            } else if (broken[ch - 'a'] && valid) {
                count--;
                valid = false;
            }
        }

        return Math.max(count, 0);
    }
}