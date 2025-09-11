import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // ANSI escape codes for color
        final String RESET = "\u001B[0m";
        final String GREEN = "\u001B[32m";
        final String RED = "\u001B[31m";
        final String CYAN = "\u001B[36m";

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Please insert a word to validate (type 'exit' to quit): ");
            String word = input.next();

            if (word.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }

            boolean isValid = validWordMatches(word);

            String coloredWord = CYAN + word + RESET;
            String coloredResult = isValid ? GREEN + "true" + RESET : RED + "false" + RESET;

            System.out.println(coloredWord + " --> " + coloredResult);
        }

        input.close();
    }

    public static boolean validWordMatches(String word) {
        // A minimum of 3 characters
        if (word.length() < 3) {
            return false;
        }

        // Only digits (0-9), and English letters (uppercase and lowercase).
        if(!word.matches("[a-zA-Z0-9]+")) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        // At least one vowel
        if (word.matches(".*[aeiouAEIOU].*")) hasVowel = true;

        // At least one consonant
        if (word.matches(".*[^aeiouAEIOU\\d].*")) hasConsonant = true;

        return hasVowel && hasConsonant;

        /*
        // Combined regex: only letters/digits + at least one vowel + at least one consonant
        String pattern = "^(?=.*[aeiouAEIOU])(?=.*[^aeiouAEIOU\\d])[a-zA-Z0-9]+$";

        return word.matches(pattern);
        */
    }

    // Faster execution than with word.matches
    public static boolean validWordForloop(String word) {
        // A minimum of 3 characters
        if (word.length() < 3) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char c : word.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                // Invalid character found
                return false;
            }
            if ("aeiouAEIOU".indexOf(c) >= 0) {
                hasVowel = true;
            } else if (Character.isLetter(c)) {
                // It's a letter but not a vowel, so consonant
                hasConsonant = true;
            }
        }
        
        return hasVowel && hasConsonant;
    }
}