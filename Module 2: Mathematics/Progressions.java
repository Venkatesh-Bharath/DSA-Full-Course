// 2. Arithmetic and Geometric Progressions
// Explanation:

// Arithmetic Progression (AP): A sequence of numbers in which the difference of any two successive members is a constant. Formula for the nth term: a + (n-1)d
// Geometric Progression (GP): A sequence of numbers where each term after the first is found by multiplying the previous term by a fixed, non-zero number called the common ratio. Formula for the nth term: a * r^(n-1)

public class Progressions {
    public static void main(String[] args) {
        int a = 2; // first term
        int d = 3; // common difference
        int r = 2; // common ratio
        int n = 5; // nth term

        int nthTermAP = a + (n - 1) * d;
        int nthTermGP = (int)(a * Math.pow(r, n - 1));

        System.out.println("Nth term of AP: " + nthTermAP);
        System.out.println("Nth term of GP: " + nthTermGP);
    }
}

