public class Main {
    public static void main(String[] args) {
        String s = "sloalo";

        boolean doesAliceWin = doesAliceWin(s);

        System.out.println("Does Alice wins? " + (doesAliceWin?"Yes":"No"));
    }


    // Alice always wins because except when no vowels:
    // 1) If the vowels counter is odd --> She wins first round
    // 2) If the vowels counter is even:
    //     - (1st round) Alice removes all vowels except 1
    //     - (2nd round) Bob can't remove any vowels (cuz he can only take even number)
    //     - (3rd round) Alice removes the last vowel
    // 3) If no vowels: There is no valid play for Alice in her first turn, so Alice loses the game.
    public static boolean doesAliceWin(String s) {
        for(int i=0; i<s.length();i++) {
            char c = s.charAt(i);
            // No need to consider uppercase since everything is lowercase
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return true; // if there is a vowel, Alice wins
            }
        }
        // No vowels
        return false;
    }

    // boolean[] lookup for vowels
    public static boolean doesAliceWin2(String s) {
        boolean[] isVowel = new boolean[26]; // 26 lowercase English letters. boolean default is "false"
        isVowel[0] = true; // 'a' - 'a'
        isVowel['e' - 'a'] = true;
        isVowel['i' - 'a'] = true;
        isVowel['o' - 'a'] = true;
        isVowel['u' - 'a'] = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // No need to consider uppercase since everything is lowercase
            if (isVowel[c - 'a']) {
                return true; // if there is a vowel, Alice wins
            }
        }
        // No vowels
        return false;
    }
}