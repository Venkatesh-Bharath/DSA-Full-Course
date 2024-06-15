// 6. LCM and HCF
// Explanation:

// LCM (Least Common Multiple): The smallest positive integer that is divisible by both numbers.
// HCF (Highest Common Factor) or GCD (Greatest Common Divisor): The largest positive integer that divides both numbers without leaving a remainder.


public class LcmHcf {
    public static void main(String[] args) {
        int a = 12, b = 15;
        int lcm = lcm(a, b);
        int hcf = hcf(a, b);

        System.out.println("LCM of " + a + " and " + b + " is: " + lcm);
        System.out.println("HCF of " + a + " and " + b + " is: " + hcf);
    }

    public static int hcf(int a, int b) {
        if (b == 0) {
            return a;
        }
        return hcf(b, a % b);
    }

    public static int lcm(int a, int b) {
        return (a * b) / hcf(a, b);
    }
}
