import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome! (type 'exit' to quit)");
            System.out.print("Insert the string haystack: ");
            String haystack = input.nextLine();

            if (haystack.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }

            System.out.print("Insert the string needle: ");
            String needle = input.nextLine();

            int index = strStr(haystack, needle);

            System.out.println("haystack = '" + haystack + "', needle = '" + needle + "'");
            System.out.println("Occurrence index is: " + index);

            System.out.println("------");
        }

        input.close();
    }

    public static int strStr(String haystack, String needle) {
        //return haystack.indexOf(needle);

        int index = -1;

        // Check the length of needle is not bigger than the actual string
        if(haystack.length() < needle.length()) {
            return index;
        }

        // Check there is an occurrence of the first letter. If so, check the next needle.length values to see if they match
        for(int i=0; i<haystack.length();i++) {
            // The needle can't be in the remaining string anymore
            if (haystack.length()-i < needle.length()) {
                break;
            }

            for (int k=0; k < needle.length(); k++) {
                if (haystack.charAt(i+k) != needle.charAt(k)) {
                    break;
                }
                if (haystack.charAt(i+k) == needle.charAt(k) && k == needle.length()-1) {
                    index = i;
                    return index;
                }
            }
        }
        return index;
    }
}