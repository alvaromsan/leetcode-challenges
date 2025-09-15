public class Main {
    public static void main(String[] args) {
        String s = "successes";

        int result = maxFreqSum(s);
        System.out.println("The frequency (added) of the most occurrence for vowels and for consonants is: " + result);
    }

    public static int maxFreqSum(String s) {
        int[] counter = new int[26];

        for (char ch: s.toCharArray()) {
            counter[ch - 'a']++;
        }

        int maxC = 0;
        int maxV = 0;

        for (int i=0; i<counter.length;i++) {
            // Indexes in the alphabet that vowels are located
            if(i == 0 || i == 4 || i == 8 || i == 14 || i == 20) {
                if(counter[i] > maxV) {
                    maxV = counter[i];
                }
            }
            else {
                if(counter[i] > maxC) {
                    maxC = counter[i];
                }
            }
        }

        return maxC + maxV;
    }
}