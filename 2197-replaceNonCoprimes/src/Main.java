import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {287,41,49,287,899,23,23,20677,5,825};

        System.out.println(replaceNonCoprimes(nums));
    }


    // Runtime - 120ms
    public static List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {
            stack.push(num);

            // keep merging while the top 2 elements are non-coprime
            while (stack.size() > 1) {
                int a = stack.pop();
                int b = stack.pop();
                int g = findGCD(a, b);

                if (g == 1) {
                    // put them back in correct order
                    stack.push(b);
                    stack.push(a);
                    break;
                } else {
                    // reuse helper for clarity
                    int lcm = findLCM(a, b);
                    stack.push(lcm);
                }
            }
        }

        return new ArrayList<>(stack);
    }

    // Faster runtime - 45ms:
    // Use Dequeue - faster
    // Use optimized gcd function
    // Use inline calculation for lcm (faster than calling a function)
    public static List<Integer> replaceNonCoprimesFaster(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int num : nums) {
            stack.addLast(num);

            // keep merging with previous
            while (stack.size() > 1) {
                int a = stack.removeLast();
                int b = stack.removeLast();

                int g = gcd(a, b);
                if (g == 1) {
                    // push them back in order
                    stack.addLast(b);
                    stack.addLast(a);
                    break;
                } else {
                    long lcm = (long) a * b / g; // prevent overflow
                    stack.addLast((int) lcm);
                }
            }
        }

        return new ArrayList<>(stack);
    }


    // Runtime: 20ms
    public List<Integer> replaceNonCoprimesEvenFaster(int[] nums) {
        List<Integer> stack = new ArrayList<>();

        for (int num : nums) {
            while (!stack.isEmpty()) {
                int top = stack.get(stack.size() - 1);
                int g = gcd(top, num);
                if (g == 1) {
                    break;
                }
                stack.remove(stack.size() - 1);
                num = (top / g) * num;
            }
            stack.add(num);
        }
        return stack;
    }

    // Iterative gcd is faster
    private static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    // Function to find the Greatest Common Divisor (GCD) using Euclidean Algorithm
    static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
    // Function to find the Least Common Multiple (LCM)
    static int findLCM(int a, int b) {
        // LCM = (a * b) / GCD(a, b)
        return (int) ((long)a * b / findGCD(a, b));
    }

}