import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome! (type 'exit' to quit)");
            System.out.print("Insert the string to evaluate: ");
            String word = input.nextLine();

            if (word.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }


            System.out.println("The string to evaluate is: " + word);
            int length = lengthOfLastWord(word);

            System.out.println("Length of last word is: " + length);

            System.out.println("------");
        }

        input.close();
    }

    // Given a string s consisting of words and spaces, return the length of the last word in the string.
    // A word is a maximal substring consisting of non-space characters only.
    public static int lengthOfLastWord(String s) {
        //String[] words = s.split("\\s+");
        //return words[words.length-1].length();

        s = s.trim();
        int length = 0;

        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == ' ') {
                return length;
            }
            else {
                length++;
            }
        }
        return length;


        //String lastWord = words[words.length-1];
        //int length = lastWord.length();
        //System.out.println("The last word is " + lastWord + " with length " + length + ".");
        // return length;
    }
}