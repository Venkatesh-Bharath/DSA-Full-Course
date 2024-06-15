// 8. Permutations and Combinations
// Explanation:

// Permutations: The arrangement of objects in a specific order. Formula: nPr = n! / (n-r)!
// Combinations: The selection of objects without regard to the order. Formula: nCr = n! / (r! * (n-r)!)public class PermutationsCombinations {
    public static void main(String[] args) {
        int n = 5, r = 3;
        long permutations = permutation(n, r);
        long combinations = combination(n, r);

        System.out.println("Permutations (nPr): " + permutations);
        System.out.println("Combinations (nCr): " + combinations);
    }

    public static long factorial(int number) {
        if (number == 0) {
            return 1;
        }
        return number * factorial(number - 1);
    }

    public static long permutation(int n, int r) {
        return factorial(n) / factorial(n - r);
    }

    public static long combination(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }
}
