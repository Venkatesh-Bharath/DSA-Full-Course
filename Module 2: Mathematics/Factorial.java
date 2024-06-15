// 7. Factorials
// Explanation: The factorial of a non-negative integer n is the product of all positive integers less than or equal to n, denoted as n!.

public class Factorial {
    public static void main(String[] args) {
        int number = 5;
        long fact = factorial(number);
        System.out.println("Factorial of " + number + " is: " + fact);
    }

    public static long factorial(int number) {
        if (number == 0) {
            return 1;
        }
        return number * factorial(number - 1);
    }
}
