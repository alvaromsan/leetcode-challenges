public class Main {
    public static void main(String[] args) {
        int n = 11;

        int[] a_b = getNoZeroIntegers(n);

        System.out.println("The a,b numbers that make n=a+b are: a --> " + a_b[0] + ", b --> " + a_b[1]);
    }


    // String evaluation
    public static int[] getNoZeroIntegers(int n) {
        int a = 1;
        int b = n-1;
        while (String.valueOf(a).contains("0") || String.valueOf(b).contains("0")){
            a++;
            b--;
        }
        return new int[]{a,b};
    }

    // Integer evaluation
    public int[] getNoZeroIntegersCustom(int n) {
        int a = 1;
        int b = n-1;
        while (!isValid(a) || !isValid(b)){
            a++;
            b--;
        }
        return new int[]{a,b};
    }
    private boolean isValid(int num) {
        while (num > 0) {
            if (num % 10 == 0) return false;
            num /= 10;
        }
        return true;
    }
}