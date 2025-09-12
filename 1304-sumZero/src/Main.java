import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 2;

        int[] array = sumZero(n);

        System.out.println("Array is: " + Arrays.toString(array));
    }

    public static int[] sumZero(int n) {
        if(n == 1) {
            return new int[]{0};
        }

        int counter = 1;
        boolean odd_n = n%2 == 1;
        int[] result = new int[n];

        for(int i=0;i<n-1;i+=2, counter++){
            result[i] = counter;
            result[i+1] = -counter;
        }
        if(odd_n){
            result[n-1] = 0;
        }
        return result;
    }
}