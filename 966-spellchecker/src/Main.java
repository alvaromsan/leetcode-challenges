import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] wordlist = {"KiTe", "kite", "hare", "Hare"};
        String[] queries = {"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};
        //String[] wordlist = {"zeo","Zuo"};
        //String[] queries = {"zuo"};

        String[] result = spellchecker(wordlist, queries);

        System.out.println("Result is: " + Arrays.toString(result));

    }


    // Going to check:
    // 1) If the word is exactly
    // 2) Or if it matches case-insensitive
    // 3) Or if it matches in consonants (at least)
    public static String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();

        for (String word : wordlist) {
            exactWords.add(word);

            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);

            String masked = maskVowels(lower);
            vowelInsensitive.putIfAbsent(masked, word);
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            if (exactWords.contains(query)) {
                result[i] = query;
                continue;
            }

            String lower = query.toLowerCase();
            if (caseInsensitive.containsKey(lower)) {
                result[i] = caseInsensitive.get(lower);
                continue;
            }

            String masked = maskVowels(lower);
            result[i] = vowelInsensitive.getOrDefault(masked, "");
        }

        return result;
    }

    private static String maskVowels(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isAVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    // We are looping through all the wordList (and vowels of each), queries.length times
    public static String[] spellcheckerSlow(String[] wordlist, String[] queries) {
        int n = queries.length;
        String[] result = new String[n];

        for(int i=0; i<n; i++) {
            String val = "";
            boolean foundCaseInsensitive = false;
            for(String word: wordlist) {
                // The word can't match if they don't have the same length
                if(queries[i].length() != word.length()) continue;
                // Word exactly matches the word
                if(word.equals(queries[i])){
                    val = queries[i];
                    break; // we can only be 100% sure if the word matches completely
                } else if (word.equalsIgnoreCase(queries[i]) && !foundCaseInsensitive) {
                    val = word;
                    foundCaseInsensitive = true;
                } else if (val.isEmpty() && !foundCaseInsensitive){
                    boolean isMatching = true;
                    for(int j=0; j< word.length();j++) {
                        // Vowel ?
                        char aC = queries[i].toLowerCase().charAt(j);
                        char bC = word.toLowerCase().charAt(j);
                        boolean aIsVowel = isAVowel(aC);
                        boolean bIsAVowel = isAVowel(bC);

                        // Both are vowel
                        if(aIsVowel && bIsAVowel) continue;
                        // Only one is a vowel
                        else if ((aIsVowel != bIsAVowel)) {
                            isMatching=false;
                            break;
                        }
                        // Both are consonant
                        else {
                            if(aC != bC) {
                                isMatching=false;
                                break;
                            }
                        }
                    }
                    if (isMatching) {
                        val = word;
                    }
                }
            }
            result[i] = val;
        }
        return result;
    }

    public static boolean isAVowel(char c) {
        // Convert to lowercase for case-insensitive comparison
        c = Character.toLowerCase(c);

        return (c == 'a' || c == 'e' || c == 'i' ||
                c == 'o' || c == 'u');
    }
}