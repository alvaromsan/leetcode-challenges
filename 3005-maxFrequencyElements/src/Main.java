import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4};

        System.out.println("Frequency is: " + maxFrequencyElements(nums));
    }

    // Using Colleciton methods
    public static int maxFrequencyElementsSlower(int[] nums) {
        Arrays.sort(nums);

        int currentNum = nums[0];
        int counter = 1;

        Map<Integer, Integer> frequencyToCount = new HashMap<>();

        for (int i = 1; i < nums.length; i++) {
            if(currentNum == nums[i]) counter++;
            else {
                // Update frequency map for the previous number
                frequencyToCount.put(counter, frequencyToCount.getOrDefault(counter, 0) + counter);

                // Start new run
                currentNum = nums[i];
                counter = 1;
            }
        }

        // Handle the last run
        frequencyToCount.put(counter, frequencyToCount.getOrDefault(counter, 0) + counter);

        return  frequencyToCount.get(Collections.max(frequencyToCount.keySet()));
    }

    // Using for loops:
    // FASTER
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqToCount = new HashMap<>();
        int maxfreq = 0;

        for(int num : nums){
            freqToCount.put(num, freqToCount.getOrDefault(num,0)+1);
            maxfreq = Math.max(maxfreq, freqToCount.get(num));
        }

        int result = 0;
        for(int f : freqToCount.values()){
            if(f == maxfreq){
                result += f;
            }
        }

        return result;
    }
}